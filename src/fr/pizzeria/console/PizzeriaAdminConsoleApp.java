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

		
		
		 Menu menu = new Menu(pizzas);
		 menu.afficher();		 
		 
		 
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
					
					menu.getOptions(0).execute();
					
//					for (int i = 0; i < pizzas.length; i++) {
//						if (pizzas[i] != null) {
//							pizzas[i].afficher();
//						}
//					}
//					System.out.println();
//					break;

				case 2:
					
					menu.getOptions(1).execute();
//					System.out.println("Ajout d'une nouvelle pizza :");
//
//					String code;
//					System.out.println("saisir code :");
//					code = scn.next();
//
//					String nom;
//					System.out.println("saisir nom (sans espace):");
//					nom = scn.next();
//
//					double prix;
//					System.out.println("saisir prix :");
//					prix = scn.nextDouble();
//
//					for (int i = 0; i < pizzas.length; i++) {
//						if (pizzas[i] == null) {
//							pizzas[i] = new Pizza(code, nom, prix);
//							break;
//						}
//					}


					break;

				case 3:
					
					menu.getOptions(2).execute();
//					System.out.println("Mise à jour d'une pizza :");
//					System.out.println("Code de la pizza à mettre à jours ?");
//					System.out.println("(99 pour abandoner)");
//
//					String codeupdatepizza = scn.next();
//
//					if (codeupdatepizza.equals(99)) {
//						break;
//					}
//					;
//
//					for (int i = 0; i < pizzas.length; i++) {
//						if (pizzas[i] != null) {
//							if (pizzas[i].getCode().equals(codeupdatepizza)) {
//
//								System.out.println("saisir code :");
//								pizzas[i].setCode(scn.next());
//
//								System.out.println("saisir nom (sans espace):");
//								pizzas[i].setNom(scn.next());
//
//								System.out.println("saisir prix :");
//								pizzas[i].setPrix(scn.nextDouble());
//								break;
//							}
//						}
//					}

					break;

				case 4:
					
					menu.getOptions(3).execute();
					
					
//					System.out.println("Suppression d'une pizza :");
//					System.out.println();
//					System.out.println("Code de la pizza à mettre à jours ?");
//					String codedeletepizza = scn.next();
//					for (int i = 0; i < pizzas.length; i++) {
//						if (pizzas[i] != null) {
//							if (pizzas[i].getCode().equals(codedeletepizza)) {
//								pizzas[i] = null;
//								break;
//							}
//						}
//					}
					break;

				default:
					break;
				}
			} while (choix != 99);
			System.out.println("Aurevoir :(");
			scn.close();
		}
}
