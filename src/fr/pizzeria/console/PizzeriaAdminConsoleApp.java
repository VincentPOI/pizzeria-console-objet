package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int choix = 99;		
		Pizza[] pizzas  = new Pizza[1000];
		int pos = 0;
		pizzas[0] = new Pizza("PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza("MAR", "Margherita", 12.50);
		pizzas[2] = new Pizza( "REIN", "La Reine", 12.50);
		pizzas[3] = new Pizza( "FRO", "Les 4 fromages", 12.50);
		pizzas[4] = new Pizza( "CAN", "La cannibale", 12.50);
		pizzas[5] = new Pizza( "SAV", "La savoyarde", 12.50);
		pizzas[6] = new Pizza( "ORI", "L'Orientale", 12.50);
		pizzas[7] = new Pizza( "IND", "L'indienne", 12.50);
		pos = 8;	
		
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
				for (int i = 0; i < pos; i++) {
					pizzas[i].afficher();
					System.out.println(pizzas[i].getId());
				}					
				System.out.println();
				break;

			case 2:
				System.out.println("Ajout d'une nouvelle pizza :");

				String code;
				System.out.println("saisir code :");
				code = scn.next();

				String nom;
				System.out.println("saisir nom:");
				nom = scn.next();

				double prix;
				System.out.println("saisir prix :");
				prix = scn.nextDouble();
				
				pizzas[pos] = new Pizza(code, nom, prix);
				pos++;

				break;

			case 3:
				System.out.println("Mise à jour d'une pizza :");

				System.out.println();
				System.out.println("Code de la pizza à mettre à jours ?");
				String piz = scn.next();
				
				for(int i = 0; i<pos ; i++){
					if (pizzas[i].getCode().equals(piz)){
						
						System.out.println("saisir code :");
						pizzas[i].setCode(scn.next());

						System.out.println("saisir nom:");
						pizzas[i].setNom(scn.next());

						System.out.println("saisir prix :");
						pizzas[i].setPrix(scn.nextDouble());						
					}
				}
				
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
