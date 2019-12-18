/**
 * CSS 143 Final Assignment: Grocery Manager
 * Instructor: Lesley Kalmin
 *
 * @author Johnny Pham
 * @version 12/4/18
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Grocery Manager class: Pulls all the classes together with various methods
 */
public class GroceryManager 
{
   private ArrayList<GroceryItem> inventory = new ArrayList<>();
   private HashSet<String> reorderList = new HashSet<>();
   
   /**
    * Reads the given inventory file & stocks the inventory
    * Method was supplied by the instructor
    */
	public void readInventory() throws FileNotFoundException {
		Scanner input = null;
		try {
			input = new Scanner(new FileInputStream("groceryInventory.txt"));
			String qline = input.nextLine();
			String[] qparts = qline.split(" ");
			int nDairy = Integer.parseInt(qparts[0]);
			int nProduce = Integer.parseInt(qparts[1]);

			int i = 0;
			
			while (input.hasNext()) {
				String line = input.nextLine();
            // Line added
            String[] values = line.split(" ", 5);

				if (values[0].equals("Dairy")) {
					inventory.add(new Dairy(line));
            // Line changed (wouldn't read all Produce items before)
				} else if (values[0].equals("Produce")) { 
					inventory.add(new Produce(line));
				} else {
					inventory.add(new Meat(line));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			input.close();
		}
	}
   
   /**
    * Subtracts from the stock quantity as items are ordered
    * Adds out of stock items to the reorder list
    */
   public void processOrder(GroceryOrder<GroceryItem> order)
   {
      for (GroceryItem orderedItem : order)
      {
         String name = orderedItem.getName();
         int amountOrdered = orderedItem.getQuantity();
         // Error message if the item is not in the inventory
         if (orderedItem.compareTo(findItemByName(name)) != 0)
         {
            System.out.println(name + " is not stocked");
            // Keeps going if GroceryException is thrown in findItemByName method
            continue;
         }
         for (GroceryItem stockedItem : inventory)
         {
            if (name.equals(stockedItem.getName()))
            {
               int current = stockedItem.getQuantity();
               // Error message if out of stock for an item, but keeps going
               if (amountOrdered > current)
               {
                  System.out.println("Out of " + name);
               }
               int total = current - amountOrdered;
               if (total >= 0)
               {
                  stockedItem.setQuantity(total);
               }
               else
               {
                  // Make sure stock isn't negative
                  stockedItem.setQuantity(0);
                  reorderList.add(name);
               }
            }
         }
      }
   }
   
   /**
    * Obtains the target item if found
    */
   public GroceryItem findItemByName(String name)
   {
      for (GroceryItem gi : inventory)
      {
         if (gi.getName().equals(name))
         {
            return gi;
         }
      }
      throw new GroceryException(name + " not found!");
   }
   
   /**
    * Organizes the inventory list by name, using selection sort
    */
   public void sortByName()
   {
      for (int i = 0; i < inventory.size() - 1; i++)
      {
         int min = i;
         for (int j = i + 1; j < inventory.size(); j++)
         {
            if (inventory.get(j).getName().compareTo(inventory.get(min).getName()) < 0)
            {
               min = j;
            }
         }
         // Swap items
         GroceryItem temp = inventory.get(min);
         inventory.set(min, inventory.get(i));
         inventory.set(i, temp);
      }
   }
   
   /**
    * Organizes the inventory list by price, using bubble sort
    */
   public void sortByPrice()
   {
      boolean stillSwapping = true;
      int count = 1;
      // Notices if it doesn't need to continue swapping
      while (stillSwapping)
      {
         stillSwapping = false;
         for (int i = 0; i < inventory.size() - 1; i++)
         {
            if (inventory.get(i).getPrice() > inventory.get(i + 1).getPrice())
            {
               // Swap items
               GroceryItem temp = inventory.get(i);
               inventory.set(i, inventory.get(i + 1));
               inventory.set(i + 1, temp);
               stillSwapping = true;
            }
         }
         count++;
      }
   }
   
   /**
    * Lists the inventory with all the item class specific data
    */
   public void displayInventory()
   {
      for (GroceryItem gi : inventory)
      {
         System.out.println(gi.toString());
      }
   }
   
   /**
    * Obtains the list of items that need to be reordered
    */
   public HashSet<String> getReorderList()
   {
      return reorderList;
   }
}