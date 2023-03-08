package model;

public class Puzzles extends Toy {
	
	private String puzzleType;
	
	public Puzzles(String sin, String item, String brand, int price, int stock, int age, String puzzleType) {
		super(sin, item, brand, price, stock, age);
		this.puzzleType = puzzleType;
	}
	
	public void setPuzzleType(String puzzleType) {
		this.puzzleType = puzzleType;
	}
	
	public String getPuzzleType() {
		return puzzleType;
	}
	
	@Override
	public String toString() {
		return "Category: Puzzle" + ", Serial Number:'" + getSIN() + '\'' + ", Name:'" + getItem() + '\'' + ", Brand:'" + getBrand() + '\'' + ", Price:" + getPrice() + ", Available Count:" + getStock() +  ", Age Appropriate:" + getAge() + ", Puzzle Type:'" + puzzleType + "/n";
	}
}

