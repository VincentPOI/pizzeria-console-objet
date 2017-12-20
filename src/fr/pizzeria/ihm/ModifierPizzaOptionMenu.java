package fr.pizzeria.ihm;

import java.util.Scanner;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {

	private String libelle;

	/**
	 * @param tabpizza
	 */
	public ModifierPizzaOptionMenu(Pizza[] tabpizza, Scanner scn) {
		super(tabpizza, scn);
		this.libelle = super.getLibelle() + "Modifier une pizza";
	}

	@Override
	public String getLibelle() {
		return this.libelle;
	}

	@Override
	public boolean execute() {
		System.out.println("Mise à jour d'une pizza :");
		System.out.println("Code de la pizza à mettre à jours ?");
		System.out.println("(99 pour abandoner)");

		String codeupdatepizza = scn.next();

		if (codeupdatepizza.equals(99)) {
			return false;
		}
		;

		for (int i = 0; i < this.tabpizza.length; i++) {
			if (this.tabpizza[i] != null) {
				if (this.tabpizza[i].getCode().equals(codeupdatepizza)) {

					System.out.println("saisir code :");
					this.tabpizza[i].setCode(scn.next());

					System.out.println("saisir nom (sans espace):");
					this.tabpizza[i].setNom(scn.next());

					System.out.println("saisir prix :");
					this.tabpizza[i].setPrix(scn.nextDouble());
					break;
				}
			}
		}

		return true;

	}
}
