package model;

import java.sql.Date;

public class Order {
	private int id;
	private String orderNumber;
	private Date today;
	private int quantity;
	private double totalPrice;
	/*
	private enum orderStatus{
		consegnato,
		inAttesa,
		spedito
	};
	*/
	
	
	public Order(int id, String orderNumber, Date today, int quantity, double totalPrice) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.today = today;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	
	@Override
	public String toString() {
		
		return "id: " + id + "\n" + "order number: " + orderNumber + "\ndata: " + today + "\nquantity: " + quantity + "\ntotal price: " + totalPrice;
	}
}
