package application;

import java.util.Locale;
import java.util.Scanner;

import entities.MenuInter;
import entities.RegisterInter;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        //cadastro dos estagiários
        RegisterInter objRegister = new RegisterInter();
        objRegister.register(scan);

        //menu de consultas
        MenuInter objMenu = new MenuInter();
        objMenu.menu(scan, objRegister.getInterList());

        scan.close();
    }
}
