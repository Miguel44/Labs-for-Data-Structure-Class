package menuClasses;

import dataManager.DMComponent;

public class OperateListAction implements Action {

	@Override
	public void execute(Object arg) {
		DMComponent dm = (DMComponent) arg; 
		dm.getMenuStack().push(OperateListsMenu.getOperateListsMenu()); 
	}

}
