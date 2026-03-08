public class Validacoes {

    // Cores para formatação de saída opcional no terminal
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    // Validando notas escolares
    public static void validarNota(int nota) throws Exception {
        if (nota < 0)
            throw new Exception("A nota não pode ser menor que zero.");
        if (nota > 10)
            throw new Exception("A nota não pode ser maior que 10.");
    }

    // Validando números positivos
    public static void validarPositivo(double numeroPositivo) throws Exception {
        if (numeroPositivo < 0)
            throw new Exception("Valores negativos não são permitidos.");
        if (numeroPositivo == 0)
            throw new Exception("O valor zero não é válido nesta operação (apenas maiores que zero).");
    }

    // Gerando sequência e classificando em Par ou Ímpar
    public static void verificarNumero(int numero) throws Exception {
        if (numero <= 1)
            throw new Exception("Para gerar a sequência, o número limite deve ser maior que 1.");

        System.out.println();
        for (int i = 1; i <= numero; i++) {
            if (i % 2 == 0) {
                System.out.println(ANSI_CYAN + "  -> Número " + i + ": [PAR]" + ANSI_RESET);
            } else {
                System.out.println(ANSI_PURPLE + "  -> Número " + i + ": [ÍMPAR]" + ANSI_RESET);
            }
        }
    }
}