package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {

	public List<Pizza> pizzas = new ArrayList<Pizza>();

	public PizzaDaoImpl() {
		super();
		pizzas.add(new Pizza("PEP", "P�p�roni", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("FRO", "Les 4 fromages", 12.00,CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("CAN", "La cannibale", 12.50,CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAV", "La savoyarde", 13.00,CategoriePizza.VIANDE));
		pizzas.add(new Pizza("ORI", "L'Orientale", 13.50,CategoriePizza.VIANDE));
		pizzas.add(new Pizza("IND", "L'indienne", 14.00,CategoriePizza. VIANDE));
	}


	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		this.pizzas.add(pizza);
		return false;
	}

	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {

		boolean pizzaUpdate = false;

		for (Pizza piz : this.pizzas) {
			if (piz.getCode().equals(codePizza)) {
				this.pizzas.set(this.pizzas.indexOf(piz), pizza);		
				pizzaUpdate = true;
			}
		}
		if (!pizzaUpdate) {
			throw new UpdatePizzaException("la pizza n'existe pas");
		}

		return false;
	}

	public boolean deletePizza(String codePizza) throws DeletePizzaException {

		boolean pizzaDelete = false;
		Pizza todelete = null;

		for (Pizza piz : this.pizzas) {
			if (piz.getCode().equals(codePizza)) {
				todelete = piz;
				pizzaDelete = true;
			}
		}

		if (!pizzaDelete) {
			throw new DeletePizzaException("la pizza n'existe pas et n'as pas pu etre supprim�e");
		} else {
			this.pizzas.remove(todelete);
		}
		return false;
	}

}
