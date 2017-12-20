package fr.pizzeria.ihm;

import fr.pizzeria.model.Pizza;
import java.util.Scanner;

/**
 * @author ETY5
 *
 */
public abstract class OptionMenu {

	protected String libelle;
	protected Pizza[] tabpizza;
	protected Scanner scn;
	private static int nboptions;

	public OptionMenu(Pizza[] tabpizza, Scanner scn) {
		super();
		this.scn = scn;
		this.libelle = Integer.toString(nboptions + 1) + ". ";
		OptionMenu.nboptions++;
		this.tabpizza = tabpizza;
	}

	public String getLibelle() {
		return this.libelle;
	}

	/**
	 * @return
	 */
	public abstract boolean execute();
}
