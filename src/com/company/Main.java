package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] mySupplyArray = {
                "Vanilla Ice Cream", "Chocolate Ice Cream", "Peanuts", "Chocolate syrup",
                "Carmel syrup", "Whipped Cream", "Cherries"
        };   //declare and allocate memory for array size

        int[] myInventoryArray = {4, 3, 2, 5, 6, 10, 7};  //declare and allocate memory for array size

        String strSearch = null;  //declare string variable for searching
        int option = 0;  //declare and initialize user selection option variable
        int adj = 0; //declare and initialize variable for adjusting
        int old = 0; //declare and initialize variable to hold previous inventory

        Scanner scanner = new Scanner(System.in);  //create scanner to read user input

        do {  //keep reiterating until user selects exit
            //Display menu options
            System.out.println("1. Search Inventory");
            System.out.println("2. Adjust Inventory");
            System.out.println("3. Display all Inventory");
            System.out.println("4. Exit");

            option = scanner.nextInt();  //get number as an Int of user selection

            switch (option) {
                case 1:
                    scanner.nextLine();  // Consume newline left-over
                    System.out.println("Enter item to search for: ");
                    strSearch = scanner.nextLine();   //get user input of String to search for

                    SearchInventory(myInventoryArray, mySupplyArray, strSearch);  //Call method to search inventory
                    break;

                case 2:
                    scanner.nextLine();  // Consume newline left-over
                    //Display inventory options
                    for (int i = 0; i < mySupplyArray.length; i++) {
                        System.out.println((i + 1) + ". " + mySupplyArray[i] + " = " + myInventoryArray[i]);
                    }
                    System.out.println("Enter item number to adjust inventory for: ");
                    option = scanner.nextInt();  //get number as an Int of user selection

                    System.out.println("Enter amount to adjust inventory by: ");
                    adj = scanner.nextInt(); //get number as an Int to add to inventory

                    old = myInventoryArray[option - 1];  //store original inventory for reference laater
                    myInventoryArray[option - 1] += adj;  //add adjustment to inventory

                    if (myInventoryArray[option - 1] > -1) {   //validate inventory is not < 0
                        System.out.print(mySupplyArray[option - 1] + " with " + old + " units, ");
                        System.out.println("adjusted by " + adj + " units = " + myInventoryArray[option - 1] + " units total inventory.\n");
                    } else {
                        myInventoryArray[option - 1] = 0;
                        System.out.println("Inventory cannot be less than 0. " + mySupplyArray[option - 1] + " adjusted to total inventory = 0.\n");
                    }
                    break;
                case 3:
                    DisplayInventory(mySupplyArray, myInventoryArray);  //call method to display inventory
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid selection, please try again");
                    System.exit(0);
            }
        } while (option != 4) ;
    }
    //Method to display inventory
    public static void DisplayInventory(String[] mySupplyArray, int[] myInventoryArray) {
        for (int i = 0; i < mySupplyArray.length; i++) {
            System.out.println(mySupplyArray[i] + " = " + myInventoryArray[i]);
        }
        System.out.println("\n");
    }

    //Method to search inventory and display units available
    public static void SearchInventory(int[] myInventoryArray, String[] mySupplyArray, String strSearch) {
        for (int i = 0; i < mySupplyArray.length; i++) {
            if (mySupplyArray[i].equals(strSearch)) {
                System.out.println(mySupplyArray[i] + " = " + myInventoryArray[i]+"\n");
                break;
            }
        }
    }

}
