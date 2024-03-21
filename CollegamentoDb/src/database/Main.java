package database;

import java.sql.SQLException;

import model.Order;

public class Main {

	public static void main(String[] args) throws SQLException {
		Database db = new Database();
		
		Order ordine = new Order();
		
		try {
			db.testDb();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		ordine.printColumnOrder();
		ordine.updateOrder();
	}
}
