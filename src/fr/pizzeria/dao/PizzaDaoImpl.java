package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {

	public Pizza[] pizzas = new Pizza[1000];

	public PizzaDaoImpl() {
		super();
		pizzas[0] = new Pizza("PEP", "P�p�roni", 12.50);
		pizzas[1] = new Pizza("MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza("REIN", "La Reine", 11.50);
		pizzas[3] = new Pizza("FRO", "Les 4 fromages", 12.00);
		pizzas[4] = new Pizza("CAN", "La cannibale", 12.50);
		pizzas[5] = new Pizza("SAV", "La savoyarde", 13.00);
		pizzas[6] = new Pizza("ORI", "L'Orientale", 13.50);
		pizzas[7] = new Pizza("IND", "L'indienne", 14.00);
	}

	@Override
	public Pizza[] findAllPizzas() {
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {
		for (int i = 0; i < this.pizzas.length; i++) {
			if (this.pizzas[i] == null) {
				this.pizzas[i] = pizza;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		for (int i = 0; i < this.pizzas.length; i++) {
			if (this.pizzas[i] != null) {
				if (this.pizzas[i].getCode().equals(codePizza)) {
					this.pizzas[i] = pizza;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		for (int i = 0; i < this.pizzas.length; i++) {
			if (this.pizzas[i] != null) {
				if (this.pizzas[i].getCode().equals(codePizza)) {
					this.pizzas[i] = null;
					return true;
				}
			}
		}
		return false;
	}

}
