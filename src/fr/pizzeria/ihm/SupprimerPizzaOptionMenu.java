package fr.pizzeria.ihm;

import java.util.Scanner;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	private String libelle;

	/**
	 * @param tabpizza
	 */
	public SupprimerPizzaOptionMenu(Pizza[] tabpizza, Scanner scn) {
		super(tabpizza, scn);
		this.libelle = super.getLibelle() + "Supprimer une pizza";
	}

	@Override
	public String getLibelle() {
		return this.libelle;
	}

	@Override
	public boolean execute() {
		System.out.println("Suppression d'une pizza :");
		System.out.println();
		System.out.println("Code de la pizza à mettre à jours ?");
		String codedeletepizza = scn.next();
		for (int i = 0; i < this.tabpizza.length; i++) {
			if (this.tabpizza[i] != null) {
				if (this.tabpizza[i].getCode().equals(codedeletepizza)) {
					this.tabpizza[i] = null;
					return true;
				}
			}
		}
		return false;

	}
}
