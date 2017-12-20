package fr.pizzeria.ihm;

import java.util.ArrayList;
import java.util.Scanner;
import fr.pizzeria.model.Pizza;

public class Menu {
	
	private Pizza[] tabpizza;
	private Scanner scn;
	private ArrayList<OptionMenu> listeOptions = new ArrayList<OptionMenu>();

	public OptionMenu getOptions(int i) {
		return listeOptions.get(i);
	}
	
	public Menu(Pizza[] tabpizza, Scanner scn) {
		super();
		this.tabpizza = tabpizza;
		this.scn = scn;
		listeOptions.add(new ListerPizzasOptionMenu(tabpizza, scn));
		listeOptions.add(new AjouterPizzaOptionMenu(tabpizza, scn));
		listeOptions.add(new ModifierPizzaOptionMenu(tabpizza, scn));
		listeOptions.add(new SupprimerPizzaOptionMenu(tabpizza, scn));
	}

	public Pizza[] getTabpizza() {
		return tabpizza;
	}

	public void setTabpizza(Pizza[] tabpizza) {
		this.tabpizza = tabpizza;
	}

	public void afficher() {
		System.out.println("***** Pizzeria Administration *****");
		for (OptionMenu option : listeOptions) {
            System.out.println(option.getLibelle());
        }
	}

}
