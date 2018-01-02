package fr.pizzeria.ihm;

import java.util.Scanner;

import static fr.pizzeria.console.PizzeriaAdminConsoleApp.LOG;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.DeletePizzaException;

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
		LOG.info("Suppression d'une pizza :");
		LOG.info("Code de la pizza � supprimer ?");
		LOG.info("(99 pour abandoner)");
		String codedeletepizza = scn.next();
		
		if (codedeletepizza.equals(99)) {
			return false;
		}
		
		
		try {
			this.tabpizza.deletePizza(codedeletepizza);
		} catch (DeletePizzaException e) {
			// TODO Auto-generated catch block
			LOG.info(e.getMessage());
		}
		
		return true;

	}
}
