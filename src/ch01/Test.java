package ch01;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Test {

   private int userId;
   private int id;
   private String title;
   private boolean completed;
   
}
