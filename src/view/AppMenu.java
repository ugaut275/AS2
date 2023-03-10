package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.CustomExeptionClass;

import model.Toy;

public class AppMenu {

	public static void main(String[] args) {

		AppMenu.mainMenu();
	}

	public static int mainMenu() {
		try {
			System.out.println("*****************************************************************");
			System.out.println("*                 WELCOME TO TOY STORE COMPANY !                *");
			System.out.println("*****************************************************************\n");
			Scanner sc = new Scanner(System.in);
			System.out.println("How May We Help You?\n");
			System.out.println("(1) Search Inventory & Purchase Toy");
			System.out.println("(2) Add New Toy");
			System.out.println("(3) Remove Toy");
			System.out.println("(4) Save & Exit\n");
			System.out.print("Enter Option: ");
			int option = sc.nextInt();

			return option;

		} catch (InputMismatchException e) {
			mismatch();
			mainMenu();
		}
		return 0;
	}

	public static void askDelete() {
		System.out.println("Do you want to delete y/n?");
	}

	public static void selectDelete() {
		System.out.println("please select either y / n");
	}

	public static int searchAndPurchase() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Find Toys With:/n");
			System.out.println("(1) Serial Number(SN)");
			System.out.println("(2) Toy Name");
			System.out.println("(3) Type");
			System.out.println("(4) Back to Main Menu\n");
			System.out.print("Enter Option: ");
			int option = sc.nextInt();

