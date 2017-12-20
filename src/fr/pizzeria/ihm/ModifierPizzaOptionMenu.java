package fr.pizzeria.ihm;

import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu{

	private String libelle;

	/**
	 * @param tabpizza
	 */
	public ModifierPizzaOptionMenu(Pizza[] tabpizza) {
		super(tabpizza);
		this.libelle = super.getLibelle()+"Modifier une pizza";
	}

	@Override
	public String getLibelle() {
		return this.libelle;
	}


	@Override
	public boolean execute() {
//		System.out.println("Mise à jour d'une pizza :");
//		System.out.println("Code de la pizza à mettre à jours ?");
//		System.out.println("(99 pour abandoner)");
//
//		String codeupdatepizza = scn.next();
//
//		if (codeupdatepizza.equals(99)) {
//			break;
//		}
//		;
//
//		for (int i = 0; i < pizzas.length; i++) {
//			if (pizzas[i] != null) {
//				if (pizzas[i].getCode().equals(codeupdatepizza)) {
//
//					System.out.println("saisir code :");
//					pizzas[i].setCode(scn.next());
//
//					System.out.println("saisir nom (sans espace):");
//					pizzas[i].setNom(scn.next());
//
//					System.out.println("saisir prix :");
//					pizzas[i].setPrix(scn.nextDouble());
//					break;
//				}
//			}
//		}

		return true;

	}
}
