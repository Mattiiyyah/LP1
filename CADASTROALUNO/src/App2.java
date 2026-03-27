import java.util.ArrayList;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        ArrayList<Aluno> listaAlunos = new ArrayList<>();
        Scanner ler = new Scanner(System.in);
        String resposta = new String();

        do {
            Aluno objAluno = new Aluno();
            objAluno.cadastrar();
            listaAlunos.add(objAluno);
            System.out.println("Deseja cadastrar outro aluno? (S/N)");
            resposta = ler.next();
        } while(resposta.equalsIgnoreCase("S"));
        //mostrando os dados os alunos cadastrados
        for (Aluno x : listaAlunos) {
            x.mostrarDados();
            System.out.println("-------------------------");
        }

        for(int i = 0; i < listaAlunos.size(); i++) {
            System.out.println(i + 1 + "° aluno:");
            listaAlunos.get(i).mostrarDados();
            System.out.println("-------------------------");
        }

    }
}
