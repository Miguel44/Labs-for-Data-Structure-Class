package positionListLLDirect;

import positionInterfaces.Position;

public class NodePositionList1Tester {
public static void main(String[] args) {
		
		NodePositionList1<Integer> w = new NodePositionList1<Integer> (new PositionListBackwardsIterator<Integer>()); 
		NodePositionList1<Integer> q = new NodePositionList1<Integer> (); 
		q.addFirst(10); 
		
		w.addFirst(5); 
		w.addFirst(3); 
		
		w.addLast(10); 
		w.addLast(13); 
		try {
			Position<Integer> p = w.first();
			w.addAfter(p, 2); 
			p = w.next(p); 
			w.addAfter(p, 34); 
			w.addBefore(p, 40); 
			p = q.first(); 
	//		w.addAfter(p, 89); 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		showElements(w); 

	}

	private static <E> void showElements(NodePositionList1<E> w) {
		for(E p : w) 
			System.out.println(p); 
	}
}
