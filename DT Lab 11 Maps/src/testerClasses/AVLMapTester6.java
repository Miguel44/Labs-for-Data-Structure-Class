package testerClasses;

import java.util.ArrayList;

import mapClasses.BSTMap;
import interfaces.Map;
import interfaces.Entry; 

public class AVLMapTester6 {

	public static void main(String[] args) {
		BSTMap<Integer, String> map = 
			new BSTMap<Integer, String>(new NumberComparator1()); 

		mapInsert(5, "five", map); 
		mapInsert(8, "eight", map); 
		mapRemove(8, map); 
		mapInsert(8, "eight", map); 
		mapInsert(5, "five2", map); 
		mapInsert(16, "sixteen", map); 
		mapInsert(3, "three", map); 
		mapInsert(7, "seven", map); 
		mapInsert(13, "thirteen", map); 
		mapInsert(18, "eighteen", map); 
		mapInsert(2, "two", map); 
		mapInsert(4, "four", map); 
		mapInsert(6, "six", map); 
		mapInsert(11, "eleven", map); 
		mapInsert(14, "fourteen", map); 
		mapInsert(17, "seventeen", map); 
		mapInsert(19, "nineteen", map); 
		mapInsert(1, "one", map); 
		mapInsert(10, "ten", map); 
		mapInsert(12, "twelve", map); 
		mapInsert(15, "fifteen", map); 
		mapInsert(20, "twenty", map); 
		mapInsert(9, "nine", map); 
		
		mapRemove(5, map); 
		
		while (!map.isEmpty()) { 
			ArrayList<Integer> keySet = new ArrayList<>(); 
			for (Integer key : map.keySet()) 
				keySet.add(key); 
			for (Integer key : keySet) 
				mapRemove(key, map); 
		}

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
