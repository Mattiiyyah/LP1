package application;

import java.util.Scanner;

import entities.Menu;

public class App {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      Menu objMenu = new Menu();
      objMenu.menu(sc);

      sc.close();
    }
}
