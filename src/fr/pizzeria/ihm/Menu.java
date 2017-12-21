package fr.pizzeria.ihm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;

public class Menu {
	
	private PizzaDaoImpl tabpizza;
	private Scanner scn;
	private List<OptionMenu> listeOptions = new ArrayList<OptionMenu>();

	public OptionMenu getOptions(int i) {
		return listeOptions.get(i);
	}
	
	public Menu(PizzaDaoImpl tabpizza, Scanner scn) {
		super();
		this.tabpizza = tabpizza;
		this.scn = scn;
		listeOptions.add(new ListerPizzasOptionMenu(tabpizza, scn));
		listeOptions.add(new AjouterPizzaOptionMenu(tabpizza, scn));
		listeOptions.add(new ModifierPizzaOptionMenu(tabpizza, scn));
		listeOptions.add(new SupprimerPizzaOptionMenu(tabpizza, scn));
	}

	public PizzaDaoImpl getTabpizza() {
		return tabpizza;
	}

	public void setTabpizza(PizzaDaoImpl tabpizza) {
		this.tabpizza = tabpizza;
	}

	public void afficher() {
		System.out.println("***** Pizzeria Administration *****");
		for (OptionMenu option : listeOptions) {
            System.out.println(option.getLibelle());
        }
	}

}
