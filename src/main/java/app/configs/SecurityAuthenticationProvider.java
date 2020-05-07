package app.configs;

import app.domain.User;
import app.repos.UserRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;

@Log
@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserRepo userRepo;


  /*Custom authentication process with json credentials*/
  public Authentication processLogin(Map<String, String> credentials, HttpServletRequest request) {
    log.info("SecurityAuthenticationProvider: processLogin()");
    log.info("Credentials: " + credentials.toString());

    String username = credentials.get("username");
    String password = credentials.get("password");

    Authentication authentication;
    User user = userRepo.findByUsername(username);

    if (user == null) {
      log.warning("USER IS NULL!");
      throw new BadCredentialsException("invalid_username_or_pass");
    }

    if (!passwordEncoder.matches(password, user.getPassword())) {
      log.warning("PASSWORD IS WRONG!");
      throw new BadCredentialsException("invalid_username_or_pass");
    }

    Collection<? extends GrantedAuthority> grantedAuths = user.getAuthorities();

    authentication = new UsernamePasswordAuthenticationToken(user, password, grantedAuths);
    log.info("Authentication processLogin(): " + authentication.toString());

    SecurityContext securityContext = SecurityContextHolder.getContext();
    securityContext.setAuthentication(authentication);
    log.info("Authentication processLogin() securityContext: " + securityContext.getAuthentication().getPrincipal().toString());

    /*Create a new session and add the security context*/
    HttpSession session = request.getSession(true);
    session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

    return authenticate(authentication);
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    return authentication;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
