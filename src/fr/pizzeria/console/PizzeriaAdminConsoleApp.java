package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int choix = 99;
		ArrayList<Pizza> ListePizzas = new ArrayList<Pizza>();		
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
				Iterator<Pizza> it = ListePizzas.iterator();
				while(it.hasNext()){
					 it.next().afficher();
					 }
				break;
				
			case 2:
				System.out.println("Ajout d'une nouvelle pizza :");
				
				int id;
				System.out.println("saisir id:");
				id = scn.nextInt();
				
				String code;
				System.out.println("saisir code :");
				code = scn.nextLine();
				
				String nom;
				System.out.println("saisir nom:");
				nom = scn.next();
				
				double prix;
				System.out.println("saisir prix :");
				prix = scn.nextDouble();
				
				ListePizzas.add(new Pizza(id, code, nom, prix));
				
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
