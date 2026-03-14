package entities;

import java.util.Scanner;

public class RegisterTeacher {
   
   private int age = 0;
   private String name = "";
   private int area = 0;
   private int timeExperience = 0;

   public void register(Scanner sc) {
      Validations val = new Validations();
      String continueRegister = "";
      
      //registrando professores (quantidade indeterminada)
      do {
         sc.nextLine();
         //validação nome
         do {
            try {
                System.out.print("\nWhat is the professor's name?: ");
                name = sc.nextLine();

                if(name.length() < 3)
                    throw new Exception("The name must be at least 3 characters long.");
            } catch(Exception e) {
                System.out.println("\n####################################################");
                System.out.println("Error: " + e.getMessage());
                System.out.println("####################################################");
                System.out.print("\nTry again\n");
            }
         } while (name.length() < 3);

         //validação idade
         do {
           try{
              System.out.print("\nHow old is the teacher?: ");
              age = sc.nextInt();

              if(age < 18)
                throw new Exception("The minimum age is 18 years.");
           } catch(Exception e) {
               System.out.println("\n####################################################");
               System.out.println("Error: " + e.getMessage());
               System.out.println("####################################################");
               System.out.print("\nTry again\n");
               sc.nextLine();
               age = -1;
           }
         } while (age < 18);

         //tempo de experiência em anos
         do {
            try{
              System.out.print("\nHow many years of experience does the teacher have?: ");
              timeExperience = sc.nextInt();

              if((age >= 18 && age <= 30) && timeExperience >= 5) 
                 throw new Exception("This teacher is at the beginning of his professional career; there's no way he could have more than 5 years of experience.");

              if(timeExperience < 0)
                throw new Exception("Experience time cannot be negative.");

              if(timeExperience >= 65) 
                throw new Exception("The teacher's experience limit in years is 64.");
           } catch(Exception e) {
               System.out.println("\n####################################################");
               System.out.println("Error: " + e.getMessage());
               System.out.println("####################################################");
               System.out.print("\nTry again\n");
               sc.nextLine();
               timeExperience = -1;
           }

         } while(timeExperience < 0 || timeExperience >= 65);


         //validação para a área
         do {
            try {
                System.out.println("\nChoose the professor's area of expertise:");
                System.out.println("\n-------------------");
                System.out.println("1- Mathematics");
                System.out.println("2- Biology");
                System.out.println("3- Other");
                System.out.println("-------------------");
                System.out.print("\nEnter a number here: ");
                area = sc.nextInt();

                if(area <= 0 || area > 3) 
                    throw new Exception("The teacher's chosen area must be between 1 and 3.");

                areaTeacher(area);
            } catch(Exception e) {
               System.out.println("\n####################################################");
               System.out.println("Error: " + e.getMessage());
               System.out.println("####################################################");
               System.out.print("\nTry again\n");
               sc.nextLine();
               area = -1;
            }

         } while(area <= 0 || area > 3);

          System.out.println("\n========== Teacher Registered ==========");
          System.out.println("Name: " + name);
          System.out.println("Age: " + age);
          System.out.println("Experience: " + timeExperience + " years");
          System.out.println("Area: " + areaTeacher(area));
          System.out.println("=========================================\n");

          int counter = val.getCandidateCounter();
          val.setCandidateCounter(counter + 1);

          //chamada da classe validations para pontuação
          int score = val.calculateScore(age, timeExperience, area);
          placedTeachers(score, val, name);

          //perguntando se deseja cadastrar outro professor
          System.out.print("Do you want to register another teacher? (y/n): ");
          sc.nextLine();
          continueRegister = sc.nextLine();

      } while(continueRegister.equalsIgnoreCase("y"));

      //mostrando o resultado
      System.out.println(val.toString());
   }

   //esccolha de área professor
   public String areaTeacher(int area) {
       String textArea = "";   

       switch (area) {
          case 1:
          textArea = "Mathematics";
          break;
          case 2:
          textArea = "Biology";
          break;
          case 3: 
          textArea = "Other";
       }

       return textArea;
   }

   //verificando professores com 3 maiores pontuações
   public void placedTeachers(int score, Validations val, String name) {
      int[] scores = val.getScores();
      String[] names = val.getCandidates();

      if(val.getCandidateCounter() <= 3) {
         if(val.getCandidateCounter() == 1) {
            scores[0] = score;
            names[0] = name;
         }

         if(val.getCandidateCounter() == 2) {   
            scores[1] = score;
            names[1] = name;
         }

         if(val.getCandidateCounter() == 3) {   
            scores[2] = score;
            names[2] = name;
         }
      } else {
         int smaller = scores[0];
         int smallerIndex = 0;
         
         for(int i = 0; i < scores.length; i++) {
            if(scores[i] < smaller) {
               smaller = scores[i];
               smallerIndex = i;
            }
         }

         if(score > smaller) {
            scores[smallerIndex] = score;
            names[smallerIndex] = name;
         }
      }
   }
}
