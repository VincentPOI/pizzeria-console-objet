package fr.pizzeria.ihm;

import fr.pizzeria.model.Pizza;

/**
 * @author ETY5
 *
 */
public abstract class OptionMenu {
	
	protected String libelle;
	protected Pizza[] tabpizza;
	private static int nboptions;
	
	public OptionMenu(Pizza[] tabpizza) {
		super();
		this.libelle = Integer.toString(nboptions+1)+". " ;
		OptionMenu.nboptions++;
		this.tabpizza = tabpizza;
	}

	public String getLibelle(){
		return this.libelle;
	}
	
	/**
	 * @return
	 */
	public abstract boolean execute();
}
