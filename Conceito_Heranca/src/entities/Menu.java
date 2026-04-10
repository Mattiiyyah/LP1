package entities;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public void menu(Scanner sc) {
        DisplayMenu displayMenu = new DisplayMenu();
        //chamando o menu do cadastro
        displayMenu.RegisterMenu();

        Register objRegister = new Register();
        objRegister.loadSampleData(); // Carrega 5 admins, 5 estagiários e 5 empresas de teste
        
        String continueMenu = "";
        
        int choose = 0;

        final int ADMIN = 1;
        final int INTER = 2;
        final int COMPANY = 3;
        final int EXIT = 4;
    
    //cadastros
    do {
        if (continueMenu.equalsIgnoreCase("S")) {
                displayMenu.RegisterMenu();
        }

        System.out.print("\nEscolha uma opção: ");
        choose = Integer.parseInt(sc.nextLine());
        
        switch (choose) {
            case ADMIN:
                System.out.println("\n======== CADASTRANDO ADMINISTRADOR ========");
                objRegister.RegisterAdmin();
                break;
            case INTER:
                System.out.println("\n======== CADASTRANDO ESTAGIARIO ========");
                objRegister.RegisterInter();
                break;
            case COMPANY:
                System.out.println("\n======== CADASTRANDO EMPRESA ========");
                objRegister.RegisterCompany();
                break;
            case EXIT:
                System.out.println("\nSaindo do menu de CADASTRO");
                break;
            default:
                System.out.println("#####################################");
                System.out.println("\nOpção invalida! Escolha de 1 a 3.");
                System.out.println("#####################################");
                break;
        }

        if (choose != 4) {
                System.out.println("\nDeseja consultar o menu novamente (S/N)");
                continueMenu = sc.nextLine();
        }
    } while (continueMenu.equalsIgnoreCase("S") && choose != 4);

    // Reseta a variável para não interferir no menu de listagem
    continueMenu = "";

    displayMenu.ListMenu();
    List<Admin> adminList = objRegister.getAdminList();
    List<Inter> interList = objRegister.getInterList();
    List<Company> companyList = objRegister.getCompanyList();

    //listagem
    do {
        if (continueMenu.equalsIgnoreCase("S")) {
                displayMenu.ListMenu();
        }

        System.out.print("\nEscolha uma opção: ");
        choose = Integer.parseInt(sc.nextLine());

        switch (choose) {
            case ADMIN:
                System.out.println("\n======== LISTANDO ADMINISTRADOR ========");
                
                if(adminList.isEmpty()) {
                    System.out.println("NAO HA ADMINISTRADORES CADASTRADOS");
                }
                else {
                    for(Admin a : adminList) {
                            System.out.println(a);
                    }
                }
               
                break;
            case INTER:
                System.out.println("\n======== LISTANDO ESTAGIARIOS ========");
                
                if(interList.isEmpty()) {
                    System.out.println("NÃO HA ESTAGIARIOS CADASTRADOS");
                }   
                else {
                    for(Inter i : interList) {
                        System.out.println(i);
                    }
                }
                break;
            case COMPANY:
                System.out.println("\n======== LISTANDO EMPRESAS ========");
                
                if(companyList.isEmpty()) {
                    System.out.println("NAO HA EMPRESAS CADASTRADAS");
                }   
                else {
                    for(Company c : companyList) {
                        System.out.println(c);
                    }
                }
                break;
            case EXIT:
                System.out.println("\nEncerrando o programa... Até logo!");
                break;
            default:
                System.out.println("#####################################");
                System.out.println("\nOpção inválida! Escolha de 1 a 3.");
                System.out.println("#####################################");
                break;
        }

        if (choose != 4) {
                System.out.println("\nDeseja consultar o menu novamente (S/N)");
                continueMenu = sc.nextLine();
        }
    } while (continueMenu.equalsIgnoreCase("S") && choose != 4);
  }
}