package menuClasses;

import java.util.ArrayList;

public class ListStatisticsMenu extends Menu {
	private static ListStatisticsMenu LSM = new ListStatisticsMenu(); 
	private ListStatisticsMenu() { 
		super(); 
		String title; 
		ArrayList<Option> options = new ArrayList<Option>();  
		title = "Statistics on Lists"; 
		options.add(new Option("Show all Lists", new ShowListsAction())); 
		options.add(new Option("Show Content of a List", new ShowListAction())); 
		options.add(new Option("Show sum of a List", new ShowListSumAction())); 
		options.add(new Option("Show average of a List", new ShowListAverageAction())); 
		options.add(new Option("Show max value in a List", new ShowMaxValueListAction())); 
		options.add(Option.EXIT); 

		super.InitializeMenu(title, options); 

	}
	
	public static ListStatisticsMenu getListStatisticsMenu() { 
		return LSM; 
	}

}
