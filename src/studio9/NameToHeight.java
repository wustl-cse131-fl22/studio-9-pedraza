package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map heights = new HashMap();
		heights.put("Ke", "5'8");
		heights.put("Pedzo", "5'8");
		
		System.out.println("Name: ");

		String name = in.next();
		
		
		while (name.equals("quit") == false) {
			
			if (name.equals(null)) {
				System.out.println("Input is null!\n");
			} else if (!heights.containsKey(name)) {         // name not in heights
				System.out.println("Name not found!\n");
			} else {
				System.out.println(name + ": " + heights.get(name) + "\n");
			}
			
			
			System.out.println("Name: ");
			System.out.println();
			name = in.next();
			
		}

		
	}
}
