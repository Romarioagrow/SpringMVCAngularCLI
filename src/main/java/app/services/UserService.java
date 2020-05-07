package app.services;

/*import app.domain.User;
import app.domain.roles.Role;
import app.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
  private final UserRepo userRepo;
  //private final PasswordEncoder passwordEncoder;
  @Autowired
  public UserService(UserRepo userRepo*//*, PasswordEncoder passwordEncoder*//*) {
    this.userRepo = userRepo;
    //this.passwordEncoder = passwordEncoder;
  }
  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return new BCryptPasswordEncoder(8);
  }
  @Autowired
  PasswordEncoder passwordEncoder;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println("loadUserByUsername: " + username);
    System.out.println(username);
    return userRepo.findByUsername(username);
  }
  public User createAdmin() {
    User adminUser = new User();
    adminUser.setPassword(passwordEncoder.encode("admin"));
    adminUser.setUsername("admin");
    adminUser.setActive(true);
    adminUser.setRoles(Collections.singleton(Role.ADMIN));
    userRepo.save(adminUser);
    return adminUser;
  }
  public User createUser() {
    User user = new User();
    user.setPassword(passwordEncoder.encode("user"));
    user.setUsername("user");
    user.setActive(true);
    user.setRoles(Collections.singleton(Role.USER));
    userRepo.save(user);
    return user;
  }
}*/
