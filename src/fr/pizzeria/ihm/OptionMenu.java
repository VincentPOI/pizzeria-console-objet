package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.UpdatePizzaException;

import java.util.Scanner;

/**
 * @author ETY5
 *
 */
public abstract class OptionMenu {

	protected String libelle;
	protected IPizzaDao tabpizza;
	protected Scanner scn;
	private static int nboptions;

	public OptionMenu(IPizzaDao tabpizza2, Scanner scn) {
		super();
		this.scn = scn;
		this.libelle = Integer.toString(nboptions + 1) + ". ";
		OptionMenu.nboptions++;
		this.tabpizza = tabpizza2;
	}

	public String getLibelle() {
		return this.libelle;
	}

	/**
	 * @return
	 * @throws UpdatePizzaException 
	 */
	public abstract boolean execute();
}
