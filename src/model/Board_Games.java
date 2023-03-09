package model;




public class Board_Games extends Toy {

	// instance variables
	private String Range;// maximum number of players
	private String developers; // developers of the game
	private int Min;
	private int Max;
	
	// getters and setters
	public void setMin(int Min) {
		this.Min = Min;
	}
	public int getMin() {
		return Min;
	}

	public int getMax() {
		return Max;
	}
	public void setMax(int Max) {
		this.Max = Max;
	}


	public String getDevelopers() {
		return developers;
	}
	public void setDevelopers(String developers) {
		this.developers = developers;
	}
	
	public void setRange(int x, int y) {
		Range = x+"-"+y;
	}
	public String getRange() {
		return Range;
	}

	// constructor
	public Board_Games(String sin, String item, String brand, double price, int stock, int age, int Min, int Max, String developers) {
		super(sin, item, brand, price, stock, age);
		this.Min = Min;
		this.Max = Max;
		this.developers = developers;
		setRange(Min, Max);
	}

	// override toString method to return information about the toy as a string
	@Override
	public String toString() {
		return "Category: Board Games " + " S_N: " +getS_N()+ " Name is " + getName()+ " Brand is  " + getBrand() +  " Cost: " + getPrice() + " Stock: " + getCount() +" Min Players " + getMin() + " Max PLayers:  "+ getMax() + " " +getDevelopers();
	}

	// method to return formatted string of the toy's properties
	public String format() {
		return  getS_N()+";" + getName()+";" + getBrand()+";" + getPrice()+";"  + getCount()+";" +getAge()+";"+getRange()+";"+getDevelopers() ; 
	}

	
	
}
