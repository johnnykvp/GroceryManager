/**
 * CSS 143 Final Assignment: Grocery Manager
 * Instructor: Lesley Kalmin
 * This subclass inherits from GroceryItem, specific to Dairy products 
 *
 * @author Johnny Pham
 * @version 12/4/18
 */
public class Dairy extends GroceryItem
{
   private int refridgerationTemp;
   
   /**
    * Constructor takes in the item name, amount of stock, pricing, & the
    * preferred refridgeration temperature
    *
    * @param String, int, double, int
    */
   public Dairy(String name, int quantity, double price, int refrigerationTemp)
   {
      super(name, quantity, price);
      this.refridgerationTemp = refridgerationTemp;
   }
   
   /**
    * Constructor takes in the item name, & the amount of stock, but doesn't
    * have a price or a preferred refridgeration temperature.
    *
    * @param String, int
    */
   public Dairy(String name, int quantity)
   {
      super(name, quantity, 0.0);
      refridgerationTemp = 0;
   }
   
   /**
    * Constructor takes in an input line, then parses & sets the data
    *
    * @param String
    */
   public Dairy(String inputLine)
   {
      String[] values = inputLine.split(" ", 5);
      setName(values[1]);
      setQuantity(Integer.parseInt(values[2]));
      setPrice(Double.parseDouble(values[3]));
      refridgerationTemp = Integer.parseInt(values[4]);
   }
   
   /**
    * Changes the preferred refridgeration temperature of the item
    *
    * @param int
    */
   public void setRefrigerationTemperature(int temp)
   {
      refridgerationTemp = temp;
   }
   
   /**
    * Obtains the preferred refridgeration temperature of the item
    *
    * @return int
    */
   public int getRefridgerationTemperature()
   {
      return refridgerationTemp;
   }
   
   @Override
   public String toString()
   {
      return super.toString() + " Temperature " + refridgerationTemp;
   }
}