package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Register {
    // criando as listagens
    private List<Admin> adminList = new ArrayList<>();
    private List<Inter> interList = new ArrayList<>();
    private List<Company> companyList = new ArrayList<>();

    // get listas
    public List<Admin> getAdminList() {
        return adminList;
    }

    public List<Inter> getInterList() {
        return interList;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    private int id;
    private String name;
    private String email;
    private String password;
    private Scanner sc = new Scanner(System.in);

    private String continueRegister = "";

    // Método para carregar dados de teste
    public void loadSampleData() {
        // 5 Administradores
        adminList.add(new Admin(1, "Carlos Alberto Silva", "carlos.silva@empresa.com.br", "senha@123", "Financeiro"));
        adminList.add(new Admin(2, "Maria Fernanda Souza", "maria.souza@empresa.com.br", "senha@456", "Recursos Humanos"));
        adminList.add(new Admin(3, "João Pedro Oliveira", "joao.oliveira@empresa.com.br", "senha@789", "Tecnologia"));
        adminList.add(new Admin(4, "Ana Carolina Santos", "ana.santos@empresa.com.br", "senha@321", "Marketing"));
        adminList.add(new Admin(5, "Roberto Carlos Lima", "roberto.lima@empresa.com.br", "senha@654", "Operações"));

        // 5 Estagiários
        interList.add(new Inter(1, "Lucas Gabriel Pereira", "lucas.pereira@fatec.sp.gov.br", "est@2024a", 20, 8.5, "M"));
        interList.add(new Inter(2, "Beatriz Helena Costa", "beatriz.costa@fatec.sp.gov.br", "est@2024b", 19, 9.2, "F"));
        interList.add(new Inter(3, "Felipe Augusto Ramos", "felipe.ramos@fatec.sp.gov.br", "est@2024c", 22, 7.8, "M"));
        interList.add(new Inter(4, "Juliana Martins Rocha", "juliana.rocha@fatec.sp.gov.br", "est@2024d", 21, 9.0, "F"));
        interList.add(new Inter(5, "Matheus Henrique Alves", "matheus.alves@fatec.sp.gov.br", "est@2024e", 23, 8.0, "M"));

        // 5 Empresas
        companyList.add(new Company(1, "Tech Solutions Brasil", "contato@techsolutions.com.br", "emp@2024a", "https://www.techsolutions.com.br", "Ricardo Mendes", "11987654321", "12345678000100", "123456789"));
        companyList.add(new Company(2, "Inovação Digital Ltda", "contato@inovacaodigital.com.br", "emp@2024b", "https://www.inovacaodigital.com.br", "Patrícia Almeida", "11976543210", "23456789000111", "234567890"));
        companyList.add(new Company(3, "Consultoria Global SA", "contato@consultoriaglobal.com.br", "emp@2024c", "https://www.consultoriaglobal.com.br", "Eduardo Nunes", "11965432109", "34567890000122", "345678901"));
        companyList.add(new Company(4, "StartUp Connect Inc", "contato@startupconnect.com.br", "emp@2024d", "https://www.startupconnect.com.br", "Camila Ferreira", "11954321098", "45678901000133", "456789012"));
        companyList.add(new Company(5, "DataFlow Sistemas", "contato@dataflow.com.br", "emp@2024e", "https://www.dataflow.com.br", "Thiago Barbosa", "11943210987", "56789012000144", "567890123"));
    }

    // registro do id
    public void validationId() {
        do {
            try {
                System.out.print("Digite o ID: ");
                id = Integer.parseInt(sc.nextLine());

                if (id <= 0) {
                    System.out.println("\n##############################################");
                    System.out.println("Erro: O ID não pode ser menor ou igual a zero");
                    System.out.println("##############################################");
                    System.out.print("\nTente novamente...\n");
                    id = -1;
                }
            } catch (NumberFormatException e) {
                id = -1;
                System.out.println("\n##############################################");
                System.out.println("Erro: Digite apenas números");
                System.out.println("##############################################");
                System.out.print("\nTente novamente...\n");
            }
        } while (id <= 0);
    }

    // registro para nome
    public void validationName() {
        do {
            System.out.print("\nEscreva o nome: ");
            name = sc.nextLine();

            if (name.isEmpty()) {
                System.out.println("\n####################################################");
                System.out.println("Erro: O nome não pode ser vazio");
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
            } else if (name.length() < 10) {
                System.out.println("\n####################################################");
                System.out.println("Erro: O nome não pode ter menos que 10 caracteres");
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
            }
        } while (name.isEmpty() || name.length() < 10);
    }

    public void validationEmail() {
        do {
            System.out.print("\nCadastre o email: ");
            email = sc.nextLine();

            if (email.isEmpty()) {
                System.out.println("\n####################################################");
                System.out.println("Erro: Email do aluno não pode ser vazio!");
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
            } else if (email.length() < 15) {
                System.out.println("\n####################################################");
                System.out.println("Erro: Email deve conter mais que 15 caracteres!");
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
            } else if (!email.contains("@")) {
                System.out.println("\n####################################################");
                System.out.println("Erro: Email deve conter o caractere '@'!");
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
            } else if (!email.contains(".")) {
                System.out.println("\n####################################################");
                System.out.println("Erro: Email deve conter o caractere '.'!");
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
            }
        } while (email.isEmpty() || email.length() < 15 || !email.contains("@") || !email.contains("."));
    }

    // validacao de senha
    public void validationPassword() {
        do {
            System.out.print("\nCadastre a senha: ");
            password = sc.nextLine();

            if (password.isEmpty()) {
                System.out.println("\n####################################################");
                System.out.println("Erro: Senha não pode ser vazia!");
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
            } else if (password.equals("123456")) {
                System.out.println("\n####################################################");
                System.out.println("Erro: Senha não pode ser 123456");
                System.out.println("####################################################");
                System.out.print("\nTente novamente...\n");
            }

        } while (password.isEmpty() || password.equals("123456"));
    }

    public void RegisterAdmin() {
        String department = "";
        do {
            // registro principal
            validationId();
            validationName();
            validationEmail();
            validationPassword();

            do {
                System.out.print("\nDigite o departamento do Administrador: ");
                department = sc.nextLine();

                if (department.isEmpty()) {
                    System.out.println("\n####################################################");
                    System.out.println("Erro: O curso não pode ser vazio!");
                    System.out.println("####################################################");
                    System.out.print("\nTente novamente...\n");
                }
            } while (department.isEmpty());

            Admin admin = new Admin(id, name, email, password, department);
            adminList.add(admin);

            System.out.print("\nDeseja cadastrar outro ADMIN? (S/N): ");
            continueRegister = sc.nextLine();
            System.out.println();
        } while (continueRegister.equalsIgnoreCase("S"));

        System.out.println("\n----  Dados dos Aminstradores cadastrados ----");
        for (Admin ad : adminList) {
            System.out.println(ad);
        }
    }

    public void RegisterInter() {
        Locale.setDefault(Locale.US);

        int age;
        Double average;
        String gender;

        do {
            // registro principal
            validationId();
            validationName();
            validationEmail();
            validationPassword();

            do {
                try {
                    System.out.print("\nDigite a idade do Estagiário (16 a 30): ");
                    age = Integer.parseInt(sc.nextLine());

                    if (age < 16 || age > 30) {
                        System.out.println("\n####################################################");
                        System.out.println("Erro: A idade deve ser entre 16 e 30 anos!");
                        System.out.println("####################################################");
                        System.out.print("\nTente novamente...\n");
                        age = -1;
                    }
                } catch (NumberFormatException e) {
                    age = -1;
                    System.out.println("\n####################################################");
                    System.out.println("Erro: Digite um número inteiro válido!");
                    System.out.println("####################################################");
                    System.out.print("\nTente novamente...\n");
                }
            } while (age < 16 || age > 30);

            do {
                try {
                    System.out.print("\nDigite a média geral do Estagiário (0 a 10): ");
                    average = Double.parseDouble(sc.nextLine());

                    if (average < 0 || average > 10) {
                        System.out.println("\n####################################################");
                        System.out.println("Erro: A média deve ser entre 0 e 10!");
                        System.out.println("####################################################");
                        System.out.print("\nTente novamente...\n");
                        average = -1.0;
                    }
                } catch (NumberFormatException e) {
                    average = -1.0;
                    System.out.println("\n####################################################");
                    System.out.println("Erro: Digite um número válido!");
                    System.out.println("####################################################");
                    System.out.print("\nTente novamente...\n");
                }
            } while (average < 0 || average > 10);

            do {
                System.out.print("\nDigite o gênero do Estagiário (M ou F): ");
                gender = sc.nextLine();

                if (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F")) {
                    System.out.println("\n####################################################");
                    System.out.println("Erro: Gênero inválido! Digite apenas M ou F.");
                    System.out.println("####################################################");
                    System.out.print("\nTente novamente...\n");
                }
            } while (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F"));

            Inter inter = new Inter(id, name, email, password, age, average, gender);
            interList.add(inter);

            System.out.print("\nDeseja cadastrar outro Estágiario? (S/N): ");
            continueRegister = sc.nextLine();
            System.out.println();
        } while (continueRegister.equalsIgnoreCase("S"));


        System.out.println("\n----  Dados dos Estagiarios cadastrados ----");
        for (Inter i : interList) {
            System.out.println(i);
        }
    }

    public void RegisterCompany() {
        String site;
        String contact;
        String phone;
        String cnpj;
        String ie;

        do {
            // registro principal
            validationId();
            validationName();
            validationEmail();
            validationPassword();
            
            do {
                System.out.print("\nDigite o site da Empresa (ex: https://www.empresa.com): ");
                site = sc.nextLine();

                if (site.isEmpty()) {
                    System.out.println("\n####################################################");
                    System.out.println("Erro: O site não pode ser vazio!");
                    System.out.println("####################################################");
                    System.out.print("\nTente novamente...\n");
                } else if (!site.contains("http") && !site.contains("www")) {
                    System.out.println("\n####################################################");
                    System.out.println("Erro: O site deve conter 'http' ou 'www'!");
                    System.out.println("####################################################");
                    System.out.print("\nTente novamente...\n");
                }
            } while (site.isEmpty() || (!site.contains("http") && !site.contains("www")));

            do {
                System.out.print("\nDigite o nome do contato da Empresa: ");
                contact = sc.nextLine();

                if (contact.isEmpty()) {
                    System.out.println("\n####################################################");
                    System.out.println("Erro: O contato não pode ser vazio!");
                    System.out.println("####################################################");
                    System.out.print("\nTente novamente...\n");
                } else if (contact.length() < 5) {
                    System.out.println("\n####################################################");
                    System.out.println("Erro: O contato deve ter no mínimo 5 caracteres!");
                    System.out.println("####################################################");
                    System.out.print("\nTente novamente...\n");
                }
            } while (contact.isEmpty() || contact.length() < 5);

            do {
                System.out.print("\nDigite o telefone da Empresa (apenas números, 10 ou 11 dígitos): ");
                phone = sc.nextLine();

                if (phone.isEmpty()) {
                    System.out.println("\n####################################################");
                    System.out.println("Erro: O telefone não pode ser vazio!");
                    System.out.println("####################################################");
                    System.out.print("\nTente novamente...\n");
                } else if (!phone.matches("\\d+")) {
                    System.out.println("\n####################################################");
                    System.out.println("Erro: O telefone deve conter apenas números!");
                    System.out.println("####################################################");
                    System.out.print("\nTente novamente...\n");
                } else if (phone.length() < 10 || phone.length() > 11) {
                    System.out.println("\n####################################################");
                    System.out.println("Erro: O telefone deve ter 10 ou 11 dígitos!");
                    System.out.println("####################################################");
                    System.out.print("\nTente novamente...\n");
                }
            } while (phone.isEmpty() || !phone.matches("\\d+") || phone.length() < 10 || phone.length() > 11);

            do {
                System.out.print("\nDigite o CNPJ da Empresa (apenas números, 14 dígitos): ");
                cnpj = sc.nextLine();

                if (cnpj.isEmpty()) {
                    System.out.println("\n####################################################");
                    System.out.println("Erro: O CNPJ não pode ser vazio!");
                    System.out.println("####################################################");
                    System.out.print("\nTente novamente...\n");
                } else if (!cnpj.matches("\\d+")) {
                    System.out.println("\n####################################################");
                    System.out.println("Erro: O CNPJ deve conter apenas números!");
                    System.out.println("####################################################");
                    System.out.print("\nTente novamente...\n");
                } else if (cnpj.length() != 14) {
                    System.out.println("\n####################################################");
                    System.out.println("Erro: O CNPJ deve ter exatamente 14 dígitos!");
                    System.out.println("####################################################");
                    System.out.print("\nTente novamente...\n");
                }
            } while (cnpj.isEmpty() || !cnpj.matches("\\d+") || cnpj.length() != 14);

            do {
                System.out.print("\nDigite a Inscrição Estadual (IE) da Empresa: ");
                ie = sc.nextLine();

                if (ie.isEmpty()) {
                    System.out.println("\n####################################################");
                    System.out.println("Erro: A Inscrição Estadual não pode ser vazia!");
                    System.out.println("####################################################");
                    System.out.print("\nTente novamente...\n");
                }
            } while (ie.isEmpty());

            Company company = new Company(id, name, email, password, site, contact, phone, cnpj, ie);
            companyList.add(company);

            System.out.print("\nDeseja cadastrar outra Empresa? (S/N): ");
            continueRegister = sc.nextLine();
            System.out.println();
        } while (continueRegister.equalsIgnoreCase("S"));

        System.out.println("\n----  Dados das Empresas cadastradas ----");
        for (Company cp : companyList) {
            System.out.println(cp);
        }
     }

}
