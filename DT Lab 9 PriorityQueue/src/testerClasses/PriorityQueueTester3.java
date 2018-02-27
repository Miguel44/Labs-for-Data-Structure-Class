package testerClasses;

import priorityQueue.HeapListPriorityQueue;
import priorityQueue.UnsortedListPriorityQueue;
import priorityQueueInterfaces.PriorityQueue;

public class PriorityQueueTester3 {
	public static void main(String[] args) {
		String[] arr = {"barrio", "pepe", "julia", "maria", "oliva", "meme", "parada", "baile", "enjendro", 
		         "vagabundo", "nota", "tienda", "zapato", "caballo", "cafe", "diodo", "multiplica"}; 

		
		PriorityQueue<String, String> pq; 
		
		//pq = new UnsortedListPriorityQueue<String, String>(new StringComparator1());    // 1
		//pq = new SortedListPriorityQueue<Integer, Integer>(new IntegerComparator1());    // 2
		pq = new HeapListPriorityQueue<String, String>(new StringComparator1());      // 3
		//pq = new HeapPriorityQueue<Integer, Integer>(new IntegerComparator1());          // 4

		TesterUtils.displayArray("Content of the array before ", arr); 
		TesterUtils.what(arr, pq); 
		TesterUtils.displayArray("Content of the array after ", arr); 
	}

}
