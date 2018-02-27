package testerClasses;

import priorityQueueInterfaces.PriorityQueue;

public class TesterUtils {
	public static <E> void displayArray(String msg, E[] arr) {
		System.out.println("\n"+msg); 
		for (int i=0; i<arr.length; i++)
			System.out.println("arr[" + i + "] = " + arr[i]); 
		
	}

	public  static <E> void what(E[] arr, PriorityQueue<E, E> pq) {
		for (E n : arr)
			pq.insert(n, null); 
		for(int i = 0; i<arr.length;i++)
			arr[i] = pq.removeMin().getKey();
        
	}

}
