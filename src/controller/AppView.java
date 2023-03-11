package controller;

import java.util.InputMismatchException;
/**
	The AppView class provides methods to display and manage the application menu
	and interact with the user inputs.
	Extends the AppMenu class to access the menu options.
 */
import java.util.Scanner;

import model.CustomExeptionClass;
import view.AppMenu;

public class AppView extends AppMenu {

	public static void display() {
		new AppManager();
		int choice = mainMenu();

		if (choice == 1) {
			int choice2 = searchAndPurchase();
			if (choice2 == 1) {
				AppManager.purchaseS_N();
			} else if (choice2 == 2) {
				AppManager.purchaseName();
			} else if (choice2 == 3) {
				AppManager.purchaseType();
			} else if (choice2 == 4) {
				display();
			} else {
				outOfBounds();
				display();
			}
		}
		if (choice == 2) {

			String input = AppManager.inputSN();

			if (input.charAt(0) == '0' || input.charAt(0) == '1') {
				AppManager.addFigures(input);

			} else if (input.charAt(0) == '2' || input.charAt(0) == '3') {
				AppManager.addAnimal(input);

			} else if (input.charAt(0) == '4' || input.charAt(0) == '5' || input.charAt(0) == '6') {
				AppManager.addPuzzles(input);

			} else if (input.charAt(0) == '7' || input.charAt(0) == '8' || input.charAt(0) == '9') {
				AppManager.addBoards(input);

			}

		} else if (choice == 3) {
			AppManager.remove();
		} else if (choice == 4) {
			System.exit(0);
		} else {
			outOfBounds();
			display();
		}
	}
}
