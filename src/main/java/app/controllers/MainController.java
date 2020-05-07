package app.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

  /*@GetMapping*//*("/")*//*
  public String mainMethod() {
    System.out.println("mainMethod");
    return "index.html";
  }*/


  @GetMapping("/admin")
  @PreAuthorize("hasAuthority('ADMIN')")
  public String adminPage() {
    System.out.println("ADMIN PAGE");
    return "admin-page.html";
  }



}
