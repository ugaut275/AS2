package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Animals;
import model.Board_Games;
import model.CustomExeptionClass;
import model.Figures;
import model.Puzzles;
import model.Toy;
import view.AppMenu;

/**
 * 
 * A class to manage the application's toy inventory.
 * 
 * Extends AppMenu class to inherit the menu interface for user interaction.
 */
public class AppManager extends AppMenu {

	private static ArrayList<Toy> arrList = new ArrayList<Toy>(); // ArrayList to store all the Toy objects
	private static File f = new File("res/toys.txt"); // File object for the text file that stores the toy data

	/**
	 * 
	 * Constructor to create an instance of AppManager and load toy data from the
	 * text file.
	 */
	public AppManager() {
		loadFile();
	}

	/**
	 * 
	 * Method to load toy data from the text file and create Toy objects. Uses
	 * BufferedReader and FileReader objects to read from the text file. Each line
	 * of the text file is split into an array of Strings to create Toy objects. Toy
	 * objects are added to the ArrayList. If any error occurs during file reading,
	 * it is printed to the console.
	 */
	public static void loadFile() {
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			int count = 0;
			while ((line = br.readLine()) != null) {
				count++;
				String[] split = line.split(";");
				if (split[0].charAt(0) == '0' || split[0].charAt(0) == '1') {
					arrList.add(new Figures(split[0], split[1], split[2], Double.parseDouble(split[3]),
							Integer.parseInt(split[4]), Integer.parseInt(split[5]), split[6]));
				} else if (split[0].charAt(0) == '2' || split[0].charAt(0) == '3') {
					arrList.add(new Animals(split[0], split[1], split[2], Double.parseDouble(split[3]),
							Integer.parseInt(split[4]), Integer.parseInt(split[5]), split[6], split[7]));
				} else if (split[0].charAt(0) == '4' || split[0].charAt(0) == '5' || split[0].charAt(0) == '6') {
					arrList.add(new Puzzles(split[0], split[1], split[2], Double.parseDouble(split[3]),
							Integer.parseInt(split[4]), Integer.parseInt(split[5]), split[6]));
				} else if (split[0].charAt(0) == '7' || split[0].charAt(0) == '8' || split[0].charAt(0) == '9') {
					String[] split2 = split[6].split("-");
					arrList.add(new Board_Games(split[0], split[1], split[2], Double.parseDouble(split[3]),
							Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split2[0]),
							Integer.parseInt(split2[1]), split[7]));
				}
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Method to save toy data to the text file. Uses FileWriter and PrintWriter
	 * objects to write to the text file. Each Toy object in the ArrayList is
	 * formatted into a String using the format method of the Toy class. The
	 * formatted String is written to the text file. If any error occurs during file
	 * writing, it is printed to the console.
	 */

	public static void saveFile() {
		// Create a FileWriter and PrintWriter objects to write to the text file
		try {
			FileWriter fw = new FileWriter("res/toys.txt");
			PrintWriter pw = new PrintWriter(fw);
			// Write each Toy object to the file
			for (Toy toys : arrList) {
				pw.println(toys.format());
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	Method to purchase a toy by its name
	This method prompts the user to input a name of the toy they wish to purchase. It then searches the array list of toys for a match
	to the input name. If a match is found, it displays the list of toys with the matching name, and prompts the user to choose which
	toy they want to purchase. If the selected toy is in stock, it decreases the count by 1, and saves the updated list to the text file.
	If no toy with the matching name is found, the method displays an appropriate message and calls itself recursively until a toy is found.
	@throws IndexOutOfBoundsException if the user inputs an invalid index for the selected toy
	@throws InputMismatchException if the user inputs a non-integer value for the toy selection
	*/
	public static void purchaseName() {

		boolean found = false;
		ArrayList<Toy> secondList = new ArrayList<Toy>();
		Scanner sc = new Scanner(System.in);
		enter("name");
		String input = sc.nextLine().toLowerCase();
		int count = 0;
		for (Toy toys : arrList) {
			if (toys.getName().toLowerCase().contains(input)) {
				found = true;
				secondList.add(toys);
				count++;
				printList(count, toys);

			}

		}

		if (found == false) {
			noToy("name");
			purchaseName();
		}
		int goBack = count + 1;
		goBack(goBack);
		if (found == true) {
			try {
				enterChoice();
				int userI = sc.nextInt();

				if (userI == goBack) {
					AppView.display();
				}
				for (Toy toys : arrList) {
					if (toys.equals((secondList.get(userI - 1)))) {
						if (toys.getCount() != 0) {
							toys.setCount(toys.getCount() - 1);
							purchaseC();
							saveFile();
						} else {
							noStock();
							AppView.display();
						}
					}

				}

			} catch (IndexOutOfBoundsException e) {
				outOfBounds();

				purchaseName();

			} catch (InputMismatchException e) {
				mismatch();
				sc.next();
				purchaseName();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				purchaseName();
			}
		}
	}
	
	/**
	 * Allows the user to purchase a toy by entering the serial number of the toy.
	 * If the toy is found, the user is prompted to choose which toy they want to purchase.
	 * Once a toy is chosen, the count of that toy is decremented and the file is saved.
	 * If the toy is not found, the user is prompted again to enter a valid serial number.
	 * @throws IndexOutOfBoundsException if the user enters an invalid index
	 * @throws InputMismatchException if the user enters an invalid input
	 * @throws Exception for any other type of exception
	 */
	public static void purchaseS_N() {
		boolean digits = true;
		ArrayList<Toy> secondList = new ArrayList<Toy>();
		Scanner sc = new Scanner(System.in);
		enter(" Serial Number ");
		String input = sc.nextLine();
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				digits = false;
			}
			if (digits == false) {
				S_N();
				purchaseS_N();
			}
			if (input.length() > 10) {
				morethan10();
				purchaseS_N();
			} else if (input.length() < 10) {
				lessthan10();
				purchaseS_N();
			}

		}
		int count = 0;
		boolean found = false;
		for (Toy toys : arrList) {

			if (toys.getS_N().contains(input)) {
				found = true;
				secondList.add(toys);
				count++;
				printList(count, toys);

			}

		}

		if (found == false) {
			noToy("S_N");
			purchaseS_N();
		}
		int goBack = count + 1;
		goBack(goBack);

		if (found == true) {

			try {
				enterChoice();
				int userI = sc.nextInt();

				if (userI == goBack) {
					AppView.display();
				}
				for (Toy toys : arrList) {
					if (toys.equals((secondList.get(userI - 1)))) {
						if (toys.getCount() != 0) {
							toys.setCount(toys.getCount() - 1);
							purchaseC();
							saveFile();
						} else {
							noStock();
							AppView.display();
						}
					}

				}

			} catch (IndexOutOfBoundsException e) {
				outOfBounds();

				purchaseS_N();

			} catch (InputMismatchException e) {
				mismatch();
				sc.next();
				purchaseS_N();
			}

		}
	}

	/**
	Allows user to select a toy type to purchase from the inventory.
	Retrieves all toys of the specified type from the ArrayList.
	Prompts user to select a toy from the list and decrements the count of that toy by 1 upon purchase.
	Saves updated inventory to file after purchase.
	@throws IndexOutOfBoundsException if user enters an invalid index for toy selection.
	@throws InputMismatchException if user enters input of the wrong type for toy selection.
	*/
	public static void purchaseType() {

		ArrayList<Toy> secondList = new ArrayList<Toy>();
		Scanner sc = new Scanner(System.in);
		enter("Type");
		String input = sc.nextLine();
		int count = 0;
		boolean found = false;
		if (input.equalsIgnoreCase("Figures")) {
			for (Toy toys : arrList) {
				if (toys instanceof Figures) {
					found = true;
					secondList.add(toys);
					count++;
					printList(count, toys);
				}
			}
			int goBack = count + 1;
			goBack(goBack);
			if (found == true) {
				try {
					enterChoice();
					int userI = sc.nextInt();

					if (userI == goBack) {
						purchaseType();
					}
					for (Toy toys : arrList) {
						if (toys.equals((secondList.get(userI - 1)))) {
							if (toys.getCount() != 0) {
								toys.setCount(toys.getCount() - 1);
								purchaseC();
								saveFile();
							} else {
								noStock();
								AppView.display();
							}
						}

					}

				} catch (IndexOutOfBoundsException e) {
					outOfBounds();

					purchaseType();

				} catch (InputMismatchException e) {
					mismatch();
					sc.next();
					purchaseType();
				}

			}
		} else if (input.equalsIgnoreCase("Animals")) {
			for (Toy toys : arrList) {
				if (toys instanceof Animals) {
					found = true;
					secondList.add(toys);
					count++;
					printList(count, toys);
				}
			}
			int goBack = count + 1;
			goBack(goBack);
			if (found == true) {
				try {
					enterChoice();
					int userI = sc.nextInt();

					if (userI == goBack) {
						AppView.display();
					}
					for (Toy toys : arrList) {
						if (toys.equals((secondList.get(userI - 1)))) {
							if (toys.getCount() != 0) {
								toys.setCount(toys.getCount() - 1);
								purchaseC();
								saveFile();
							} else {
								noStock();
								AppView.display();
							}
						}

					}

				} catch (IndexOutOfBoundsException e) {
					outOfBounds();

					purchaseType();

				} catch (InputMismatchException e) {
					mismatch();
					sc.next();
					purchaseType();
				}

			}
		} else if (input.equalsIgnoreCase("Puzzles")) {
			for (Toy toys : arrList) {
				if (toys instanceof Puzzles) {
					found = true;
					secondList.add(toys);
					count++;
					printList(count, toys);
				}
			}
			int goBack = count + 1;
			goBack(goBack);
			if (found == true) {
				try {
					enterChoice();
					int userI = sc.nextInt();

					if (userI == goBack) {
						AppView.display();
					}
					for (Toy toys : arrList) {
						if (toys.equals((secondList.get(userI - 1)))) {
							if (toys.getCount() != 0) {
								toys.setCount(toys.getCount() - 1);
								purchaseC();
								saveFile();
							} else {
								noStock();
								AppView.display();
							}
						}

					}

				} catch (IndexOutOfBoundsException e) {
					outOfBounds();

					purchaseType();

				} catch (InputMismatchException e) {
					mismatch();
					sc.next();
					purchaseType();
				}

			}
		} else if (input.equalsIgnoreCase("Board Games")) {
			for (Toy toys : arrList) {
				if (toys instanceof Board_Games) {
					found = true;
					secondList.add(toys);
					count++;
					printList(count, toys);
				}
			}
			int goBack = count + 1;
			goBack(goBack);
			if (found == true) {
				try {
					enterChoice();
					int userI = sc.nextInt();

					if (userI == goBack) {
						AppView.display();
					}
					for (Toy toys : arrList) {
						if (toys.equals((secondList.get(userI - 1)))) {
							if (toys.getCount() != 0) {
								toys.setCount(toys.getCount() - 1);
								purchaseC();
								saveFile();
							} else {
								noStock();
								AppView.display();
							}
						}

					}

				} catch (IndexOutOfBoundsException e) {
					outOfBounds();

					purchaseType();

				} catch (InputMismatchException e) {
					mismatch();
					sc.next();
					purchaseType();
				}

			}
		} else {
			noToy("Type");
			AppView.display();
		}

	}
	/**

	This method prompts the user to input a serial number and validates it by checking if it is a 10-digit number.
	If the input is invalid, the method recursively calls itself to prompt the user again.
	If the input is valid, it returns the input as a string.
	@return the validated serial number input as a string.
	*/
	public static String inputSN() {
		try {
			Scanner sc = new Scanner(System.in);
			AppMenu.enter("S_N");
			String input = sc.nextLine();

			boolean digits = true;
			for (int i = 0; i < input.length(); i++) {
				if (!Character.isDigit(input.charAt(i))) {
					digits = false;
				}
			}
			if (digits == false) {
				S_N();
				inputSN();
			}
			if (input.length() != 10) {
				sns();
				inputSN();
			} else {
				return input;
			}

//		for (Toy toys : arrList) {
//			if (toys.getS_N().contains(input)) {
//				found = true;
//
//			}

		} catch (InputMismatchException e) {
			mismatch();
			inputSN();
		}
		return null;

	}
	/**

	This method adds new Figures object to the arrList.
	@param SN the serial number of the figure
	@throws CustomExeptionClass when there is an issue with adding the figure
     **/
	public static void addFigures(String SN) {

		try {

			Object[] a = AppMenu.addFig();
			String input1 = (String) a[0];

			String input2 = (String) a[1];
			double price = (double) a[2];
			int stock = (int) a[3];
			int age = (int) a[4];
			String bb = (String) a[5];
			bb = bb.toUpperCase();
			if (bb.equalsIgnoreCase("a") || bb.equalsIgnoreCase("d") || bb.equalsIgnoreCase("h")) {
				arrList.add(new Figures(SN, input1, input2, price, stock, age, bb));
				saveFile();
			} else {
				wrongInput();
				addFigures(bb);
			}

		} catch (CustomExeptionClass e) {
			e.printStackTrace();
			e.getMessage();
			addFigures(SN);
		} catch (Exception e) {
			mismatch();
			addFigures(SN);
		}

	}
	/**

	This method adds new Puzzles object to the arrList.
	@param SN the serial number of the figure
	@throws CustomExeptionClass when there is an issue with adding the figure
     **/

	public static void addPuzzles(String SN) {

		try {

			Object[] a = AppMenu.addPuz();
			String input1 = (String) a[0];

			String input2 = (String) a[1];
			double price = (double) a[2];
			int stock = (int) a[3];
			int age = (int) a[4];
			String bb = (String) a[5];
			bb = bb.toUpperCase();
			if (bb.equalsIgnoreCase("m") || bb.equalsIgnoreCase("c") || bb.equalsIgnoreCase("l")
					|| bb.equalsIgnoreCase("t") || bb.equalsIgnoreCase("r")) {
				arrList.add(new Puzzles(SN, input1, input2, price, stock, age, bb));
				saveFile();
			} else {
				wrongInput();
				addPuzzles(bb);
			}

		} catch (CustomExeptionClass e) {
			e.printStackTrace();
			e.getMessage();
			addPuzzles(SN);
		} catch (Exception e) {
			mismatch();
			addPuzzles(SN);
		}

	}
	/**

	This method adds new Animals object to the arrList.
	@param SN the serial number of the figure
	@throws CustomExeptionClass when there is an issue with adding the figure
     **/
	public static void addAnimal(String SN) {

		try {

			Object[] a = AppMenu.addAnimals();
			String input1 = (String) a[0];

			String input2 = (String) a[1];

			double price = (double) a[2];

			int stock = (int) a[3];

			int age = (int) a[4];
			String material = (String) a[5];
			String bb = (String) a[6];
			bb = bb.toUpperCase();
			if (bb.equalsIgnoreCase("a") || bb.equalsIgnoreCase("d") || bb.equalsIgnoreCase("h")) {
				arrList.add(new Animals(SN, input1, input2, price, stock, age, material, bb));
				saveFile();
			} else {
				wrongInput();
				addAnimal(SN);
			}

		} catch (CustomExeptionClass e) {
			e.printStackTrace();
			e.getMessage();
			addAnimal(SN);
		} catch (Exception e) {
			mismatch();
			addAnimal(SN);
		}

	}
		
	/**

	This method adds new Boards object to the arrList.
	@param SN the serial number of the figure
	@throws CustomExeptionClass when there is an issue with adding the figure
     **/
	public static void addBoards(String SN) {

		try {

			Object[] a = AppMenu.addBoard();
			String input1 = (String) a[0];

			String input2 = (String) a[1];

			double price = (double) a[2];

			int stock = (int) a[3];

			int age = (int) a[4];
			int min = (int) a[5];
			int max = (int) a[6];

			String des = (String) a[7];

			arrList.add(new Board_Games(SN, input1, input2, price, stock, age, min, max, des));

			saveFile();
			AppView.display();

		} catch (CustomExeptionClass e1) {

			System.err.println("Error: " + e1.getMessage());
			addBoards(SN);
		} catch (Exception e) {
			mismatch();
			addBoards(SN);
		}

	}
	
	/**

	Allows the user to remove a toy from the inventory based on the toy's serial number.
	If the serial number entered by the user is not a 10-digit number or contains non-digit characters,
	the user is prompted to re-enter the serial number.
	If the serial number entered by the user is not found in the inventory, the user is notified and prompted to try again.
	If the serial number entered by the user is found, the user is prompted to confirm the deletion.
	If the user confirms the deletion, the toy is removed from the inventory and the updated inventory is displayed.
	If the user selects an invalid option, they are prompted to select again.
	*/
	public static void remove() {
		boolean digits = true;
		ArrayList<Toy> secondList = new ArrayList<Toy>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter S_N");
		String input = sc.nextLine();
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				digits = false;
			}
			if (digits == false) {
				S_N();
				remove();
			}
			if (input.length() > 10) {
				morethan10();
				remove();
			} else if (input.length() < 10) {
				lessthan10();
				remove();
			}

		}
		int count = 0;
		boolean found = false;
		for (Toy toys : arrList) {
			if (toys.getS_N().contains(input)) {
				found = true;
				secondList.add(toys);
				count++;
				printList(count, toys);

			}

		}

		if (found == false) {
			noToy("SN");
			remove();
		}
		int goBack = count + 1;

		if (found == true) {
			try {
				askDelete();
				String userI = sc.nextLine();

				if (userI.equalsIgnoreCase("n")) {
					remove();
				} else if (userI.equalsIgnoreCase("y")) {

					arrList.remove(secondList.get(0));
					saveFile();
					AppView.display();
				} else {
					selectDelete();
					remove();
				}
			} catch (IndexOutOfBoundsException e) {
				outOfBounds();

				remove();

			} catch (InputMismatchException e) {
				mismatch();
				sc.next();
				remove();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}