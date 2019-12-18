/**
 * CSS 143 Final Assignment: Grocery Manager
 * Instructor: Lesley Kalmin
 * This is an exception class made specifically for Grocery Manager
 *
 * @author Johnny Pham
 * @version 12/4/18
 */
public class GroceryException extends RuntimeException
{
   /** 
    * Default constructor
    */
   public GroceryException()
   {
      super("An error has occured.");
   }
   
   /**
    * Constructor takes in a custom error message
    */
   public GroceryException(String msg)
   {
      super(msg);
   }
}