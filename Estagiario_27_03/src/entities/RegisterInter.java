package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterInter {

   //criando a lista de armazenamento de cada estagiário
   private List<Inter> interList = new ArrayList<>();

   //guardando os dados
   public List<Inter> getInterList() {
      return interList;
   }

   public void register(Scanner scan) {

      String name = "";
      String email = "";
      String curso = "";
      double generealAverage;
      int age;
      String gender;

      String continueRegister = "";

      //registrando quantidade indeterminanda de Estágiários
      do {
        do {
            try {
                System.out.println("\nEscreve o nome do estagiário abaixo: ");
                name = scan.nextLine();

                if(name.isEmpty()) {
                    throw new Exception("O nome não pode ser vazio");
                } else if (name.length() < 10) {
                    throw new Exception("O nome não pode ter menos que 10 caracteres");
                }
            } catch(Exception e) {
                System.out.println("\n####################################################");
                System.out.println("Erro: " + e.getMessage());
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
                System.out.println("Digite o nome novamente abaixo: ");
            }
        } while(name.isEmpty() || name.length() < 10);

        do {
            try {
                System.out.println("\nDigite o email do Estagiário: ");
                email = scan.nextLine();

                if(email.isEmpty()) {
                    throw new Exception("Email do aluno não pode ser vazio!");
                } else if(email.length() < 15) {
                    throw new Exception("Email deve conter mais que 15 caracteres!");
                } else if(!email.contains("@")) {
                    throw new Exception("Email deve conter o caractere '@'!");
                } else if(!email.contains(".")) {
                    throw new Exception("Email deve conter o caractere '.'!");
                }
            } catch(Exception e) {
                System.out.println("\n####################################################");
                System.out.println("Erro: " + e.getMessage());
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
                System.out.println("Digite o email novamente abaixo: ");
            }
        } while(email.isEmpty() || email.length() < 15 || !email.contains("@") || !email.contains("."));
        
        do {
            try {
                System.out.println("\nDigite o curso do Estagiário: ");
                curso = scan.nextLine();

                if(curso.isEmpty()) {
                    throw new Exception("O curso não pode ser vazio!");
                } 
            } catch(Exception e) {
                System.out.println("\n####################################################");
                System.out.println("Erro: " + e.getMessage());
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
                System.out.println("Digite o curso novamente abaixo: ");
            }
        } while(curso.isEmpty());

        do {
            try {
                System.out.println("\nDigite a média geral do Estagiário (0 a 10): ");
                generealAverage = Double.parseDouble(scan.nextLine());

                if(generealAverage < 0 || generealAverage > 10) {
                    throw new Exception("A média deve ser entre 0 e 10!");
                }
            } catch(Exception e) {
                generealAverage = -1;
                System.out.println("\n####################################################");
                System.out.println("Erro: " + e.getMessage());
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
                System.out.println("Digite a média novamente abaixo: ");
            }
        } while(generealAverage < 0 || generealAverage > 10);

        do {
            try {
                System.out.println("\nDigite a idade do Estagiário (16 a 30): ");
                age = scan.nextInt();

                if(age < 16 || age > 30) {
                    throw new Exception("A idade deve ser entre 16 e 30 anos!");
                }
            } catch(Exception e) {
                age = -1;
                System.out.println("\n####################################################");
                System.out.println("Erro: " + e.getMessage());
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
                System.out.println("Digite a idade novamente abaixo: ");
            }
        } while(age < 16 || age > 30);

        do {
            try {
                System.out.println("\nDigite o gênero do Estagiário (M ou F): ");
                gender = scan.next();

                if(!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F")) {
                    throw new Exception("Gênero inválido! Digite apenas M ou F.");
                }
            } catch(Exception e) {
                gender = "G";
                System.out.println("\n####################################################");
                System.out.println("Erro: " + e.getMessage());
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
                System.out.println("Digite o gênero novamente abaixo: ");
            }
        } while(!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F"));

        Inter inter = new Inter(name, email, curso, generealAverage, age, gender);
        interList.add(inter);

        System.out.println("\nDeseja cadastrar outro estagírio? (S/N)");
        continueRegister = scan.next();
        scan.nextLine();
      } while (continueRegister.equalsIgnoreCase("S"));

      System.out.println("\n----  Dados dos Estagiários cadastrados  ----");
      for (Inter i : interList) {
           System.out.println(i);
      }

   }

}
