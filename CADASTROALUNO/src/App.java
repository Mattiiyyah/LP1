import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Aluno objAluno = new Aluno();
        objAluno.mostrarDados();
        Aluno objAluno2 = new Aluno(123, "Bruno Rodrigues", "Agro Noite", "bruno@gmail.com", "1234567891", "(11)1111-1111");
        objAluno2.mostrarDados();

        objAluno.cadastrar();
        objAluno.mostrarDados();

        Aluno objAluno3 = new Aluno();
        Scanner ler = new Scanner(System.in);

         do {
            try {
                System.out.println("\nDigite o RA do aluno: ");
                objAluno3.setRA(ler.nextInt());

                if(objAluno3.getRA() <= 10) {
                    throw new Exception("RA não pode ser menor ou igual a 10");
                }

            } catch(Exception e) {
                System.out.println("\n####################################################");
               System.out.println("Erro: " + e.getMessage());
               System.out.println("####################################################");
               System.out.print("\nTente novamente\n");
               System.out.println("\nDigite o RA novamente abaixo: ");
               ler.nextLine();
            }
        } while(objAluno3.getRA() <= 0);
        
        ler.nextLine();

        do {
            System.out.println("\nDigite o nome do aluno: ");
            objAluno3.setNome(ler.nextLine());

            if(objAluno3.getNome().isEmpty()) {
                System.out.println("Nome do aluno não pode ser vazio");
            }
            if(objAluno3.getNome().length() < 10) {
                System.out.println("Nome do aluno deve conter mais que 10 caracteres!");
            }
        } while(objAluno3.getNome().isEmpty() || objAluno3.getNome().length() < 10);
    
        do {
            System.out.println("\nDigite o curso do aluno: ");
            objAluno3.setCurso(ler.nextLine());
            if(objAluno3.getCurso().length() < 10) {
                System.out.println("Curso deve conter mais que 10 caracteres!");
            }
        } while(objAluno3.getCurso().isEmpty() || objAluno3.getCurso().length() < 10);

        do {
            System.out.println("\nDigite o email do aluno: ");
            objAluno3.setEmail(ler.nextLine());
            if(objAluno3.getEmail().isEmpty()) {
                System.out.println("Email do aluno não pode ser vazio!");
            } else if(objAluno3.getEmail().length() < 15) {
                System.out.println("Email deve conter mais que 15 caracteres!");
            } else if(!objAluno3.getEmail().contains("@")) {
                System.out.println("Email deve conter o caractere '@'!");
            } else if(!objAluno3.getEmail().contains(".")) {
                System.out.println("Email deve conter o caractere '.'!");
            }
        } while(objAluno3.getEmail().isEmpty() || objAluno3.getEmail().length() < 15 || !objAluno3.getEmail().contains("@") || !objAluno3.getEmail().contains("."));
    
        do {
            System.out.println("\nDigite o cpf do aluno: ");
            objAluno3.setCpf(ler.nextLine());
            if(objAluno3.getCpf().isEmpty()) {
                System.out.println("CPF do aluno não pode ser vazio!");
            } else if(objAluno3.getCpf().length() < 11) {
                System.out.println("CPF deve conter no mínimo 11 caracteres!");
            }
        } while(objAluno3.getCpf().isEmpty() || objAluno3.getCpf().length() < 11);

        do {
            System.out.println("\nDigite o telefone do aluno: ");
            objAluno3.setTelefone(ler.nextLine());
            if(objAluno3.getTelefone().isEmpty()) {
                System.out.println("Telefone do aluno não pode ser vazio!");
            } else if(objAluno3.getTelefone().length() < 10) {
                System.out.println("Telefone deve conter no mínimo 10 caracteres!");
            }
        } while (objAluno3.getTelefone().isEmpty() || objAluno3.getTelefone().length() < 10);
    }
}
