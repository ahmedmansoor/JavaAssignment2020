package Store;

public class Item {
    //variables
    String name;
    double price;

    //default constructor
    public Item()
    {

    }
    //primeterised constructor
    public Item (String itemName, double itemPrice)
    {
        this.name = itemName;
        this.price = itemPrice;
    }

}