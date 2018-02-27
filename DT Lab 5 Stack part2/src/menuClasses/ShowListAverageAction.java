package menuClasses;

import ioManagementClasses.IOComponent;
import dataManager.DMComponent;

public class ShowListAverageAction implements Action {

	@Override
	public void execute(Object arg) {
		IOComponent io = IOComponent.getComponent(); 
		DMComponent dm = (DMComponent) arg; 
		String name = io.getInput("Enter the name of the list to determine its average: ");
		dm.showAverageInList(name); 
	}

}
