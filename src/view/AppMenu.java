package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.ExceptionClass;
import model.Toy;

public class AppMenu {
	
	public static void main(String[] args) {
		
		AppMenu.mainMenu();
	}
	
	 public static int mainMenu() {
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
	    }
	 
	 
	 
	 public static int searchAndPurchase() {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Find Toys With:/n");
		 System.out.println("(1) Serial Number(SN)");
	     System.out.println("(2) Toy Name");
	     System.out.println("(3) Type");
	     System.out.println("(4) Back to Main Menu\n");
	     System.out.print("Enter Option: ");
	     int option = sc.nextInt();
	     return option; 
	 }
	 
	 public static void enter(String x) {
         System.out.println("Enter Option: " +x);
     }
     public static void printList(int count, Toy toys) {
         System.out.println("\t" +count+ " " +toys);
     }
     public static void doesntExist(String x) {
         System.out.println("A Toy With That" +x+ " Does Not Exist! Try again.");
     }
     public static void goBack(int goBack) {
         System.out.println("\t " + (goBack) + "Return to Main Menu.");
     }
     
     public static void itemPurchased() {
         System.out.println("The Transaction Successfully Terminated!");
     }
     public static void noStock() {
         System.out.println("This toy is out of stock, Sorry!");
     }
     public static void mismatch() {
         System.out.println("Invalid Input, Returning to Menu.");
     }
     public static void sinLength() {
         System.out.println("The Serial Number's length MUST be 10 digits! Try again.");
     }
     public static void sinFormat() {
         System.out.println("The Serial Number should only contain digits! Try again.");
     }
     public static void doesExist(String x) {
    	 System.out.println("A Toy With This" +x+ "Already Exists! Try Again.");
     }
	 
     
     public static int searchResults(int count, Toy toys) {
    	 Scanner sc = new Scanner(System.in);
    	 System.out.println("Here are the search results:/n");
         System.out.println("\t" +count+ " " +toys);
         System.out.println("\t" +count+ " " + "Back To Search Menu/n");
         System.out.print("Enter option number to purchase: ");
    	 int option = sc.nextInt();
    	 return option;
    	 
     }
     
