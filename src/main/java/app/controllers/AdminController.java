package app.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/*@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")*/
public class AdminController {

  @GetMapping("/admin")
  @PreAuthorize("hasAuthority('ADMIN')")
  public String adminPage() {
    System.out.println("ADMIN PAGE");
    return "admin-page.html";
    /// return "redirect:/admin";
  }

  @GetMapping("/user")
  @PreAuthorize("hasAuthority('USER')")
  public String userPage() {
    System.out.println("USER PAGE");
    return "user-page.html";
    /// return "redirect:/user";
  }
}
