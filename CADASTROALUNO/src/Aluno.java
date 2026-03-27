import java.util.Scanner;

public class Aluno {
    private int RA;
    private String nome;
    private String curso;
    private String email;
    private String cpf;
    private String telefone;

    public Aluno() {
        RA       = 0;
        nome     = new String();
        curso    = new String();
        email    = new String();
        cpf      = new String();
        telefone = new String();
    }

    public Aluno(int RA, String nome, String curso, String email, String cpf, String telefone) {
        this.RA = RA; //dentro da classe, pegue o atributo RA e atribua o valor do parâmetro RA
        this.nome = nome;
        this.curso = curso;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }
    
    public int getRA() {
        return RA;
    }

    public void setRA(int RA) {
        this.RA = RA;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void mostrarDados() {
        System.out.println();
        System.out.println("RA:       "    +    RA);
        System.out.println("Nome:     "    +    nome);
        System.out.println("Curso:    "    +    curso);
        System.out.println("Email:    "    +    email);
        System.out.println("Cpf:      "    +    cpf);
        System.out.println("Telefone: "    +    telefone);
    }

    public void cadastrar() {
        Scanner ler = new Scanner(System.in);
        do {
            try {
                System.out.println("\nDigite o RA do aluno: ");
                RA = ler.nextInt();

                if(RA <= 10) {
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
        } while(RA <= 0);
        
        ler.nextLine();

        do {
            System.out.println("\nDigite o nome do aluno: ");
            nome = ler.nextLine();

            if(nome.isEmpty()) {
                System.out.println("Nome do aluno não pode ser vazio");
            }
            if(nome.length() < 10) {
                System.out.println("Nome do aluno deve conter mais que 10 caracteres!");
            }
        } while(nome.isEmpty() || nome.length() < 10);
    
        do {
            System.out.println("\nDigite o curso do aluno: ");
            curso = ler.nextLine();
            if(curso.length() < 10) {
                System.out.println("Curso deve conter mais que 10 caracteres!");
            }
        } while(curso.isEmpty() || curso.length() < 10);

        do {
            System.out.println("\nDigite o email do aluno: ");
            email = ler.nextLine();
            if(email.isEmpty()) {
                System.out.println("Email do aluno não pode ser vazio!");
            } else if(email.length() < 15) {
                System.out.println("Email deve conter mais que 15 caracteres!");
            } else if(!email.contains("@")) {
                System.out.println("Email deve conter o caractere '@'!");
            } else if(!email.contains(".")) {
                System.out.println("Email deve conter o caractere '.'!");
            }
        } while(email.isEmpty() || email.length() < 15 || !email.contains("@") || !email.contains("."));
    
        do {
            System.out.println("\nDigite o cpf do aluno: ");
            cpf = ler.nextLine();
            if(cpf.isEmpty()) {
                System.out.println("CPF do aluno não pode ser vazio!");
            } else if(cpf.length() < 11) {
                System.out.println("CPF deve conter no mínimo 11 caracteres!");
            }
        } while(cpf.isEmpty() || cpf.length() < 11);

        do {
            System.out.println("\nDigite o telefone do aluno: ");
            telefone = ler.nextLine();
            if(telefone.isEmpty()) {
                System.out.println("Telefone do aluno não pode ser vazio!");
            } else if(telefone.length() < 10) {
                System.out.println("Telefone deve conter no mínimo 10 caracteres!");
            }
        } while (telefone.isEmpty() || telefone.length() < 10);
    }

}