     public static String removeToy(Toy toys) {
    	 Scanner sc = new Scanner(System.in);
    	 System.out.println("This Item Found:");
    	 System.out.println("\t" +toys +"/n");
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

     
     
     public static Object [] addFig() throws ExceptionClass{
         try {
         Scanner sc = new Scanner(System.in);
         Scanner sc1 = new Scanner(System.in);
         System.out.println("Enter Serial Number: ");
         String sin = sc.nextLine();
         System.out.println("Enter Toy Name: ");
         String input1 = sc.nextLine();
         System.out.println("Enter Toy Brand: ");
         String input2 = sc.nextLine();
         System.out.println("Enter Toy Price: ");
         Double d = sc.nextDouble();
         System.out.println("Enter Available Count: ");
         int stock = sc.nextInt();
         System.out.println("Enter Appropriate Age: ");
         int age = sc.nextInt();
         
         if (stock < 0 ) {
             throw new ExceptionClass("The stock cannot be negative, try again!");
         }
         if ( age < 0) {
             throw new ExceptionClass("The appropriate age cannot be negative, try again!");
         }
         if ( d < 0) {
             throw new ExceptionClass("The price cannot be negative, try again!");
         }
         if (sin.charAt(0) != 0 || sin.charAt(0) != 1) {
        	 throw new ExceptionClass("The first digit of a figures serial number must be 0 or 1, try again!");
         }

         System.out.println("Classify your figure: either Action(A), Doll(D), or Historic(H):");
         String bb = sc1.nextLine().toUpperCase();

         Object [] fig = {sin, input1, input2, d, stock, age, bb};
         return fig;
  
         } catch (InputMismatchException e) {
             mismatch();
             addFig();
         }

         return null;

     }
     
     
     public static Object [] addAnimal() throws ExceptionClass{
         try {
         Scanner sc = new Scanner(System.in);
         Scanner sc1 = new Scanner(System.in);
         System.out.println("Enter Serial Number: ");
         String sin = sc.nextLine();
         System.out.println("Enter Toy Name: ");
         String input1 = sc.nextLine();
         System.out.println("Enter Toy Brand: ");
         String input2 = sc.nextLine();
         System.out.println("Enter Toy Price: ");
         Double d = sc.nextDouble();
         System.out.println("Enter Available Count: ");
         int stock = sc.nextInt();
         System.out.println("Enter Appropriate Age: ");
         int age = sc.nextInt();
         System.out.println("Enter Material: ");
         String material = sc.nextLine();
         
         if (stock < 0 ) {
             throw new ExceptionClass("The stock cannot be negative, try again!");
         }
         if ( age < 0) {
             throw new ExceptionClass("The appropriate age cannot be negative, try again!");
         }
         if ( d < 0) {
             throw new ExceptionClass("The price cannot be negative, try again!");
         }
         if (sin.charAt(0) != 2 || sin.charAt(0) != 3) {
        	 throw new ExceptionClass("The first digit of a animals serial number must be 2 or 3, try again!");
         }

         System.out.println("Enter size: either Small(S), Medium(M), or Large(L): ");
         String bb = sc1.nextLine().toUpperCase();

         Object [] animal = {sin, input1, input2, d, stock, age, material, bb};
         return animal;
  
         } catch (InputMismatchException e) {
             mismatch();
             addAnimal();
         }

         return null;

     }
     
     
     public static Object [] addPuzzle() throws ExceptionClass{
         try {
         Scanner sc = new Scanner(System.in);
         Scanner sc1 = new Scanner(System.in);
         System.out.println("Enter Serial Number:");
         String sin = sc.nextLine();
         System.out.println("Enter Toy Name: ");
         String input1 = sc.nextLine();
         System.out.println("Enter Toy Brand: ");
         String input2 = sc.nextLine();
         System.out.println("Enter Toy Price: ");
         Double d = sc.nextDouble();
         System.out.println("Enter Available Count: ");
         int stock = sc.nextInt();
         System.out.println("Enter Appropriate Age: ");
         int age = sc.nextInt();
         
         if (stock < 0 ) {
             throw new ExceptionClass("The stock cannot be negative, try again!");
         }
         if ( age < 0) {
             throw new ExceptionClass("The appropriate age cannot be negative, try again!");
         }
         if ( d < 0) {
             throw new ExceptionClass("The price cannot be negative, try again!");
         }
         if (sin.charAt(0) != 4 || sin.charAt(0) != 5 || sin.charAt(0) != 6) {
        	 throw new ExceptionClass("The first digit of a puzzles serial number must be 4, 5, or 6, try again!");
         }

         System.out.println("Enter puzzle-type: either Mechanical(M), Cryptic(C), Logic(L), Trivia(T), or Riddle(R): ");
         String bb = sc1.nextLine().toUpperCase();

         Object [] animal = {sin, input1, input2, d, stock, age, bb};
         return animal;
  
         } catch (InputMismatchException e) {
             mismatch();
             addPuzzle();
         }

         return null;

     }
     
     
     
     public static void toyAdded() {
    	 System.out.println("New Toy Added!");
     }
     public static void pressEnter() {
    	 System.out.println("Press Enter to Continue...");
     }
 
     public static Object [] addBoardGame() throws ExceptionClass{
         try {
         Scanner sc = new Scanner(System.in);
         Scanner sc1 = new Scanner(System.in);
         System.out.println("Enter Serial Number: ");
         String sin = sc.nextLine();
         System.out.println("Enter Toy Name: ");
         String input1 = sc.nextLine();
         System.out.println("Enter Toy Brand: ");
         String input2 = sc.nextLine();
         System.out.println("Enter Toy Price: ");
         Double d = sc.nextDouble();
         System.out.println("Enter Available Count: ");
         int stock = sc.nextInt();
         System.out.println("Enter Appropriate Age: ");
         int age = sc.nextInt();
         System.out.println("Enter Minimum Number of Players: ");
         int min = sc.nextInt();
         System.out.println("Enter Maximum Number of Players: ");
         int max = sc.nextInt();
         System.out.println("Enter Designer Names(Use ',' to seperate multiple names): ");
         String names = sc.nextLine();
         
         
         if (stock < 0 ) {
             throw new ExceptionClass("The stock cannot be negative! Try again.");
         }
         if ( age < 0) {
             throw new ExceptionClass("The appropriate age cannot be negative! Try again.");
         }
         if ( d < 0) {
             throw new ExceptionClass("The price cannot be negative! Try again.");
         }
         if (sin.charAt(0) != 7 || sin.charAt(0) != 8 || sin.charAt(0) != 9) {
        	 throw new ExceptionClass("The first digit of a board games serial number must be 7, 8, or 9! Try again.");
         }
         if (min < 1) {
        	 throw new ExceptionClass("The minimum amount of players must be 1 or more! Try again.");
         }
         if (max < min) {
        	 throw new ExceptionClass("The maximum amount of players must be greater than the minimum amount of players! Try again.");
         }


         Object [] boardgame = {sin, input1, input2, d, stock, age, min, max, names};
         return boardgame;
  
         } catch (InputMismatchException e) {
             mismatch();
             addBoardGame();
         }

         return null;

     }
     
     public static void dataSaved() {
    	 System.out.println("Saving Data Into Database.../n");
    	 System.out.println("*********** THANKS FOR VISITING US! ***********");	
     }
     
	
	
}
