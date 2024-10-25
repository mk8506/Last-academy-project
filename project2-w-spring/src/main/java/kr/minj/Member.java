package kr.minj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Member {
  @Value("${null}")
  private String email;
  @Value("${null}")
  private String pw;

  // private static Member current;
  
  // public static Member getInstance() {
  //   if (current == null) {
  //     current = new Member();
  //   }
  //   return current;
  // }
  // public static void freeInstance() {
  //   current = null;
  // }
  // private Member() {
  // }
  
  
}
