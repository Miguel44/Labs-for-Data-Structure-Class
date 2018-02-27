package mapClasses;

import java.util.ArrayList;
import java.util.Comparator;

import positionalStructures.Position;
import treeClasses.LinkedAVL_BST;
import interfaces.Entry;
import interfaces.Map;

public class BSTMap<K, V> implements Map<K, V> {
	// the binary search tree supporting this implementation of the map
	private LinkedAVL_BST<Entry<K, V>> tree;   	
	
	/**
	 * Creates an instance of BSTMap. 
	 * @param cmp the comparator of keys that is received and which shall
	 * be used to compare keys of entries. Notice that the received comparator
	 * is used to create a new type of Entry comparator (EntryComparator). 
	 * See the internal class TreeMapEntryComparator at the end of this file. 
	 * 
	 * Notice that the tree needs a comparator that can be used to compare its
	 * elements; and, since the elements in the instantiated tree are of type
	 * Entry<K, V>, then we need a comparator of entries, and that is what the
	 * data type EntryComparator is meant for. The constructor for this
	 * type of entry comparator receives the key comparator. The compare(..) 
	 * method for the entry comparator is implemented based on the comparator
	 * method for that key comparator that is received when the map is being
	 * instantiated. 
	 */
	public BSTMap(Comparator<K> cmp) { 
		tree = new LinkedAVL_BST<>(new EntryComparator<K, V>(cmp)); 
	}
	
	@Override
	/**
	 * the size of the map is the size of the tree. 
	 */
	public int size() {
		return tree.size();
	}

	@Override
	/** 
	 * the map is empty iff the tree is empty
	 */
	public boolean isEmpty() {
		return tree.isEmpty();
	}

	@Override
	/**
	 * Get operation of the map. 
	 */
	public V get(K key) {
		// Applies the get method to the tree. Since the bst bases its searches on 
		// an element received as parameter, and since the internal tree here is 
		// a tree of entries, then that element to compare needs to be an entry
		// too in this case, and not just the key. Therefore, we use the strategy
		// of sending a partial entry with the minimum information required to 
		// compare entries. That that minimum information is the received key. 
		// For that, we we use the following object: new MapEntry<K, V>(key, null). 
		// (See how entry comparator works -- internal class EntryComparator.)
		//
		// The getPosition(..) method will use that object to make the internal 
		// comparisons. It will return (if there is a matching) the position in 
		// the tree whose element has key that is equal to the key received. 
		// If not math, it will return null. 
		// 
		Position<Entry<K, V>> result = tree.getPosition(new MapEntry<>(key, null)); 
		
		// if not found, return null
		if (result == null) return null; 
		
		// if found, the value of the element that matches the search.
		return result.getElement().getValue();
	}

	@Override
	/**
	 * put of the map...
	 */
	public V put(K key, V value) {
		Position<Entry<K, V>> result = tree.getPosition(new MapEntry<>(key, null)); 
		if (result != null) 
			return ((MapEntry<K, V>) result.getElement()).setValue(value); 
		else
			tree.addElement(new MapEntry<>(key, value));
	
		return null;
	}

	@Override
	/**
	 * remove of the map
	 */
	public V remove(K key) {
		Entry<K, V> result = tree.removeElement(new MapEntry<K, V>(key, null)); 
		if (result != null)
			return result.getValue();
		return null; 
	}

	@Override
	public Iterable<K> keySet() {
		ArrayList<K> ks = new ArrayList<>(); 
		for (Entry<K, V> e : entrySet())
			ks.add(e.getKey()); 
		return ks; 
	}

	@Override
	public Iterable<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		ArrayList<Entry<K, V>> eList = new ArrayList<>(); 
		
		for (Position<Entry<K, V>> p : tree.positions())
			eList.add(p.getElement()); 
		
		return eList;
	}

	public void displayTree() { 
		this.tree.display();
	}
	
	
	/**
	 * The following class is an implementation of a Comparator that is to be
	 * used to compare entries. it is based on a comparator of keys. The 
	 * comparator to be used by the supporting binary search tree will be
	 * one comparator of this type. Notice that is it needed because the 
	 * tree is a tree of elements of type Entry<K, V>; hence the comparator
	 * that is uses needs to be a comparator of entries, not just keys. 
	 * However, as mentioned before, it is based on the comparator of 
	 * keys that the map receives. 
	 * 
	 * @author pedroirivera-vega
	 *
	 * @param <K>
	 * @param <V>
	 */
	private static class EntryComparator<K, V> implements Comparator<Entry<K, V>> {
		private Comparator<K> keyComparator; 
		public EntryComparator(Comparator<K> keyComparator) {
			this.keyComparator = keyComparator; 
		}
		public int compare(Entry<K, V> e1, Entry<K, V> e2) { 
			return keyComparator.compare(e1.getKey(), e2.getKey()); 
		}
	}
	
	/**
	 * Class for an implementation of Entry<K, V> 
	 * @author pedroirivera-vega
	 *
	 * @param <K>
	 * @param <V>
	 */
	private static class MapEntry<K, V> implements Entry<K, V> {
		private K key; 
		private V value; 
		
		public MapEntry(K key, V value) { 
			this.key = key; 
			this.value = value; 
		}
		
		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		} 
		
		public V setValue(V value) { 
			V old = this.value; 
			this.value = value; 
			return old; 
		}
		
		public String toString() { 
			return "[" + key + ", " + value +"]"; 
		}
	}
	
}
