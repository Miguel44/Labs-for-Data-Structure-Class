package menuClasses;

import dataManager.DMComponent;

public class ExitAction implements Action {

	@Override
	public void execute(Object arg) {
		DMComponent dm = (DMComponent) arg; 
		dm.getMenuStack().pop(); 
	}

}
