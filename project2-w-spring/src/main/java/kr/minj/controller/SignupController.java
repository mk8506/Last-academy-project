package kr.minj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.minj.Member;
import kr.minj.helper.FileHelper;


@Controller
public class SignupController {
  @Autowired
  private FileHelper fileHelper = null; //create an object here

  @Autowired
  private Member member;

  /**
   * show signed up user's email & pw
   * @return signup home page
   */
  @GetMapping("/account/signup/home")
  public String home() {
    //vari for file path
    String path = "src/main/resources/templates/account/signup/home.html";
    //read home.html
    String template = null;
    try {
      template = fileHelper.readString(path);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    //get userEmail from the field of a singleton pattern class

    //replace {{}} to saved data
    template = template.replace("{{userEmail}}", member.getEmail());

    return "account/signup/home";
  }  
}
