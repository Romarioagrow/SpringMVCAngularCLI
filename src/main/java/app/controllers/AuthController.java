package app.controllers;

import app.configs.SecurityAuthenticationProvider;
import app.domain.User;
import app.domain.roles.Role;
import app.repos.UserRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

@Log
@RestController
@RequestMapping("/api/auth")

public class AuthController {
  private final PasswordEncoder passwordEncoder;
  private final UserRepo userRepo;

  private final SecurityAuthenticationProvider provider;

  @Autowired
  public AuthController(PasswordEncoder passwordEncoder, UserRepo userRepo, SecurityAuthenticationProvider provider) {
    this.passwordEncoder = passwordEncoder;
    this.userRepo = userRepo;
    this.provider = provider;
  }

  /*Request user credentials in json*/
  @PostMapping("/login")
  private ResponseEntity<?> login(@RequestBody Map<String, String> credentials, HttpServletRequest request) {
    log.info("CONTROLLER: PostMapping LOGIN()");

    Authentication resultAuth = provider.processLogin(credentials, request);
    log.info("resultAuth: " +  resultAuth.getPrincipal().toString());

    ///
    return new ResponseEntity<>(HttpStatus.OK);
  }


  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/checkAuth")
  private User checkAuth(@AuthenticationPrincipal User user) {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    log.info("checkAuth securityContext.getAuthentication().isAuthenticated(): " + securityContext.getAuthentication().isAuthenticated());
    log.info("checkAuth securityContext.getAuthentication().getPrincipal().toString(): " + securityContext.getAuthentication().getPrincipal().toString());

    if (user == null) {
      System.out.println("NO USER!");
    }
    else System.out.println("CHECK USER: " + user.toString());

    return user;
  }



  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/createAdmin")
  private User createAdmin() {
    /// return userService.createAdmin();
    User adminUser = new User();
    adminUser.setPassword(passwordEncoder.encode("admin"));
    adminUser.setUsername("admin");
    adminUser.setActive(true);
    adminUser.setRoles(Collections.singleton(Role.ADMIN));
    userRepo.save(adminUser);
    return adminUser;
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/createUser")
  private User createUser() {
    /// return userService.createUser();
    User user = new User();
    user.setPassword(passwordEncoder.encode("user"));
    user.setUsername("user");
    user.setActive(true);
    user.setRoles(Collections.singleton(Role.USER));
    userRepo.save(user);
    return user;
  }




}
