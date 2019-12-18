/**
 * CSS 143 Final Assignment: Grocery Manager
 * Instructor: Lesley Kalmin
 * This subclass inherits from GroceryItem, specific to Meat products 
 *
 * @author Johnny Pham
 * @version 12/4/18
 */
public class Meat extends GroceryItem
{
   private boolean isGround;
   
   /**
    * Constructor takes in the item name, amount of stock, pricing, & the
    * grounded/not grounded label
    *
    * @param String, int, double, boolean
    */
   public Meat(String name, int quantity, double price, boolean isGround)
   {
      super(name, quantity, price);
      this.isGround = isGround;
   }
   
   /** 
    * Constructor takes in the item name & the amount of stock, but doesn't
    * have a price or grounded label
    *
    * @param String, int
    */
   public Meat(String name, int quantity)
   {
      super(name, quantity, 0.0);
   }
   
   /**
    * Constructor takes in an input line, then parses & sets the data
    *
    * @param String
    */
   public Meat(String inputLine)
   {
      String[] values = inputLine.split(" ", 5);
      if (values[0].equals("Meat"))
      {
      setName(values[1]);
      setQuantity(Integer.parseInt(values[2]));
      setPrice(Double.parseDouble(values[3]));
      isGround = Boolean.parseBoolean(values[4]);
      }
   }
   
   /**
    * Changes the grounded label of the item
    *
    * @param boolean
    */
   public void setIsGround(boolean ground)
   {
      isGround = ground;
   }
   
   /**
    * Obtains the grounded/not grounded label of the item
    *
    * @return boolean
    */
   public boolean getIsGround()
   {
      return isGround;
   }
   
   @Override
   public String toString()
   {
      return super.toString() + " Ground: " + isGround;
   }
}