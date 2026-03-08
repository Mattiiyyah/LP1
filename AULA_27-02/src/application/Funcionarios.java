// Faça um programa que receba uma quantidade indeterminada de dados de: 
// funcionários:
 
// -Nome, 
// -Email,
// -salário,
// -departamento,

// Valide cada entrada de dados da seguinte forma:
// Nome deve ter pelo menos 10 caracteres
// E-mail deve conter @ e . e pelo menos 15 caracteres
// Salário deve ser maior que 1000,00
// Departamento não pode ser vazio

// Ao final, calcule e mostre: 
// - O departamento do funcionário que recebe o maior salário
// - A média dos salários de todos os funcionários
// - Os e-mails dos funcionários do departamento de TI
// - Quanto seria o novo salário dos funcionários com aumento de 20%


package application;

import java.util.Locale;
import java.util.Scanner;

public class Funcionarios {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner leitor = new Scanner(System.in);

        String nome, email;
        String continuar = "s";
        String departamento;
        String nomeDepartamento = "";
        String nomeEmails = "";
        String salariosFuncionarios = "";

        double salario;

        int contFuncionario = 0;
        double somaSolario = 0, maiorSalario = 0;
        double novoSalario;

        do {
            try {

                // validação para salario
                do {
                    System.out.print("\nDigite o salário do funcionário: ");
                    salario = leitor.nextDouble();
                    leitor.nextLine(); // limpar

                    if (salario < 1000.00)
                        throw new Exception("Salário inválido. Digite um valor maior ou igual a 1000.00");
                    System.out.println("\nTeste aqui.......");

                } while (salario < 1000.00);

                // validação para o nome
                do {
                    System.out.print("\nDigite o nome do funcionário: ");
                    nome = leitor.nextLine();

                    if (nome.length() < 10)
                        System.out.print("\nO nome precisa ter pelo menos 10 caracteres");

                } while (nome.length() < 10);

                // valiação par o email
                do {
                    System.out.print("\nDigite o email do funcionário: ");
                    email = leitor.next();

                    if (email.length() < 15 || !email.contains("@") || !email.contains("."))
                        System.out.print("\nEmail inválido. Deve conter pelo menos 15 caracteres, além de '@' e '.'");

                } while (email.length() < 15 || !email.contains("@") || !email.contains("."));

                // validação par departamento
                do {
                    System.out.print("\nDigite o departamento: ");
                    departamento = leitor.next();

                    if (departamento.equals("") || !departamento.matches("[a-zA-Z]+"))
                        System.out.print("\nDepartamento inválido. Digite apenas letras e não deixe em branco.");

                } while (departamento.equals("") || !departamento.matches("[a-zA-Z]+"));

                contFuncionario++;
                somaSolario += salario;

                if (salario > maiorSalario) {
                    maiorSalario = salario;
                    nomeDepartamento = departamento;
                }

                if (departamento.equalsIgnoreCase("TI")) {
                    nomeEmails = nomeEmails + " " + email;
                }

                novoSalario = salario * (1 + 0.20);

                salariosFuncionarios = salariosFuncionarios + " R$ " + novoSalario;

                System.out.println("\nDeseja continuar (digite s para sim ou n para não): ");
                continuar = leitor.next();
                leitor.nextLine();

            } catch (Exception erro) {
                System.out.println("\n########################################");
                System.out.println("\nErro: " + erro.getMessage());
                System.out.println("Tente novamente.");
                System.out.println("\n########################################");
                leitor.nextLine();
                salario = -1;
            }

        } while (continuar.equalsIgnoreCase("s"));

        double mediaSalario = somaSolario / contFuncionario;

        System.out.println("\n========================================");
        System.out.println("           RESUMO DO CADASTRO           ");
        System.out.println("========================================");

        System.out.println("\nDepartamento com maior salário:");
        System.out.println("   " + nomeDepartamento);

        System.out.println("\nMédia salarial:");
        System.out.printf("   R$ %.2f%n", mediaSalario);

        System.out.println("\nEmails do departamento TI:");
        System.out.println("   " + (nomeEmails.isEmpty() ? "Nenhum funcionário encontrado." : nomeEmails));

        System.out.println("\nNovos salários com aumento de 20%:");
        System.out.println("   " + salariosFuncionarios);

        System.out.println("\n========================================");
        System.out.println("        FIM DO RELATÓRIO                ");
        System.out.println("========================================");
        leitor.close();
    }
}
