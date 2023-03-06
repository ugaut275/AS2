package model;

public abstract class Toy {
	
	private int sin;
	private int price;
	private int stock;
	private int age;
	private String item;
	private String brand;
	
	public Toy(int sin, String item, String brand, int price, int stock, int age) {
		
		this.sin = sin;
		this.item = item;
		this.brand = brand;
		this.price = price;
		this.stock = stock;
		this.age = age;

	}
	
	
	public void setSIN(int sin) {
		this.sin = sin;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	public int getSIN() {
		return sin;
	}
	public String getItem() {
		return item;
	}
	public String getBrand() {
		return brand;
	}
	public int getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	public int getAge() {
		return age;
	}
	
	
	public abstract String toString();


}
