/**
 * CSS 143 Final Assignment: Grocery Manager
 * Instructor: Lesley Kalmin
 * This subclass inherits from GroceryItem, specific to Produce products 
 *
 * @author Johnny Pham
 * @version 12/4/18
 */
public class Produce extends GroceryItem
{
   private boolean isOrganic;
   
   /**
    * Constructor takes in the item name, amount of stock, pricing, & the
    * organic/non-organic label
    *
    * @param String, int, double, boolean
    */
   public Produce(String name, int quantity, double price, boolean isOrganic)
   {
      super(name, quantity, price);
      this.isOrganic = isOrganic;
   }
   
   /**
    * Constructor takes in the item name & the amount of stock, but doesn't
    * have a price or organic label
    *
    * @param String, int
    */
   public Produce(String name, int quantity)
   {
      super(name, quantity, 0.0);
      isOrganic = false;
   }
   
   /** 
    * Constructor takes in an input line, then parses & sets the data
    *
    * @param String
    */
   public Produce(String inputLine)
   {
      String[] values = inputLine.split(" ", 5);
      setName(values[1]);
      setQuantity(Integer.parseInt(values[2]));
      setPrice(Double.parseDouble(values[3]));
      isOrganic = Boolean.parseBoolean(values[4]);
   }
   
   /** 
    * Changes the organic label of the item
    *
    * @param boolean
    */
   public void setIsOrganic(boolean organic)
   {
      isOrganic = organic;
   }
   
   /**
    * Obtains the organic/non-organic label of the item
    *
    * @return boolean
    */
   public boolean getIsOrganic()
   {
      return isOrganic;
   }
   
   @Override
   public String toString()
   {
      return super.toString() + " Organic: " + isOrganic;
   }
}