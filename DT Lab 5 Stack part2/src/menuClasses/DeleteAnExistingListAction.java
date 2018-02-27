package menuClasses;
import ioManagementClasses.IOComponent;

import dataManager.DMComponent;
public class DeleteAnExistingListAction implements Action {

	@Override
	public void execute(Object args) {
		IOComponent io = IOComponent.getComponent(); 
		DMComponent dm = (DMComponent) args; 
		String listName = io.getInput("\nEnter name of new list: "); 
		dm.deleteList(listName);
	}

}
