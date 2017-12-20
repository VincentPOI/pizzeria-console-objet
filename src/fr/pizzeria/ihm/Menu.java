package fr.pizzeria.ihm;

import java.util.ArrayList;
import fr.pizzeria.model.Pizza;

public class Menu {
	
	private Pizza[] tabpizza;
	private ArrayList<OptionMenu> listeOptions = new ArrayList<OptionMenu>();
	private ListerPizzasOptionMenu lister;
	private AjouterPizzaOptionMenu ajouter;
	private ModifierPizzaOptionMenu modifier;
	private SupprimerPizzaOptionMenu supprimer;
	
	
	public OptionMenu getOptions(int i) {
		return listeOptions.get(i);
	}
	public Menu(Pizza[] tabpizza) {
		super();
		this.tabpizza = tabpizza;
		lister = new ListerPizzasOptionMenu(tabpizza);
		ajouter = new AjouterPizzaOptionMenu(tabpizza);
		modifier = new ModifierPizzaOptionMenu(tabpizza);
		supprimer = new SupprimerPizzaOptionMenu(tabpizza);
		listeOptions.add(lister);
		listeOptions.add(ajouter);
		listeOptions.add(modifier);
		listeOptions.add(supprimer);
	}

	public Pizza[] getTabpizza() {
		return tabpizza;
	}

	public void setTabpizza(Pizza[] tabpizza) {
		this.tabpizza = tabpizza;
	}

	public void afficher() {
		for (OptionMenu option : listeOptions) {
            System.out.println(option.getLibelle());
        }
	}

}
