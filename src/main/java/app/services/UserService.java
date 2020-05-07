package app.services;

import app.domain.User;
import app.domain.roles.Role;
import app.repos.UserRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Log
@Service
public class UserService {
  private final UserRepo userRepo;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
    this.userRepo = userRepo;
    this.passwordEncoder = passwordEncoder;
  }

  public User createUser(String username, String password, Role role) {
    if (userRepo.findByUsername(username) == null) {
      User user = new User();
      user.setPassword(passwordEncoder.encode(password));
      user.setUsername(username);
      user.setActive(true);
      user.setRoles(Collections.singleton(role));
      userRepo.save(user);
      System.out.println("Created user: " + user.toString());
      return user;
    }
    log.warning("USER ALREADY EXISTS!");
    return null;
  }

  public User createAdmin() {
    return createUser("admin", "admin", Role.ADMIN);
  }

  public User createUser() {
    return createUser("user", "user", Role.USER);
  }
}
