package fr.pizzeria.ihm;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY5
 *
 */
public class ListerPizzasOptionMenu extends OptionMenu{
	
	private String libelle;

	/**
	 * @param tabpizza
	 */
	public ListerPizzasOptionMenu(Pizza[] tabpizza) {
		super(tabpizza);
		this.libelle = super.getLibelle()+"Lister les pizzas";
	}

	@Override
	public String getLibelle() {
		return this.libelle;
	}


	@Override
	public boolean execute() {
		System.out.println("Liste des pizzas :");
		for (int i = 0; i < this.tabpizza.length; i++) {
			if (this.tabpizza[i] != null) {
				this.tabpizza[i].afficher();
			}
		}
		System.out.println();
		return true;
	}
}
