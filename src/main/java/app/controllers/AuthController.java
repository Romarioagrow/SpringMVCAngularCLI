package app.controllers;

import app.configs.SecurityAuthenticationProvider;
import app.domain.User;
import app.domain.roles.Role;
import app.services.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Log
@RestController
@RequestMapping("/api/auth")

public class AuthController {
  private final UserService userService;
  private final SecurityAuthenticationProvider authProvider;

  @Autowired
  public AuthController(UserService userService, SecurityAuthenticationProvider provider) {
    this.userService = userService;
    this.authProvider = provider;
  }

  /*Request user credentials in json*/
  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/login")
  private ResponseEntity<?> login(@RequestBody Map<String, String> credentials, HttpServletRequest request) {
    log.info("CONTROLLER: PostMapping LOGIN()");

    try
    {
      Authentication resultAuth = authProvider.processLogin(credentials, request);
      log.info("Principal: " +  resultAuth.getPrincipal().toString());

      if (resultAuth.getAuthorities().contains(Role.ADMIN)) {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
      }
    }
    catch (BadCredentialsException e) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }

  //check AuthenticationPrincipal
  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/checkAuthentication")
  private User checkAuthentication(@AuthenticationPrincipal User user) {
    log.info("AuthenticationPrincipal(): " + user);
    return user;
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/checkAuth")
  private User checkAuth(@AuthenticationPrincipal User user) {
    //SecurityContext securityContext = SecurityContextHolder.getContext();
    //log.info("checkAuth securityContext.getAuthentication().isAuthenticated(): " + securityContext.getAuthentication().isAuthenticated());
    //log.info("checkAuth securityContext.getAuthentication().getPrincipal().toString(): " + securityContext.getAuthentication().getPrincipal().toString());
    if (user == null) {
      System.out.println("NO USER!");
    }
    else System.out.println("CHECK USER: " + user.toString());
    return user;
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/createAdmin")
  private User createAdmin() {
    return userService.createAdmin();
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/createUser")
  private User createUser() {
    return userService.createUser();
  }

}
