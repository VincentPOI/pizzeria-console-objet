package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {

	private String libelle;

	/**
	 * @param tabpizza
	 */
	public AjouterPizzaOptionMenu(PizzaDaoImpl tabpizza, Scanner scn) {
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
		
		try {
			this.tabpizza.saveNewPizza(new Pizza(code, nom, prix));
		} catch (SavePizzaException e) {
			System.out.println(e.getMessage());
		}

		return false;

	}
}
