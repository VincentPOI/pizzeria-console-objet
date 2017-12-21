package fr.pizzeria.dao;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {

	public Pizza[] pizzas; 

	public PizzaDaoImpl() {
		super();
		pizzas = new Pizza[8];
		pizzas[0] = new Pizza("PEP", "Pépéroni", 12.50);
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
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		
		boolean pizzaSauvegarde = false;
		
		for (int i = 0; i < this.pizzas.length; i++) {
			if (this.pizzas[i] == null) {
				this.pizzas[i] = pizza;
				pizzaSauvegarde = true;
			}
			if (!pizzaSauvegarde){
				throw new SavePizzaException("le tableau est plein");
			}
		}
		
		
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		
		boolean pizzaUpdate = false;
		
		for (int i = 0; i < this.pizzas.length; i++) {
			if (this.pizzas[i] != null) {
				if (this.pizzas[i].getCode().equals(codePizza)) {
					this.pizzas[i] = pizza;
					pizzaUpdate = true;
				}				
			}
			if (!pizzaUpdate){
				throw new UpdatePizzaException("la pizza n'existe pas");
			}
		}
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		
		boolean pizzaDelete =true;
		
		for (int i = 0; i < this.pizzas.length; i++) {
			if (this.pizzas[i] != null) {
				if (this.pizzas[i].getCode().equals(codePizza)) {
					this.pizzas[i] = null;
					pizzaDelete = true;
				}
			}
			if (!pizzaDelete){
				throw new DeletePizzaException("la pizza n'existe pas et n'as pas pu etre supprimée");
			}
		}
		return false;
	}

}
