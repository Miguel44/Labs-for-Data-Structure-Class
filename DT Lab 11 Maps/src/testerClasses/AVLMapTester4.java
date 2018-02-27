package testerClasses;

import mapClasses.BSTMap;
import interfaces.Map;
import interfaces.Entry; 

public class AVLMapTester4 {

	public static void main(String[] args) {
		BSTMap<Integer, String> map = 
			new BSTMap<Integer, String>(new NumberComparator1()); 

		for (int i=0; i<500; i++)
			mapInsert(i, (-i)+"", map); 
		for (int i=-5; i<110; i++)
			mapRemove(i, map); 

	}
	
	private static void mapInsert(int key, String value, BSTMap<Integer, String> map) { 
		System.out.println("\nMap after inserting [key = " + key + ", " + " values = " + value + "]"); 
		map.put(key, value); 
		map.displayTree();
		
	}
	private static void mapRemove(int key, BSTMap<Integer, String> map) { 
		System.out.println("\nMap after removing [key = " + key + ", " + " VALUE = " + map.remove(key) + "]"); 
		map.displayTree();
		
	}
	private static <K,V> void showMap(final String msg, final Map<K,V> m) { 
		System.out.println("\n" + msg); 
		BSTMap<K,V> bstm = (BSTMap<K,V>) m; 
		bstm.displayTree(); 
	}
	private static <K,V> void showMapValues(final String msg, final Map<K,V> m) { 
		System.out.println("\n" + msg); 
		for (V value : m.values()) 
			System.out.println(value); 
	}

	private static <K,V> void showMapKeys(final String msg, final Map<K,V> m) { 
		System.out.println("\n" + msg); 
		for (K key : m.keySet()) 
			System.out.println(key); 
	}

	private static <K,V> void showMapEntries(final String msg, final Map<K,V> m) { 
		System.out.println("\n" + msg); 
		for (Entry<K,V> e : m.entrySet()) 
			System.out.println(e); 
	}

}
