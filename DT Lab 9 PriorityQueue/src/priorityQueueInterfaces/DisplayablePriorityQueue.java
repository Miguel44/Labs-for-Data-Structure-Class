package priorityQueueInterfaces;

/**
 * This represents a modification of PriorityQueue that, in 
 * addition to the standard operations of PQ ADT, it includes
 * an operation for displaying its content. 
 * 
 * This is useful for testing purposes without altering the
 * PQ ADT's specification. 
 * 
 * @author pedroirivera-vega
 *
 * @param <K>
 * @param <V>
 */
public interface DisplayablePriorityQueue<K, V> 
extends PriorityQueue<K,V> {
	/**
	 * Displays the current content (entries) in the priority
	 * queue. The order, or structure, used in the display will
	 * eventually depend on particular final implementations.  
	 */
	void display(); 
}
