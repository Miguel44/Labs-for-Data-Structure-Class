package dataManager;

import java.util.ArrayList;
import java.util.Stack;

import ioManagementClasses.IOComponent;
import menuClasses.Menu;

/**
 * Data Manager component
 * 
 * @author pedroirivera-vega
 *
 * This class implements and object the groups together all the different 
 * operations with the data that is being managed by the system. In this
 * case, the different lists that the system manages. 
 */
public class DMComponent {
	private Stack<Menu> mStack;          // stack to manage actions in this system
	private ArrayList<NamedList> lol;    // list of lists of Integers
	
	public DMComponent() { 
		lol = new ArrayList<NamedList>(); 
		mStack = new Stack<Menu>(); 
	} 
	
	/**
	 * Adds a new list to the system
	 * @param name the name of the list
	 */
	public void addList(String name) { 
		int index = getIndexForList(name); 
		if (index != -1) 
			IOComponent.getComponent().output("Duplicate list name " + name + ".\n"); 
		else { 
			NamedList nlist = new NamedList(name); 
			lol.add(nlist); 
		}
	}
	
	/**
	 * Adds a new element to a particular list.
	 * @param name the name of the list
	 * @param value the value to add
	 */
	public void addIntToList(String name, int value) { 
		int index = getIndexForList(name); 
		if (index == -1) 
			IOComponent.getComponent().output("No such list, " + name + ", exists.\n"); 
		else { 
			lol.get(index).add(value); 
		}

	}
	
	/**
	 * Removes element from a particular list. 
	 * @param name the name of the list
	 * @param posIndex index of the  position to be removed
	 */
	public void removeElementFromList(String name, int posIndex) { 
		int index = getIndexForList(name); 
		if (index == -1) 
			IOComponent.getComponent().output("No such list, " + name + ", exists.\n"); 
		else { 
			try { 
			   lol.get(index).remove(posIndex); 
			} catch (IndexOutOfBoundsException e) { 
				IOComponent.getComponent().output("Invalid index = " + posIndex +
						" for list " + name + ".\n"); 
			}
		}
	}
	
	/**
	 * Displays the names of all current lists in the system.
	 */
	public void showListsNames() {
		String outS = "\nShowing lists in the system\n\n";

		if (lol.isEmpty()) 
			outS += "There are no lists yet in the system.\n"; 
		else 
			for (NamedList e : lol) {
				outS += e.getName() + "\n";; 
			}
		
		IOComponent.getComponent().output(outS + "\n"); 
	
	}
	
	public void deleteList(String name){
		int index = getIndexForList(name);
		if (index == -1) 
			IOComponent.getComponent().output("No such list, " + name + ", exists.\n"); 
		else
			lol.remove(index);
	}
	
	/**
	 * Displays all the elements in a particular list. 
	 * @param name the name of the list to be displayed.
	 */
	public void showListElements(String name) { 
		int index = getIndexForList(name); 
		if (index == -1) 
			IOComponent.getComponent().output("No such list, " + name + ", exists.\n"); 
		else if (!lol.get(index).isEmpty()) { 
			String outS = "\nShowing content of list " + name + "\n\n";
			int pos = 0; 
			for (Integer e : lol.get(index)) {
				outS += name+"[" + pos + "] = " + e + "\n";
				pos++; 
			}
			IOComponent.getComponent().output(outS + "\n"); 	
		} else { 
			IOComponent.getComponent().output("\nSelected list is empty."); 
		}
		
	}
	
	/**
	 * Displays the average of numbers in a particular list. 
	 * @param name the name of the list.
	 */
	public void showAverageInList(String name) { 
		int index = getIndexForList(name); 
		if (index == -1) 
			IOComponent.getComponent().output("No such list, " + name + ", exists.\n"); 
		else if (!lol.get(index).isEmpty()) {  
			String outS = "\nShowing average of list " + name + "\n\n";
			float sum = 0; 
			for (Integer e : lol.get(index)) {
				sum += e;  
			}
			IOComponent.getComponent().output(outS + "\nAverage is: "
			            + sum/lol.get(index).size() + "\n"); 
			
		} else { 
			IOComponent.getComponent().output("\nSelected list is empty."); 
		}
	
	}
	
	/**
	 * Displays the sum of all elements in a particular list. 
	 * @param name the name of the list.
	 */
	public void showSumInList(String name) { 
		int index = getIndexForList(name); 
		if (index == -1) 
			IOComponent.getComponent().output("No such list, " + name + ", exists.\n"); 
		else if (!lol.get(index).isEmpty()) {  
			String outS = "\nShowing sum of values in list " + name + "\n\n";
			int sum = 0; 
			for (Integer e : lol.get(index)) {
				sum += e;  
			}
			IOComponent.getComponent().output(outS + "\nSum is: "
			            + sum + "\n"); 
			
		} else { 
			IOComponent.getComponent().output("\nSelected list is empty."); 
		}
	
	}
	
	/**
	 * Displays the maximum value in a given list. 
	 * @param name the name of the list.
	 */
	public void showMaxValueInList(String name) { 
		int index = getIndexForList(name); 
		if (index == -1) 
			IOComponent.getComponent().output("No such list, " + name + ", exists.\n"); 
		else if (!lol.get(index).isEmpty()) {  
			String outS = "\nShowing max value of list " + name + "\n\n";
			int maxVal = lol.get(index).get(0); 
			for (Integer e : lol.get(index)) {
				if (e > maxVal)
					maxVal = e; 
			}
			IOComponent.getComponent().output(outS + "\nMax Value is: "
			            + maxVal + "\n"); 
			
		} else { 
			IOComponent.getComponent().output("\nSelected list is empty."); 
		}
	
	}
	
	/**
	 * Internal private auxiliary method. Gets the index identifying 
	 * a particular list in the system. 
	 * @param name the name of the list to search for,
	 * @return -1 if such list is not in the system. A non-negative 
	 * integer value corresponding to the index of the position
	 * that such list occupies in the system's list of lists...
	 */
	private int getIndexForList(String name) { 
		for (int i=0; i<lol.size(); i++) 
			if (name.equals(lol.get(i).getName())) 
				return i; 
		
		return -1; 
	}
	
	/**
	 * Returns reference to the stack object used to manage different
	 * states of the system. 
	 * @return reference to the stack. 
	 */
	public Stack<Menu> getMenuStack() { 
		return mStack; 
	}
		
	/**
	 * Inner class defining a NamedList object type. 
	 * @author pedroirivera-vega
	 *
	 */
	private static class NamedList extends ArrayList<Integer> { 
		private String name;  
		public NamedList(String name) { 
			super(); 
			this.name = name; 
		}
		public String getName() { 
			return name; 
		}
	}
}
