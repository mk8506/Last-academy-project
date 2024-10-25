package kr.minj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatController {
  @GetMapping("/get/cat")
  public String home() {
    return "get/category";
  }
}