			return option;
		} catch (InputMismatchException e) {
			mismatch();
			searchAndPurchase();
		}
		return 0;

	}

	public static void enter(String x) {
		System.out.println("Enter " + x);
	}

	public static void printList(int count, Toy toys) {
		System.out.println("\t " + count + " " + toys);
	}

	public static void noToy(String x) {
		System.out.println("No toy with that" + x + "exists");
	}

	public static void goBack(int goBack) {
		System.out.println("\t " + (goBack) + " Return to main menu");
	}

	public static void enterChoice() {
		System.out.println("Enter a choice");
	}

	public static void purchaseC() {
		System.out.println("Purchase complete");
	}

	public static void noStock() {
		System.out.println("Out of stock sorry");
	}

	public static void outOfBounds() {
		System.out.println("Enter a option from the Menu. Returning to select returning to menu ");
	}

	public static void mismatch() {
		System.out.println("Invalid input returning to menu ");
	}

	public static void sns() {
		System.out.println("S_N must be 10 digits long");
	}

	public static void S_N() {
		System.out.println("S_N cant contain letters");
	}

	public static void lessthan10() {
		System.out.println("S_N cant be less than 10 digits");
	}

	public static void morethan10() {
		System.out.println("S_N cant be more than 10 digits");
	}

	public static void wrongInput() {
		System.out.println("Cannot input that type");
	}

	public static void existS_N() {
		System.out.println("S_N already exists");
	}

	public static int searchResults(int count, Toy toys) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Here are the search results:/n");
		System.out.println("\t" + count + " " + toys);
		System.out.println("\t" + count + " " + "Back To Search Menu/n");
		System.out.print("Enter option number to purchase: ");
		int option = sc.nextInt();
		return option;

	}

	public static String removeToy(Toy toys) {
		Scanner sc = new Scanner(System.in);
		System.out.println("This Item Found:");
		System.out.println("\t" + toys + "/n");
		System.out.print("Do you want to remove it (Y/N)? ");
		String option = sc.nextLine().toUpperCase();
		return option;

	}

	public static void itemRemoved() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Item Removed!\n");
		System.out.println("Press Enter to continue...");
		sc.nextLine(); // waits for user to press enter
	}

	/**
	 * 
	 * Method to add a new figure toy to the ArrayList.
	 * 
	 * @throws CustomExeptionClass if any of the values entered are negative.
	 * @return an Object array containing information on the newly added figure toy.
	 */

	public static Object[] addFig() throws CustomExeptionClass {
		try {
			Scanner sc = new Scanner(System.in);
			Scanner sc1 = new Scanner(System.in);
			System.out.println("enter name ");
			String input1 = sc.nextLine();
			System.out.println("brand :");
			String input2 = sc.nextLine();
			System.out.println("enter price :");
			Double price = sc.nextDouble();
			if (price < 0) {
				throw new CustomExeptionClass("Cant have negative price, try again");
			}
			System.out.println("enter stock :");
			int stock = sc.nextInt();
			System.out.println("enter age");
			int age = sc.nextInt();
			if (age < 0) {
				throw new CustomExeptionClass("Cant have negative age, try again");
			}

			System.out.println("enter a,d or h");
			String bb = sc1.nextLine().toUpperCase();

			Object[] fig = { input1, input2, price, stock, age, bb };
			return fig;
		} catch (InputMismatchException e) {
			mismatch();
			addFig();
		}

		return null;

	}

	/**
	 * 
	 * Method to add a new Animal toy to the ArrayList.
	 * 
	 * @throws CustomExeptionClass if any of the values entered are negative.
	 * @return an Object array containing information on the newly added figure toy.
	 */
	public static Object[] addAnimals() throws CustomExeptionClass {
		try {
			Scanner sc = new Scanner(System.in);
			Scanner sc1 = new Scanner(System.in);
			System.out.println("enter name ");
			String input1 = sc.nextLine();
			System.out.println("brand :");
			String input2 = sc.nextLine();
			System.out.println("enter price :");
			Double price = sc.nextDouble();
			if (price < 0) {
				throw new CustomExeptionClass("Cant have negative price, try again");
			}
			System.out.println("enter stock :");
			int stock = sc.nextInt();
			if (stock < 0) {

				throw new CustomExeptionClass("Cant have negative stock, try again");

			}
			System.out.println("enter age");
			int age = sc.nextInt();

			if (age < 0) {
				throw new CustomExeptionClass("Cant have negative age, try again");
			}

			System.out.println("Enter material type");
			String material = sc1.nextLine();

			System.out.println("enter s,m or h");
			String bb = sc1.nextLine().toUpperCase();

			Object[] fig = { input1, input2, price, stock, age, material, bb };

			return fig;
		} catch (InputMismatchException e) {
			mismatch();
			addAnimals();
		}

		return null;

	}

	/**
	 * 
	 * This method prompts the user to input information about a puzzle product and
	 * creates an Object array with the information. The information includes the
	 * name, brand, price, stock, age, material type, and type.
	 * 
	 * @return Object array with the animal product information.
	 * @throws CustomExeptionClass when the price, age or stock input is negative.
	 */
	public static Object[] addPuz() throws CustomExeptionClass {
		try {
			Scanner sc = new Scanner(System.in);
			Scanner sc1 = new Scanner(System.in);
			System.out.println("enter name ");
			String input1 = sc.nextLine();
			System.out.println("brand :");
			String input2 = sc.nextLine();
			System.out.println("enter price :");
			Double price = sc.nextDouble();
			if (price < 0) {
				throw new CustomExeptionClass("Cant have negative price, try again");
			}
			System.out.println("enter stock :");
			int stock = sc.nextInt();
			if (stock < 0) {

				throw new CustomExeptionClass("Cant have negative stock, try again");

			}
			System.out.println("enter age");
			int age = sc.nextInt();
			
			if (age < 0) {
				throw new CustomExeptionClass("Cant have negative age, try again");
			}
			

			System.out.println("enter M,C,L,T or R");
			String bb = sc1.nextLine().toUpperCase();

			Object[] fig = { input1, input2, price, stock, age, bb };
			return fig;
		} catch (InputMismatchException e) {
			mismatch();
			addPuz();
		}

		return null;

	}

	/**
	 * 
	 * Method to add a new BoardGames toy to the ArrayList.
	 * 
	 * @throws CustomExeptionClass if any of the values entered are negative.
	 * @return an Object array containing information on the newly added figure toy.
	 */

	public static Object[] addBoard() throws CustomExeptionClass {
		try {
			Scanner sc = new Scanner(System.in);
			Scanner sc1 = new Scanner(System.in);
			System.out.println("enter name ");
			String input1 = sc.nextLine();
			System.out.println("brand :");
			String input2 = sc.nextLine();
			System.out.println("enter price :");
			Double price = sc.nextDouble();
			if (price < 0) {
				throw new CustomExeptionClass("Cant have negative price, try again");
			}
			System.out.println("enter stock :");
			int stock = sc.nextInt();
			if (stock < 0) {

				throw new CustomExeptionClass("Cant have negative stock, try again");

			}
			System.out.println("enter age");
			int age = sc.nextInt();

			if (age < 0) {
				throw new CustomExeptionClass("Cant have negative age, try again");
			}
			System.out.println("Enter min players :");
			int min = sc.nextInt();
			if (min < 0) {
				throw new CustomExeptionClass("min players cant be less than 0, try again");
			}
			System.out.println("Enter max age :");
			int max = sc.nextInt();
			if (max < 0) {
				throw new CustomExeptionClass("max players cant be less than 0, try again");
			}
			if (min > max) {
				throw new CustomExeptionClass("min players cant be more than max players");
			}
			System.out.println("Enter designer names seperated by commas ");

			String des = sc1.nextLine();

			Object[] fig = { input1, input2, price, stock, age, min, max, des };
			return fig;

		} catch (InputMismatchException e) {
			mismatch();
			addBoard();
		}

		return null;
	}

	public static void dataSaved() {
		System.out.println("Saving Data Into Database.../n");
		System.out.println("*********** THANKS FOR VISITING US! ***********");
	}

}
