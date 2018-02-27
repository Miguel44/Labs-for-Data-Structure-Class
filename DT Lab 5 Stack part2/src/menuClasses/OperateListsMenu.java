package menuClasses;

import java.util.ArrayList;

public class OperateListsMenu extends Menu {
	private static OperateListsMenu OLM = new OperateListsMenu(); 
	private OperateListsMenu() { 
		super(); 
		String title; 
		ArrayList<Option> options = new ArrayList<Option>();  
		title = "Operate on Lists"; 
		options.add(new Option("Show all Lists", new ShowListsAction())); 
		options.add(new Option("Show Content of a List", new ShowListAction())); 
		options.add(new Option("Add a New Value to a List", new AddToListAction())); 
		options.add(new Option("Delete Position from a List", new DeleteFromListAction())); 
		options.add(new Option("Get Statistics from Lists", new ListStatisticsAction())); 
		options.add(Option.EXIT); 

		super.InitializeMenu(title, options); 

	}
	
	public static OperateListsMenu getOperateListsMenu() { 
		return OLM; 
	}
}
