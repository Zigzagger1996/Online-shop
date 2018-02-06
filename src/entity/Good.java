package entity;

import dao.Identified;

public class Good implements Identified<Integer> {
	private Integer id;
	private String name;
	private int quantity;
	private double price;
	private String link;
	
	public Good() {
		id = 0;
		name = "";
		quantity =0;
		price = 0;
		link = "";
	}

	@Override
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setId(Integer id) {
		this.id= id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setLink(String link) {
		this.link = link;		
	}

}
