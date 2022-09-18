package model;

public class Product {
	private int id;
	private String name;
	private String description;
	private float price;
	private String src;
	private String type;
	private String brand;
	private int number;
	
	public Product() {}
	
	public Product (int id, String name,
			String description, float price,
			String src, String type, 
			String brand, int number) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.src = src;
		this.type = type;
		this.brand = brand;
		this.number = number;
	}
	
	public Product (int id, String name,
			String description, float price,
			String src, String type, 
			String brand) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.src = src;
		this.type = type;
		this.brand = brand;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getSrc() {
		return this.src;
	}
	
	public void setSrc(String src) {
		this.src = src;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
}
