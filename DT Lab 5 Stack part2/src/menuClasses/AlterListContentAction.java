package menuClasses;
import dataManager.DMComponent;

public class AlterListContentAction implements Action {

	@Override
	public void execute(Object arg) {
		DMComponent dm = (DMComponent) arg; 
		dm.getMenuStack().push(AlterListContentMenu.getAlterListContentMenu()); 
		
		
	}

}
