package application;

import java.util.Scanner;
import entities.RegisterTeacher;

public class Teacher {
   public static void main(String[] args) {
      Scanner reader = new Scanner(System.in);

      RegisterTeacher registerTeacher = new RegisterTeacher();
      registerTeacher.register(reader);

      reader.close();
   }
}
