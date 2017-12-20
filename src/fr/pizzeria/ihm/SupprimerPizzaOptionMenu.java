package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	private String libelle;

	/**
	 * @param tabpizza
	 */
	public SupprimerPizzaOptionMenu(PizzaDaoImpl tabpizza, Scanner scn) {
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
		System.out.println("Code de la pizza � supprimer ?");
		System.out.println("(99 pour abandoner)");
		String codedeletepizza = scn.next();
		
		if (codedeletepizza.equals(99)) {
			return false;
		}
		
		
		this.tabpizza.deletePizza(codedeletepizza);
		
		return true;

	}
}
