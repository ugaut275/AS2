package model;

public class BoardGames extends Toy {
	
	private int nPlayers;
	private String designers;
	
	public BoardGames(int sin, String item, String brand, int price, int stock, int age, int nPlayers, String designers) {
		super(sin, item, brand, price, stock, age);
		this.nPlayers = nPlayers;
		this.designers = designers;
	}
	
	public void setDesigners(String designers) {
		this.designers = designers;
	}
	
	public void setNumPlayers(int nPlayers) {
		this.nPlayers = nPlayers;
	}
	
	public String getDesigners() {
		return designers;
	}
	
	public int getNumPlayers() {
		return nPlayers;
	}
	
	@Override
	public String toString() {
		return "Category: BoardGame" + ", Serial Number:'" + getSIN() + '\'' + ", Name:'" + getItem() + '\'' + ", Brand:'" + getBrand() + '\'' + ", Price:" + getPrice() + ", Available Count:" + getStock() +  ", Age Appropriate:" + getAge() + ", Number of Players:'" + nPlayers + '\'' + ", Designer(s):'" + designers + "/n";
	}
}
