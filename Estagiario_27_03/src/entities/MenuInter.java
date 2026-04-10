package entities;

import java.util.List;
import java.util.Scanner;

public class MenuInter {
    public void menu(Scanner scan, List<Inter> interList) {
        DisplayMenu displayMenu = new DisplayMenu();
        displayMenu.showMenu();
        String continueMenu = "";
        int choose = 0;

        do {
            if (continueMenu.equalsIgnoreCase("S")) {
                displayMenu.showMenu();
            }

            System.out.print("\nEscolha uma opção: ");
            choose = scan.nextInt();

            switch (choose) {

                // Mostrar candidatos maiores que uma idade informada
                case 1:
                    System.out.print("\nDigite a idade para filtrar: ");
                    int age = scan.nextInt();

                    System.out.println("\n========== Candidatos com idade maior que " + age + " ==========");
                    boolean foundAge = false;
                    for (Inter i : interList) {
                        if (i.getAge() > age) {
                            System.out.println(i);
                            foundAge = true;
                        }
                    }
                    if (!foundAge) {
                        System.out.println("Não há ninguém com idade maior que " + age);
                    }
                    break;

                // Mostrar candidatos com média geral acima de 7
                case 2:
                    System.out.println("\n========== Candidatos com média acima de 7 ==========");
                    boolean foundAverage = false;
                    for (Inter i : interList) {
                        if (i.getGenerealAverage() > 7.0) {
                            System.out.println(i);
                            foundAverage = true;
                        }
                    }
                    if (!foundAverage) {
                        System.out.println("Não há ninguém com a média maior que 7");
                    }
                    break;

                // Mostrar total de candidatos por sexo
                case 3:
                    int contM = 0;
                    int contF = 0;

                    for (Inter i : interList) {
                        if (i.getGender().equalsIgnoreCase("F"))
                            contF++;
                        if (i.getGender().equalsIgnoreCase("M"))
                            contM++;
                    }

                    System.out.println("\n========== Total de candidatos por sexo ==========");
                    System.out.println("Feminino: " + contF);
                    System.out.println("Masculino: " + contM);
                    System.out.println("Total geral: " + (contF + contM));
                    break;

                // Mostrar nomes e idades dos alunos do curso de ADS
                case 4:
                    System.out.println("\n========== Alunos do curso de ADS ==========");
                    boolean foundADS = false;
                    for (Inter i : interList) {
                        if (i.getCurso().equalsIgnoreCase("ADS")) {
                            System.out.println("Nome: " + i.getName() + " | Idade: " + i.getAge());
                            foundADS = true;
                        }
                    }
                    if (!foundADS) {
                        System.out.println("Não há ninguém do curso de ADS");
                    }
                    break;

                case 5:
                    System.out.println("\nEncerrando o programa... Até logo!");
                    break;

                default:
                    System.out.println("\nOpção inválida! Escolha de 1 a 5.");
                    break;
            }

            if (choose != 5) {
                System.out.println("\nDeseja consultar o menu novamente (S/N)");
                continueMenu = scan.next();
            }
        } while (continueMenu.equalsIgnoreCase("S") && choose != 5);
    }
}
