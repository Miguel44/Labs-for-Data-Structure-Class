package testers;

import java.util.Comparator;

import indexList.IndexList;
import indexList.SLRIndexList;

public class LinkedListTester1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		listTester("Testing the Index List based on recursive singly linked list (SLRIndexList): ",
				new SLRIndexList<Integer>());	
	}
		
	private static void listTester(String msg, IndexList<Integer>  list) { 
		System.out.println(msg);

		try { 
			list.add(1, 400); 
		} 
		catch (Exception e) { 
			System.out.println(e); 
		}
		list.add(0, 435); 
	    list.add(1, 200); 
		
		for (int i=20, j=1; i< 50; i+=5, j++) { 
			list.add(j, i); 
		}
		
		showList(list); 


		 
		showListAfterDeleting(list, 4); 
		showListAfterDeleting(list, 2); 
		showListAfterDeleting(list, 30); 
		showListAfterAdding(list, 3,  700); 
		

		/** REMOVE THIS LINE TO TEST list reversing
		 
		showListAfterReversingContent(list); 
		
		   REMOVE THIS LINE TO TEST list reversing  **/
		
		showListAfterAdding(list, 0,  700); 
		showListAfterAdding(list, 1,  800); 
		showListAfterAdding(list, 2,  900); 
		showListAfterAdding(list, 2,  1000); 
		showListAfterAdding(list, 1,  1001); 
		showListAfterAdding(list, 3,  1002); 
		showListAfterAdding(list, 3,  700); 
		showListAfterAdding(list, 1,  800); 
		showListAfterAdding(list, 2,  900); 
		showListAfterAdding(list, 2,  1000); 
		showListAfterAdding(list, 1,  1001); 
		showListAfterAdding(list, 3,  1002); 

		
		
		 
		 
		showListAfterReplacingElement(list, 0,  1800); 
		showListAfterReplacingElement(list, 2,  999); 
		showListAfterReplacingElement(list, 2,  2222); 
		showListAfterReplacingElement(list, 1,  1511); 
		showListAfterReplacingElement(list, list.size()-1, 404); 
		

		
		
		showListAfterSorting(list, new IntegerComparator1()); 
		showListAfterSorting(list, new IntegerComparator2()); 
		
		
		
	}
		
	
	private static void showElement(IndexList<Integer> list, int position) { 
		try { 
			System.out.println(" --Element in position " 
					+ position + " is: "+ list.get(position)); 
		}
		catch (Exception e) { 
			System.out.println(e); 
		}
	}
	
	private static void showListAfterSorting(IndexList<Integer> list, Comparator<Integer> cmp) { 
		System.out.println("\n Sorted list is: "); 
		list.sort(cmp); 
		showList(list); 
	}

	private static void showSize(IndexList<Integer> list) { 
		System.out.println("\nSize of the list is: "+list.size()); 		
	}
	
	private static void showList(IndexList<Integer> list) { 
		System.out.println("\n*** The "+ list.size()+ " elements in the list are: "); 
		int lpindex = list.size(); 
		for (int i=0; i< lpindex; i++)
		    showElement(list,i); 
	}
	
	private static void showListAfterDeleting(IndexList<Integer> list, int pos) { 
		System.out.println("\n -- deleting element at position "+pos); 
		try { 
			Integer etr = list.remove(pos); 
			System.out.println(" -- value of deleted element was "+ etr);
			showList(list); 
		}
		catch (Exception e) { 
			System.out.println(e); 
		}
	}
	
	private static void showListAfterAdding(IndexList<Integer> list, int pos, Integer element) { 
		System.out.println("\n -- adding value " + element+" at position "+pos); 
		try { 
			list.add(pos, element);  
			showList(list); 
		}
		catch (Exception e) { 
			System.out.println(e); 
		}
	}
	
	private static void showListAfterReplacingElement(IndexList<Integer> list, 
			int pos, Integer element) 
	{ 
		System.out.println("\n -- replacing value at position "+pos+" by "+element); 
		try { 
			Integer etr = list.set(pos, element);  
			System.out.println(" -- value of replaced element was "+ etr);
			showList(list); 
		}
		catch (Exception e) { 
			System.out.println(e); 
		}
	}
	
	private static void showListAfterReversingContent(IndexList<Integer> list) 
	{ 
		System.out.println("\n -- reversing content of the list...."); 
		list.reverseContent(); 
		showList(list); 
	
	}
	
	
	/**************** Integer comparators **************************/
	private static class IntegerComparator1 implements Comparator<Integer> { 
		public int compare(Integer a, Integer b) { 
			return b-a; 
		}
	}
	
	private static class IntegerComparator2 implements Comparator<Integer> { 
		public int compare(Integer a, Integer b) { 
			return a-b; 
		}
	}
	
}
