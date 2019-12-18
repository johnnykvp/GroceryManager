/**
 * CSS 143 Final Assignment: Grocery Manager
 * Instructor: Lesley Kalmin
 * This class sets up the stock & price of GroceryItems
 *
 * @author Johnny Pham
 * @version 12/4/18
 */
public abstract class GroceryItem implements Comparable
{
   private String name;
   private int quantity;
   private double price;
   
   /**
    * Constructor takes in the item name, amount of stock, & the pricing
    *
    * @param String, int, double
    */
   public GroceryItem(String name, int quantity, double price)
   {
      this.name = name;
      this.quantity = quantity;
      this.price = price;
   }
   
   /**
    * Default constructor
    */
   public GroceryItem()
   {
      name = "unknown item";
      quantity = 0;
      price = 0.0;
   }
   
   /**
    * Changes the name of the item
    *
    * @param String
    */
   public void setName(String name)
   {
      this.name = name;
   }
   
   /**
    * Obtains the name of the item
    *
    * @return String
    */
   public String getName()
   {
      return name;
   }
   
   /**
    * Changes the price of the item
    *
    * @param double
    */
   public void setPrice(double price)
   {
      this.price = price;
   }
   
   /**
    * Obtains the price of the item
    *
    * @return double
    */
   public double getPrice()
   {
      return price;
   }
   
   /**
    * Changes the stock quantity of the item
    *
    * @param int
    */
   public void setQuantity(int n)
   {
      quantity = n;
   }
   
   /**
    * Obtains the stock quantity of the item
    *
    * @return int
    */
   public int getQuantity()
   {
      return quantity;
   }
   
   @Override
   public String toString()
   {
      // Solution to line up the info by columns
      String nameIndent = "                       ";
      String outputName = "Name: " + name;
      // Throw error if the name is too long (String-wise for lining up)
      if (nameIndent.length() - outputName.length() < 0)
      {
         throw new GroceryException("Item name is too long!");
      }
      outputName += nameIndent.substring(0, nameIndent.length() - outputName.length());
      
      String quantityIndent = "               ";
      String outputQuantity = "Quantity: " + quantity;
      // Throw error if the quantity is too large (String-wise for lining up)
      if (quantityIndent.length() - outputQuantity.length() < 0)
      {
         throw new GroceryException("Cannot stock this many items!");
      }
      outputQuantity += quantityIndent.substring(0, quantityIndent.length() - outputQuantity.length());
      
      String priceIndent = "               ";
      String outputPrice = "Price: " + price;
      if (priceIndent.length() - outputPrice.length() < 0)
      // Throw error if the price is too much (String-wise for lining up)
      {
         throw new GroceryException("Price is too high to put for sale!");
      }
      outputPrice += priceIndent.substring(0, priceIndent.length() - outputPrice.length());
      
      return outputName + outputQuantity + outputPrice;
   }
   
   @Override
   public int compareTo(Object o)
   {
      // Uses the item names as the criterion
      // Uses String's compareTo (alphabetical)
      if (name.compareTo( ((GroceryItem) o).getName() ) > 0)
      {
         return 1;
      }
      if (name.compareTo( ((GroceryItem) o).getName() ) < 0)
      {
         return -1;
      }
      return 0;
   }
}