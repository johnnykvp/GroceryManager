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
import java.util.Scanner;

/**
 * Driver for Grocery Manager: Read files, process orders, sort and print results
 */
public class Driver {
	static ArrayList<GroceryOrder<GroceryItem>> orders = new ArrayList<>();

	public static void main(String[] args) {
		GroceryManager manager = new GroceryManager();
		
		// stock store
		try {
			manager.readInventory();
			readOrders();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("******** Initial Inventory ********");
		manager.displayInventory();

		// purchase items
		System.out.println("******** Processing Orders ********");
		for (GroceryOrder<GroceryItem> order: orders)
			manager.processOrder(order);
		manager.displayInventory();

		// sort inventory
		manager.sortByName();
		System.out.println("******** Sort by Name ********");
		manager.displayInventory();

		manager.sortByPrice();
		System.out.println("******** Sort by Price ********");
		manager.displayInventory();
		
      // items to reorder
		System.out.println("********  Reorder List ********");
		System.out.println(manager.getReorderList());
      
      // find item
      System.out.println("********  Finding item ********");
      System.out.println(manager.findItemByName("blueberries"));
	}

   /**
    * Reads the given order file
    * Method was supplied by the instructor
    */
	public static void readOrders() {
		Scanner input = null;
		String line;
		String[] parts;
		try {
			input = new Scanner(new FileInputStream("groceryOrders.txt"));

			while (input.hasNext()) {
				GroceryOrder<GroceryItem> list = new GroceryOrder<>();
				input.nextLine();//ORDER
				line = input.nextLine();
				parts = line.split(" ");
				list.add(new Dairy(parts[1], Integer.parseInt(parts[2])));
				line = input.nextLine();
				parts = line.split(" ");
				list.add(new Produce(parts[1], Integer.parseInt(parts[2])));
				line = input.nextLine();
				parts = line.split(" ");
				list.add(new Meat(parts[1], Integer.parseInt(parts[2])));
				
				orders.add(list);

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			input.close();
		}
	}
}
