// import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        //    JOptionPane.showMessageDialog(null, "Apenas um parâmetro");
        //    JOptionPane.showMessageDialog(null, "Oi galera", "INFO",
        //    JOptionPane.WARNING_MESSAGE,null);
        Exemplo ex = new Exemplo();
        System.out.println("Iniciando o programa.......");
        ex.contar();
        System.out.println("Contador: " + ex.getContador());
        ex.contar(5);
        System.out.println("Contador: " + ex.getContador());
        ex.contarUtilizacao();
        System.out.println("Contador: " + ex.getContador());
        ex.contarUtilizacao(5);
        System.out.println("Contador: " + ex.getContador());
        ex.contar();
        System.out.println("Contador: " + ex.getContador());
    }
}
