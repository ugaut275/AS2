package model;

public class Figures extends Toy {
	
	private String classification;
	
	public Figures(String sin, String item, String brand, int price, int stock, int age, String classification) {
		super(sin, item, brand, price, stock, age);
		this.classification = classification;
	}
	
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	public String getClassification() {
		return classification;
	}
	
	@Override
	public String toString() {
		return "Category: Figure" + ", Serial Number:'" + getSIN() + '\'' + ", Name:'" + getItem() + '\'' + ", Brand:'" + getBrand() + '\'' + ", Price:" + getPrice() + ", Available Count:" + getStock() +  ", Age Appropriate:" + getAge() + ", Classification:'" + classification + "/n";
	}
}

