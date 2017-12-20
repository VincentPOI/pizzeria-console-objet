package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.ihm.Menu;

public class PizzeriaAdminConsoleApp {

	public static Pizza[] pizzas = new Pizza[1000];

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int choix = 99;
		Pizza[] pizzas = new Pizza[1000];
		pizzas[0] = new Pizza("PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza("MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza("REIN", "La Reine", 11.50);
		pizzas[3] = new Pizza("FRO", "Les 4 fromages", 12.00);
		pizzas[4] = new Pizza("CAN", "La cannibale", 12.50);
		pizzas[5] = new Pizza("SAV", "La savoyarde", 13.00);
		pizzas[6] = new Pizza("ORI", "L'Orientale", 13.50);
		pizzas[7] = new Pizza("IND", "L'indienne", 14.00);
	
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
