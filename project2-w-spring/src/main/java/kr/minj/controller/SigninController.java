package kr.minj.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class SigninController {
/**
 * show email and password (just a sample of my account page)
 * @param model
 * @param request
 * @param userEmail
 * @param userPassword
 * @return
 */
  @GetMapping("/account/home")
  public String home(Model model,
  HttpServletRequest request,
    @RequestParam("user_name") String userEmail,
    @RequestParam("user_pw") String userPassword
    ) {
      model.addAttribute("userEmail", userEmail);
      model.addAttribute("userPassword", userPassword);

      HttpSession session = request.getSession();
      Object signedMembers = session.getAttribute("signedMembers");
      
      if (signedMembers != null) {
        model.addAttribute("signedMembers", signedMembers);
      } else {
        System.out.println("no signed member");
      }

      return "/account/home";
  }

/**
 * save the input data
 * @param request
 * @param response
 * @param userEmail
 * @param userPassword
 * @return
 */
  @SuppressWarnings("null")
  @PostMapping("/account/signin-active")
  public String signinActive(
    HttpServletRequest request,
    HttpServletResponse response,
    @RequestParam("user_email") String userEmail,
    @RequestParam("user_pw") String userPassword
    ) {
      //wrong email / pw
      if (!userEmail.equals("email") || !userPassword.equals("pw")) {
        response.setStatus(403);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = null;
        try {
          out = response.getWriter();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        out.println("<script>");
        out.println("alert('email or password doesn't match')");
        out.println("history.back()");
        out.println("</script>");
        out.flush();
        return null;
      }

      int signedMembers = 0;
      signedMembers++;

      HttpSession session = request.getSession();
      session.setAttribute("signedMembers", signedMembers);

      return "redirect:/account/home";
  }
}
