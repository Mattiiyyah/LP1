package application;

import java.util.Scanner;
import entities.RegisterTeacher;

public class Teacher {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      RegisterTeacher rt = new RegisterTeacher();
      rt.register(sc);

      sc.close();
   }
}
