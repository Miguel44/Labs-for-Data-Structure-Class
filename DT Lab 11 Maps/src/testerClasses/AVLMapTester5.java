package testerClasses;

import java.util.ArrayList;

import mapClasses.BSTMap;
import interfaces.Map;
import interfaces.Entry; 

public class AVLMapTester5 {

	public static void main(String[] args) {
		BSTMap<Integer, String> map = 
			new BSTMap<Integer, String>(new NumberComparator1()); 

		mapRemove(0, map); 
		mapInsert(0, "zero", map); 
		mapRemove(0, map); 
		mapInsert(0, "zero", map); 
		mapInsert(50, "fifty", map); 
		mapInsert(30, "thirty", map); 
		mapInsert(70, "seventy", map); 
		mapInsert(20, "twenty", map); 
		mapInsert(33, "thirty three", map); 
		mapInsert(64, "sixty four", map); 
		mapInsert(90, "ninety", map); 
		mapInsert(4, "four", map); 
		mapInsert(27, "twenty seven", map); 
		mapInsert(40, "forty", map); 
		mapInsert(62, "sixty two", map); 
		mapInsert(65, "sisty five", map); 
		mapInsert(85, "eighty five", map); 
		mapInsert(105, "hundred five", map); 
		mapInsert(1, "one", map); 
		mapInsert(8, "eight", map); 
		mapInsert(25, "twenty five", map); 
		mapInsert(60, "sixty", map); 
		mapInsert(80, "eighty", map); 
		mapInsert(100, "hundred", map); 
		mapInsert(110, "hundred ten", map); 
		mapInsert(95, "ninety five", map); 
		mapInsert(115, "hundred fifteen", map); 

		mapRemove(27, map); 
	
		mapRemove(20, map); 
		mapRemove(8, map); 
		
		mapInsert(28, "twenty eight", map); 
		mapRemove(65, map); 
		mapInsert(61, "sixty one", map); 

		mapRemove(95, map); 
		mapRemove(105, map); 
		mapRemove(50, map); 
		
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
