package priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;

import priorityQueueInterfaces.Entry;

/**
 * Implementation of a PriorityQueue based in an ArrayList<Entry<K, V>>.
 * @author pedroirivera-vega
 *
 * @param <K>
 * @param <V>
 */
public class UnsortedListPriorityQueue<K, V> extends AbstractListPriorityQueue<K, V> {
	
	public UnsortedListPriorityQueue(Comparator<K> cmp) { 
		super(cmp);
		list = new ArrayList<>(); 
	}
	
	public UnsortedListPriorityQueue() { 
		super(); 
		list = new ArrayList<>(); 
	}
	

	/**
	 * Internal method to find the index of the element in list
	 * containing an entry having min key (based on the comparator)
	 * @return index of the element having min key in list. 
	 */
	protected int minEntryIndex() {
		// internal method - PRE: list is not empty
		// sequentially look for min
		int mpIndex = 0; 
		
		for (int i=1; i<list.size(); i++)
			if (compare(list.get(i), list.get(mpIndex)) < 0)
				mpIndex = i; 
		return mpIndex;
	}
	
	@Override
	/**
	 * Insert as for the unsorted list implementation. Add new entry to the end
	 * of the list. 
	 */
	public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
		super.validate(key); 
		Entry<K,V> newest = new PQEntry<K,V>(key, value);
		list.add(newest);
		return newest; 
	}

}
