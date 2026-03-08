
import java.util.Scanner;

public class Cadastro {
    // Definindo códigos de cores ANSI
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BOLD = "\u001B[1m";

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String cep = "";

        boolean cepValido = false;

        System.out.println(ANSI_CYAN + ANSI_BOLD + "\n=== Sistema de Cadastro ===" + ANSI_RESET);

        do {
            try {
                System.out.print(ANSI_YELLOW + "\nPor favor, digite o CEP (formato: XXXXX-XXX): " + ANSI_RESET);
                cep = leitor.nextLine();

                Validacoes.validarCep(cep);

                System.out.println("\n" + ANSI_GREEN + ANSI_BOLD + "CEP Validado com sucesso!" + ANSI_RESET);

                cepValido = true;
            } catch (Exception e) {
                System.out.println(ANSI_RED + "\n" + "=".repeat(40));
                System.out.println("Erro de Validação: " + e.getMessage());
                System.out.println("Verifique o formato e tente novamente.");
                System.out.println("=".repeat(40) + ANSI_RESET);
            }
        } while (!cepValido);

        System.out.println();
        leitor.close();
    }
}
