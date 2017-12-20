package fr.pizzeria.ihm;

import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	private String libelle;

	/**
	 * @param tabpizza
	 */
	public SupprimerPizzaOptionMenu(Pizza[] tabpizza) {
		super(tabpizza);
		this.libelle = super.getLibelle()+"Supprimer une pizza";
	}

	@Override
	public String getLibelle() {
		return this.libelle;
	}


	@Override
	public boolean execute() {
//		System.out.println("Suppression d'une pizza :");
//		System.out.println();
//		System.out.println("Code de la pizza à mettre à jours ?");
//		String codedeletepizza = scn.next();
//		for (int i = 0; i < pizzas.length; i++) {
//			if (pizzas[i] != null) {
//				if (pizzas[i].getCode().equals(codedeletepizza)) {
//					pizzas[i] = null;
//					break;
//				}
//			}
//		}
		return true;

	}
}
