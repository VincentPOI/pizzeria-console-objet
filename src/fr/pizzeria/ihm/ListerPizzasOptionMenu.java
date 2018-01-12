package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import static fr.pizzeria.console.PizzeriaAdminConsoleApp.LOG;

import fr.pizzeria.dao.IPizzaDao;
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
	public ListerPizzasOptionMenu(IPizzaDao tabpizza, Scanner scn) {
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
            LOG.info(pizza.toString());
        }
		return true;
	}
}
