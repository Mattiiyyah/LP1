public class Validacoes {

    public static void validarCep(String cep) throws Exception {
        if(!validarTamanho(9, 9, cep))
            throw new Exception("Cep com qtde inválida");
        if(cep.charAt(5) != '-' )
            throw new Exception("Cep sem -");
    }

    public static boolean validarTamanho(int minimo, int maximo, String texto) {
        if (texto.trim().length() < minimo || texto.trim().length() > maximo)
            return false;
        return true;
    }
}
