package fr.pizzeria.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class IPizzaDaoJDBC implements IPizzaDao {

	String driver = PizzeriaAdminConsoleApp.bundle.getString("driver");
	String url = PizzeriaAdminConsoleApp.bundle.getString("url");
	String user = PizzeriaAdminConsoleApp.bundle.getString("user");
	String password = PizzeriaAdminConsoleApp.bundle.getString("password");
	public Connection conn = null;
	

	public IPizzaDaoJDBC() throws ClassNotFoundException, SQLException {
		
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
	}
	

	public List<Pizza> findAllPizzas() {

		List<Pizza> pizzas = new ArrayList<Pizza>();
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet resultats = statement.executeQuery("SELECT * FROM bh5dnoeun.pizza");
			while (resultats.next()) {
				String code = resultats.getString("Code");
				String name = resultats.getString("Name");
				double price = resultats.getDouble("Price");
				CategoriePizza cate = CategoriePizza.valueOf(resultats.getString("Category").toUpperCase());
				Pizza pizza = new Pizza(code, name, price, cate);
				pizzas.add(pizza);			
			}
			resultats.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pizzas;
	}

	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		PreparedStatement savePizza;
		try {
			savePizza = conn.prepareStatement("INSERT INTO bh5dnoeun.pizza (code,Name,Price,Category) VALUES (?,?,?,?)");
			savePizza.setString(1, pizza.getCode());
			savePizza.setString(2, pizza.getNom());
			savePizza.setDouble(3, pizza.getPrix());
			savePizza.setString(4, pizza.getCate().toString());
			savePizza.executeUpdate();
			savePizza.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		
		PreparedStatement updtPizza;
		try {
			updtPizza = conn.prepareStatement("UPDATE bh5dnoeun.pizza SET Code=?, Name=?, Price=?, Category=? WHERE Code=?");
			updtPizza.setString(1, pizza.getCode());
			updtPizza.setString(2, pizza.getNom());
			updtPizza.setDouble(3, pizza.getPrix());
			updtPizza.setString(4, pizza.getCate().toString());
			updtPizza.setString(5,codePizza);
			int maj = updtPizza.executeUpdate();
			updtPizza.close();
			if (maj == 0)
				throw new UpdatePizzaException("Pizza � modifier non trouv�e dans la base de donn�es");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return true;
	}

	public boolean deletePizza(String codePizza) throws DeletePizzaException {	
		PreparedStatement dltPizza;
		try {
			dltPizza = conn.prepareStatement("DELETE FROM bh5dnoeun.pizza WHERE code=?");
			dltPizza.setString(1, codePizza);
			int del = dltPizza.executeUpdate();
			dltPizza.close();
			if (del == 0)
				throw new DeletePizzaException("Pizza � supprimer non trouv�e dans la base de donn�es");
			
		} catch (SQLException e) {
			e.getMessage();
		}
		return true;
	}
	

	public void closeConn(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
