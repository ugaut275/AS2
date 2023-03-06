package model;

public class Animals extends Toy {
	
	private String material;
	private String size;
	
	public Animals(int sin, String item, String brand, int price, int stock, int age, String material, String size) {
		super(sin, item, brand, price, stock, age);
		this.material = material;
		this.size = size;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public String getSize() {
		return size;
	}
	
	@Override
	public String toString() {
		return "Category: Animal" + ", Serial Number:'" + getSIN() + '\'' + ", Name:'" + getItem() + '\'' + ", Brand:'" + getBrand() + '\'' + ", Price:" + getPrice() + ", Available Count:" + getStock() +  ", Age Appropriate:" + getAge() + ", Material:'" + material + '\'' + ", Size:'" + size + "/n";
	}
}
