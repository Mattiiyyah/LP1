import java.util.Scanner;

public class ExibindoValiadacoes {

    // Códigos ANSI para colorir as saídas no terminal
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BOLD = "\u001B[1m";

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int escolha = 0;
        char continuar = 's';

        // Variáveis para validação
        int nota;
        double numeroPositivo;
        int numero;

        System.out.println(ANSI_CYAN + ANSI_BOLD + "\n=========================================" + ANSI_RESET);
        System.out.println(ANSI_CYAN + ANSI_BOLD + "    SISTEMA DE VALIDAÇÕES INTERATIVO     " + ANSI_RESET);
        System.out.println(ANSI_CYAN + ANSI_BOLD + "=========================================" + ANSI_RESET);

        do {
            // Telinha para a escolha da validação
            do {
                try {
                    System.out.println(ANSI_YELLOW + "\nPor favor, escolha uma das opções abaixo:" + ANSI_RESET);
                    System.out.println("[ 1 ] Validar notas escolares");
                    System.out.println("[ 2 ] Validar número estritamente positivo");
                    System.out.println("[ 3 ] Exibir sequência de Ímpar ou Par");
                    System.out.print(ANSI_CYAN + "Sua escolha: " + ANSI_RESET);

                    escolha = leitor.nextInt();

                    if (escolha > 3 || escolha <= 0)
                        throw new Exception("Opção inválida! Selecione um número entre 1 e 3.");
                } catch (Exception e) {
                    exibirErro(e.getMessage());
                    leitor.nextLine();
                    escolha = -1;
                }

                switch (escolha) {
                    case 1:
                        do {
                            try {
                                System.out.print(ANSI_YELLOW + "\nInforme a nota do aluno (0 a 10): " + ANSI_RESET);
                                nota = leitor.nextInt();
                                Validacoes.validarNota(nota);

                                System.out
                                        .println(ANSI_GREEN + "Sucesso! A nota " + nota + " é válida." + ANSI_RESET);

                            } catch (Exception e) {
                                exibirErro(e.getMessage());
                                leitor.nextLine();
                                nota = -1;
                            }
                        } while (nota < 0 || nota > 10);
                        break;

                    case 2:
                        do {
                            try {
                                System.out.print(
                                        ANSI_YELLOW + "\nInforme um número estritamente positivo: " + ANSI_RESET);
                                numeroPositivo = leitor.nextDouble();
                                Validacoes.validarPositivo(numeroPositivo);

                                System.out.println(ANSI_GREEN + "Sucesso! O número " + numeroPositivo
                                        + " foi validado corretamente." + ANSI_RESET);

                            } catch (Exception e) {
                                exibirErro(e.getMessage());
                                leitor.nextLine();
                                numeroPositivo = -1;
                            }
                        } while (numeroPositivo <= 0);
                        break;

                    case 3:
                        do {
                            try {
                                System.out.print(ANSI_YELLOW
                                        + "\nInforme até que número deseja gerar a sequência (maior que 1): "
                                        + ANSI_RESET);
                                numero = leitor.nextInt();

                                Validacoes.verificarNumero(numero);
                                System.out.println(ANSI_GREEN + "\nSequência gerada com sucesso!" + ANSI_RESET);

                            } catch (Exception e) {
                                exibirErro(e.getMessage());
                                leitor.nextLine();
                                numero = -1;
                            }

                        } while (numero <= 1);
                        break;
                }

            } while (escolha > 3 || escolha <= 0);

            System.out.print(ANSI_CYAN + "\nDeseja realizar outra operação? (S/N): " + ANSI_RESET);
            continuar = leitor.next().toLowerCase().charAt(0);
        } while (continuar == 's' || continuar == 'S');

        System.out.println(ANSI_GREEN + "\nPrograma encerrado. Até mais!" + ANSI_RESET);
        leitor.close();
    }

    // Método auxiliar para imprimir erros formatados e padronizados
    private static void exibirErro(String mensagem) {
        if (mensagem == null) {
            mensagem = "Entrada de dados inválida! Certifique-se de digitar o tipo de dado correto (ex: número em vez de letra).";
        }
        System.out.println(ANSI_RED + "\nOcorreu um erro:" + ANSI_RESET);
        System.out.println(ANSI_RED + "  " + mensagem + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "  Por favor, tente novamente." + ANSI_RESET);
    }
}
