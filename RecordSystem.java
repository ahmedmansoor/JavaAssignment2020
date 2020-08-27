package Store;
import java.util.Scanner;
import java.util.ArrayList;

public class RecordSystem {
   
    static Scanner input = new Scanner(System.in);
    static ArrayList<Item> itemList = new ArrayList<>();
    static ArrayList<Item> billsList = new ArrayList<>();

    public static void main(String[] args) {
        
        menu();

    }

    public static void menu() {
        
        //menu
        System.out.println("---------------------------------------------------");
        System.out.println("\t\t---- OPTIONS ----");
        System.out.println("\t\t1 - ADD NEW ITEMS");
        System.out.println("\t\t2 - REMOVE ITEMS");
        System.out.println("\t\t3 - DISPLAY ALL ITEMS AVAILABLE");
        System.out.println("\t\t4 - SEARCH FOR AVAILABLE ITEMS");
        System.out.println("\t\t5 - RECORD A SALE");
        System.out.println("\t\t6 - GENERATE SALES REPORT");
        System.out.println("---------------------------------------------------");
        System.out.println("Choose an Option (1-6): ");
    
        int options = input.nextInt();
        System.out.println("---------------------------------------------------");


        switch(options)
        {
            case 1:
            {   
                addItems();

                menu();
                break;
            }
            case 2:
            {
                removeItems();

                menu();
                break;

            }
            case 3:
            {
                showAllItems();

                menu();
                break;

            }
            case 4:
            {
                searchItems();

                menu();
                break;

            }
            case 5:
            {
                saleOfItems();

                menu();
                break;

            }
            case 6:
            {
                salesReport();

                menu();
                break;

            }
        }        
    }

    public static void addItems() {
        // variable declaration
        String itemName;
        double itemPrice;

        // collect value of variable
        System.out.println("\t\t ADD ITEMS");
        System.out.println("Enter item name: ");
        itemName = input.next();
        System.out.println("Enter item price: ");
        itemPrice = input.nextDouble();
        System.out.println("\t\t[ITEM ADDED]");

        // values are passed 
        Item item = new Item(itemName, itemPrice);
        itemList.add(item);
    }

    public static void removeItems() {
        // variable declaration
        String itemRemove;
        
        // collect value of variable using Scanner class
        System.out.println("\t\t REMOVE ITEMS");
        System.out.println("Enter item name: ");
        itemRemove = input.next();
 
        // remove item if it matches any object' name in the ArrayList
        for (int i=0; i<itemList.size();i++) {
            if (itemList.get(i).name.contains(itemRemove)) {
                itemList.remove(i);
                System.out.println("\t\t[ITEM REMOVED]");
            }
        }
    }    
    
    public static void showAllItems() {

        System.out.println("\t\tITEMS AVAILABLE");

        // prints the list of objects name and price
        billFormat();
        for (int i=0; i<itemList.size(); i++) {
            System.out.println("\t\t"+itemList.get(i).name+"\t"+itemList.get(i).price);

        }
    }

    public static void searchItems() {
        // variable declaration
        String itemSearch;
        
        // collect value of variable using Scanner class
        System.out.println("\t\tSEARCH ITEMS");
        System.out.println("Enter item name: ");
        itemSearch = input.next();

        //search for an item
        for (int i=0; i<itemList.size();i++) {
            if (itemList.get(i).name.equalsIgnoreCase(itemSearch)) {
                
                System.out.println("\t\t[ITEM FOUND]");
            }
        }
    }

    public static void saleOfItems() {
        // variable declaration
        String itemSold;
        String saleName;
        double saleAmount = 0.00;
        int qty;
        
        // collect value of variable using Scanner class
        System.out.println("\t\tENTER SALES DETAILS");
        System.out.println("Name of item sold: ");
        itemSold = input.next();
        
        // searching whether the item is in list
        for (int i=0; i<itemList.size(); i++) {
            if (itemList.get(i).name.equalsIgnoreCase(itemSold)) {
                billFormat();
                System.out.println("\t\t"+itemList.get(i).name+"\t\t"+itemList.get(i).price);
                System.out.println("Enter qty: ");
                qty = input.nextInt();
                System.out.println("\t\t  [SALES RECORDED]");

                // passing names and price from the object in listOfItems
                // price is mutlipied with qty before passing, to calculate the amount
                saleName = itemList.get(i).name;
                saleAmount = (itemList.get(i).price *qty);

                // creating new object named SalesItem
                // these are added to the ArrayList billsList
                Item SalesItem = new Item(saleName, saleAmount);
                billsList.add(SalesItem);
            }
        }
    }

    public static void salesReport() {
        // variable declaration
        double total = 0.00;

        System.out.println("\t\t  Sales Report");
        billFormat();
        
        // prints the list of objects name and price
        // calculates the total
        for (int i=0;i<billsList.size();i++) {
            System.out.println("\t\t"+billsList.get(i).name+"\t"+billsList.get(i).price);
            total = total + billsList.get(i).price;
        }
        // show the total
        System.out.println("---------------------------------------------------");
        System.out.println("Total(MVR): \t\t"+total);
    }

    public static void billFormat() {
        System.out.println("\t\tITEM \tAMOUNT(MVR)");
    }
}