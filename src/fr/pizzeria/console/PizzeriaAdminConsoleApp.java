package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.Menu;

public class PizzeriaAdminConsoleApp {

	public static Pizza[] pizzas = new Pizza[1000];

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int choix = 99;
		PizzaDaoImpl pizzas = new PizzaDaoImpl();		
	
		 Menu menu = new Menu(pizzas, scn);
		 
			do {
				menu.afficher();	
				choix = scn.nextInt();
				switch (choix) {

				case 1:
					
					menu.getOptions(0).execute();
					
					break;

				case 2:
					menu.getOptions(1).execute();

					break;

				case 3:
					
					menu.getOptions(2).execute();

					break;

				case 4:
					
					menu.getOptions(3).execute();
					
					break;

				default:
					break;
				}
			} while (choix != 99);
			System.out.println("Aurevoir :(");
			scn.close();
		}
}
