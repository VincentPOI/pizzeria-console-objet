package fr.pizzeria.ihm;

import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu{
	
	private String libelle;

	/**
	 * @param tabpizza
	 */
	public AjouterPizzaOptionMenu(Pizza[] tabpizza) {
		super(tabpizza);
		this.libelle = super.getLibelle()+"Ajouter une pizza";
	}

	@Override
	public String getLibelle() {
		return this.libelle;
	}


	@Override
	public boolean execute() {
//		System.out.println("Ajout d'une nouvelle pizza :");
//
//		String code;
//		System.out.println("saisir code :");
//		code = scn.next();
//
//		String nom;
//		System.out.println("saisir nom (sans espace):");
//		nom = scn.next();
//
//		double prix;
//		System.out.println("saisir prix :");
//		prix = scn.nextDouble();
//
//		for (int i = 0; i < pizzas.length; i++) {
//			if (pizzas[i] == null) {
//				pizzas[i] = new Pizza(code, nom, prix);
//				break;
//			}
//		}
		return true;

	}
}
