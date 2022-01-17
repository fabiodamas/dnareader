package br.com.fabio.dnareader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Home {
  
  @GetMapping("/")
  public String home() {
      // return "redirect:/swagger-ui.html";
      return "redirect:/swagger-ui/index.html";
  }

}
