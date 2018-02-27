package testers;
import queue.ArrayQueue;

import queue.Queue;
import queue.SLLQueue;

public class QueueTester {
	public static void main(String Args[]){
		
		 ArrayQueue<Integer> QA1 = new ArrayQueue<>();
		 Queue<Integer> QA = QA1;
		 
		 SLLQueue<Integer> QS1 = new SLLQueue<>();
		 Queue<Integer> QS = QS1;

		 
		 testQ(QA);
		 testQ(QS);
		 
	}
	
	public static <E> void testQ(Queue<Integer> s){
		System.out.println("Testing Queue:");
		Integer[] a = { 3, 2, 4, 55, 5, 1, 1, 17, 9, 3, 0, 4, 5, 7, 17, 28, 0, 9, 10, 40, 21, 22, 5, 6, -1}; 
		for (int n : a) { 
			try { 
				if (n == 0) 
					s.showReverse(); 
				else if (n % 2 == 1)
					s.enqueue(n); 
				else
					System.out.println("Extracting element: " + s.dequeue()); 
			}
			catch (Exception e) { 
				System.out.println(e); 
			}
		}
		s.showReverse(); 
		System.out.println("Testing Ended");
	}
}
