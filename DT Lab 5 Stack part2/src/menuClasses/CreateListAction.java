package menuClasses;

import dataManager.DMComponent;
import ioManagementClasses.IOComponent;

public class CreateListAction implements Action {

	@Override
	public void execute(Object arg) {
		DMComponent dm = (DMComponent) arg; 
		IOComponent io = IOComponent.getComponent(); 
		io.output("\nAdding a new list of Integer values to the system:\n"); 
		String listName = io.getInput("\nEnter name of new list: "); 
		dm.addList(listName); 
	}

}
