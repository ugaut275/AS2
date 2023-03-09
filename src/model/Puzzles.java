package model;

import java.math.BigInteger;

public class Puzzles extends Toy {
	// A String variable to store the type of puzzle
	public String type;
	
	// Getter method to get the type of puzzle
	public String getType() {
		return type;
	}
	
	// Setter method to set the type of puzzle
	public void setType(String type) {
		this.type = type;
	}
	
	// Constructor to initialize the Puzzles object with the given values
	public Puzzles(String sin, String item, String brand, double price, int stock, int age, String type) {
		super(sin, item, brand, price, stock, age);
		this.type = type;
	}
	
	// Override the toString method to display the Puzzles object as a string
	@Override
	public String toString() {
		return "Category: Puzzles " + " S_N: " + getS_N() + " Name is " + getName() + " Brand is  " + getBrand() + 
			" Cost: " + getPrice() + " Stock: " + getCount() + " Age restriction " + getAge() + " puzzle type " + getType();
	}
	
	// A method to format the Puzzles object into a string with a specific format
	public String format() {
		 return getS_N() + ";" + getName() + ";" + getBrand() + ";" + getPrice() + ";"  + getCount() + ";" + getAge() + ";" + getType(); 
	 }
}
