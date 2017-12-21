package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {

	private String libelle;

	/**
	 * @param tabpizza
	 */
	public ModifierPizzaOptionMenu(PizzaDaoImpl tabpizza, Scanner scn) {
		super(tabpizza, scn);
		this.libelle = super.getLibelle() + "Modifier une pizza";
	}

	@Override
	public String getLibelle() {
		return this.libelle;
	}

	@Override
	public boolean execute() {
		System.out.println("Mise � jour d'une pizza :");
		System.out.println("Code de la pizza � mettre � jours ?");
		System.out.println("(99 pour abandoner)");

		String codeupdatepizza = scn.next();

		if (codeupdatepizza.equals(99)) {
			return false;
		}
		
		String code;
		System.out.println("saisir code :");
		code = scn.next();
		

		String nom;
		System.out.println("saisir nom (sans espace):");
		nom = scn.next();

		double prix;
		System.out.println("saisir prix :");
		prix = scn.nextDouble();
		
		System.out.println("saisir la cat�gorie (VIANDE/POISSON/SANS_VIANDE) :");
		CategoriePizza cate = CategoriePizza.valueOf(scn.next().toUpperCase());
		
		try {
			this.tabpizza.updatePizza(codeupdatepizza, new Pizza(code, nom, prix,cate));
		} catch (UpdatePizzaException e) {
			System.out.println(e.getMessage());
		}
		

		return true;

	}
}
