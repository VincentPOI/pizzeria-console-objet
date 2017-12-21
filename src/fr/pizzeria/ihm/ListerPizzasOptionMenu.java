package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY5
 *
 */
public class ListerPizzasOptionMenu extends OptionMenu {

	private String libelle;

	/**
	 * @param tabpizza
	 */
	public ListerPizzasOptionMenu(PizzaDaoImpl tabpizza, Scanner scn) {
		super(tabpizza, null);
		this.libelle = super.getLibelle() + "Lister les pizzas";
	}

	@Override
	public String getLibelle() {
		return this.libelle;
	}

	@Override
	public boolean execute() {
		
		List<Pizza> pizzas= this.tabpizza.findAllPizzas();
		for (Pizza pizza : pizzas) {
            System.out.println(pizza);
        }
		return true;
	}
}
