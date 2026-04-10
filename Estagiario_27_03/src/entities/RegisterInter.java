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
        // Validação do nome - apenas if/else (não há exceção real aqui)
        do {
            System.out.println("\nEscreve o nome do estagiário abaixo: ");
            name = scan.nextLine();

            if(name.isEmpty()) {
                System.out.println("\n####################################################");
                System.out.println("Erro: O nome não pode ser vazio");
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
            } else if (name.length() < 10) {
                System.out.println("\n####################################################");
                System.out.println("Erro: O nome não pode ter menos que 10 caracteres");
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
            }
        } while(name.isEmpty() || name.length() < 10);

        // Validação do email - apenas if/else (não há exceção real aqui)
        do {
            System.out.println("\nDigite o email do Estagiário: ");
            email = scan.nextLine();

            if(email.isEmpty()) {
                System.out.println("\n####################################################");
                System.out.println("Erro: Email do aluno não pode ser vazio!");
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
            } else if(email.length() < 15) {
                System.out.println("\n####################################################");
                System.out.println("Erro: Email deve conter mais que 15 caracteres!");
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
            } else if(!email.contains("@")) {
                System.out.println("\n####################################################");
                System.out.println("Erro: Email deve conter o caractere '@'!");
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
            } else if(!email.contains(".")) {
                System.out.println("\n####################################################");
                System.out.println("Erro: Email deve conter o caractere '.'!");
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
            }
        } while(email.isEmpty() || email.length() < 15 || !email.contains("@") || !email.contains("."));
        
        // Validação do curso - apenas if/else (não há exceção real aqui)
        do {
            System.out.println("\nDigite o curso do Estagiário: ");
            curso = scan.nextLine();

            if(curso.isEmpty()) {
                System.out.println("\n####################################################");
                System.out.println("Erro: O curso não pode ser vazio!");
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
            }
        } while(curso.isEmpty());

        // Validação da média - try-catch para NumberFormatException (usuário pode digitar texto)
        // O if/else cuida da validação de intervalo
        do {
            try {
                System.out.println("\nDigite a média geral do Estagiário (0 a 10): ");
                generealAverage = Double.parseDouble(scan.nextLine());

                if(generealAverage < 0 || generealAverage > 10) {
                    System.out.println("\n####################################################");
                    System.out.println("Erro: A média deve ser entre 0 e 10!");
                    System.out.println("####################################################");
                    System.out.print("\nTente novamente...\n");
                    generealAverage = -1;
                }
            } catch(NumberFormatException e) {
                generealAverage = -1;
                System.out.println("\n####################################################");
                System.out.println("Erro: Digite um número válido!");
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
            }
        } while(generealAverage < 0 || generealAverage > 10);

        // Validação da idade - try-catch para NumberFormatException (usuário pode digitar texto)
        // O if/else cuida da validação de intervalo
        do {
            try {
                System.out.println("\nDigite a idade do Estagiário (16 a 30): ");
                age = Integer.parseInt(scan.nextLine());

                if(age < 16 || age > 30) {
                    System.out.println("\n####################################################");
                    System.out.println("Erro: A idade deve ser entre 16 e 30 anos!");
                    System.out.println("####################################################");
                    System.out.print("\nTente novamente...\n");
                    age = -1;
                }
            } catch(NumberFormatException e) {
                age = -1;
                System.out.println("\n####################################################");
                System.out.println("Erro: Digite um número inteiro válido!");
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
            }
        } while(age < 16 || age > 30);

        // Validação do gênero - apenas if/else (não há exceção real aqui)
        do {
            System.out.println("\nDigite o gênero do Estagiário (M ou F): ");
            gender = scan.nextLine();

            if(!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F")) {
                System.out.println("\n####################################################");
                System.out.println("Erro: Gênero inválido! Digite apenas M ou F.");
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
            }
        } while(!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F"));

        Inter inter = new Inter(name, email, curso, generealAverage, age, gender);
        interList.add(inter);

        System.out.println("\nDeseja cadastrar outro estagírio? (S/N)");
        continueRegister = scan.nextLine();
      } while (continueRegister.equalsIgnoreCase("S"));

      System.out.println("\n----  Dados dos Estagiários cadastrados  ----");
      for (Inter i : interList) {
           System.out.println(i);
      }

   }

}
