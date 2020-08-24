package Store;
import java.util.Scanner;
import java.util.ArrayList;

public class ShoppingCart {
   
    static Scanner input = new Scanner(System.in);
    static ArrayList<Item> itemList = new ArrayList<>();
    static ArrayList<Item> billsList = new ArrayList<>();

    public static void main(String[] args) {
        
        menu();

    }

    public static void menu() {
        
        System.out.println("---------------------------------------------------");
        System.out.println("\t\t---- OPTIONS ----");
        System.out.println("\t\t1 - ADD NEW ITEMS");
        System.out.println("\t\t2 - REMOVE ITEMS");
        System.out.println("\t\t3 - DISPLAY ALL ITEMS AVAILABLE");
        System.out.println("\t\t4 - SEARCH FOR AVAILABLE ITEMS");
        System.out.println("\t\t5 - RECORD A SALE");
        System.out.println("\t\t6 - GENERATE SALES REPORT");
        System.out.println("---------------------------------------------------");
        System.out.println("Choose an Option (1-5): ");
    
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
        String itemName;
        double itemPrice;

        System.out.println("\t\t ADD ITEMS");
        System.out.println("Enter item name: ");
        itemName = input.next();
        System.out.println("Enter item price: ");
        itemPrice = input.nextDouble();
        System.out.println("\t[ITEM ADDED]");

        Item item = new Item(itemName, itemPrice);
        itemList.add(item);
    }

    public static void removeItems() {
        String itemRemove;
        
        System.out.println("\t\t REMOVE ITEMS");
        System.out.println("Enter item name: ");
        itemRemove = input.next();

        for (int i=0; i<itemList.size();i++) {
            if (itemList.get(i).name.contains(itemRemove)) {
                itemList.remove(i);
                System.out.println("\t\t[ITEM REMOVED]");
            }
        }
    }

    public static void showAllItems() {

        System.out.println("\t\tITEMS AVAILABLE");
        billFormat();
        for (int i=0; i<itemList.size(); i++) {
            // System.out.println("Name: "+itemList.get(i).name);
            // System.out.println("Price: "+itemList.get(i).price);
            System.out.println(itemList.get(i).name+"\t"+itemList.get(i).price);

        }
    }

    public static void searchItems() {
        String itemSearch;
        
        System.out.println("\t\tSEARCH ITEMS");
        System.out.println("Enter item name: ");
        itemSearch = input.next();

        for (int i=0; i<itemList.size();i++) {
            if (itemList.get(i).name.equalsIgnoreCase(itemSearch)) {
                
                System.out.println("\t\t[ITEM FOUND]");
            }
        }
    }

    public static void saleOfItems() {
        String itemSold;
        String saleName;
        double saleAmount = 0.00;
        int qty;
        
        System.out.println("\t\tENTER SALES DETAILS");
        System.out.println("Name of item sold: ");
        itemSold = input.next();
        
        for (int i=0; i<itemList.size(); i++) {
            if (itemList.get(i).name.equalsIgnoreCase(itemSold)) {
                // System.out.println("\tITEM: "+itemList.get(i).name);
                // System.out.println("\tMVR: "+itemList.get(i).price);
                billFormat();
                System.out.println("\t"+itemList.get(i).name+"\t"+itemList.get(i).price);
                System.out.println("Enter qty: ");
                qty = input.nextInt();
                System.out.println("\t[SALES RECORDED]");


                saleName = itemList.get(i).name;
                saleAmount = (itemList.get(i).price *qty);

                Item SalesItem = new Item(saleName, saleAmount);
                billsList.add(SalesItem);
            }
        }
    }

    public static void salesReport() {
        double total = 0.00;

        System.out.println("\t\tSales Report");
        
        for (int i=0;i<billsList.size();i++) {
            // System.out.println("Name: \t"+billsList.get(i).name);
            // System.out.println("Price: \t"+billsList.get(i).price);
            billFormat();
            System.out.println(billsList.get(i).name+"\t"+billsList.get(i).price);
            total = total + billsList.get(i).price;
        }
        System.out.println("---------------------------------------------------");
        System.out.println("Total(MVR): \t"+total);
    }

    public static void billFormat() {
        System.out.println("ITEM \tMVR");
    }
}