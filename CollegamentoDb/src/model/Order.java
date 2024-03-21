package model;

import java.sql.Date;

public class Order {
	private int id;
	private String orderNumber;
	private Date today;
	private int quantity;
	private double totalPrice;
	
	// definizione enum
	public enum orderStatus {
		consegnato, attesa, spedito
	};
	
	// campo che memorizza lo stato dell'ordine
	private orderStatus status;
	
	

	
	
	public Order(int id, String orderNumber, Date today, int quantity, double totalPrice, orderStatus status) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.today = today;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "id: " + id + "\n" + "order number: " + orderNumber + "\ndata: " + today + "\nquantity: " + quantity + "\ntotal price: " + totalPrice + "\norder status: " + status; 
	}
}
