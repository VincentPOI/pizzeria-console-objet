package fr.pizzeria.ihm;

import java.util.Scanner;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {

	private String libelle;

	/**
	 * @param tabpizza
	 */
	public AjouterPizzaOptionMenu(Pizza[] tabpizza, Scanner scn) {
		super(tabpizza, scn);
		this.libelle = super.getLibelle() + "Ajouter une pizza";
	}

	@Override
	public String getLibelle() {
		return this.libelle;
	}

	@Override
	public boolean execute() {
		System.out.println("Ajout d'une nouvelle pizza :");

		String code;
		System.out.println("saisir code :");
		code = scn.next();

		String nom;
		System.out.println("saisir nom (sans espace):");
		nom = scn.next();

		double prix;
		System.out.println("saisir prix :");
		prix = scn.nextDouble();

		for (int i = 0; i < this.tabpizza.length; i++) {
			if (this.tabpizza[i] == null) {
				this.tabpizza[i] = new Pizza(code, nom, prix);
				return true;
			}
		}
		return false;

	}
}
