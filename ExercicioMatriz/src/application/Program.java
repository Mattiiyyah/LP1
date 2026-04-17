package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.GradeStudent;
import model.exceptions.GradeException;

public class Program {
    public static void main(String[] args) throws Exception {
        int numberStudents = 0;
        Locale.setDefault(Locale.US);
        Scanner reader = new Scanner(System.in);

        do {
            try {
                System.out.println("\n========================================");
                System.out.println("   SISTEMA DE CADASTRO DE NOTAS");
                System.out.println("========================================");
                System.out.print("\n> Quantidade de alunos: ");
                numberStudents = reader.nextInt();
            } catch (Exception e) {
                System.out.println("\n[ERRO] Digite um numero inteiro valido!");
                reader.nextLine();
            }
        } while (numberStudents <= 0);

        GradeStudent objGrade = new GradeStudent(numberStudents);

        for (int i = 0; i < numberStudents; i++) {
            System.out.println("\n====================");
            System.out.println("      ALUNO " + (i + 1));
            System.out.println("====================");

            for (int j = 0; j < 3; j++) {
                boolean valid = false;
                do {
                    try {
                        System.out.print("Nota " + (j + 1) + " : ");
                        float valor = reader.nextFloat();
                        objGrade.validationGrade(i, j, valor);
                        valid = true;
                    } catch (GradeException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("[ERRO] Digite um número válido!");
                        reader.nextLine();
                    }
                } while (!valid);
            }
        }

        objGrade.viewStudent();
        objGrade.gradeScale();

        reader.close();
    }
}
