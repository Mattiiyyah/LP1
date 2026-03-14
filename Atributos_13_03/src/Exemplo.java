public class Exemplo {
   private int contador = 0;
   public final String CURSO = "INFO";
   
   public int getContador() {
     return contador;
   }

   void mostrar() {
      System.out.println(contador + " -- " + CURSO);
      System.out.println("Rodou Atributo");
      contador++;
   }
   
   void contar() {
     System.out.println("Rodou variavel a linha 11");
     int contador = 0;
     contador++;
     System.out.println("Rodou variavel a linha 14: " + contador);
   }

   void contar(int contador) {
     System.out.println("Rodou variavel a linha 18");
     contador++;
     System.out.println("Rodou variavel a linha 20: " + contador);
   }

   void contarUtilizacao() {
     System.out.println("Rodou Atributo a linha 24");
     contador++;
     System.out.println("Rodou Atributo a linha 26: " + contador);
   }

   void contarUtilizacao(int contador) {
    System.out.println("Rodou variavel a linha 30");
     this.contador++;
     contador++;
     System.out.println("Rodou variavel a linha 33: " + contador);
   }

}
