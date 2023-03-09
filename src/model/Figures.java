package model;



public class Figures extends Toy {
	// A String field to store the type of the figure
	private String type;
	
	// Getter method for type
	public String getType() {
		return type;
	}
	
	// Setter method for type
	public void setType(String type) {
		this.type = type;
	}
	
	// Constructor for Figures class
	public Figures(String sin, String item, String brand, double price, int stock, int age, String type) {
		super(sin, item, brand, price, stock, age);
		this.type = type;
	}
	
	// Overriding the toString method to provide a custom string representation of the Figures object
	@Override
	public String toString() {
		return "Category: Figure"+ " S_N: " +getS_N()+ ", Name is " + getName()+ ", Brand is  " + getBrand() +  ", Cost: " + getPrice() + " , Stock: " + getCount() +". Age restriction " +getAge() + ", doll type " + getType();
		
	}
	
	// Overriding the format method from the Toy class to return a semicolon-separated string of all attributes of Figures object
	@Override
	 public String format() {
		 return getS_N()+";" + getName()+";" + getBrand()+";" + getPrice()+";"  + getCount()+";" +getAge()+";" + getType(); 
	 }
}
