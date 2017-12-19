package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int choix = 99;
		do {
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			choix = scn.nextInt();
			switch (choix) {
			
			case 1:
				System.out.println("Liste des pizzas :");

				break;
				
			case 2:
				System.out.println("Ajout d'une nouvelle pizza :");

				break;
				
			case 3:
				System.out.println("Mise à jour d'une pizza :");
				break;
				
			case 4:
				System.out.println("Suppression d'une pizza :");
				break;

			default:
				break;
			}
		} while (choix != 99);
		System.out.println("Aurevoir :(");
		scn.close();
	}

}
