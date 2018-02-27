package interfaces;

public interface Map<K, V> {
	/**
	 * Determines the number of elements currently in the map 
	 * collecion. 
	 * @return integer value corresponding to the number of
	 * elements currently in the  collection. 
	 */
	int size(); 
	
	/**
	 * Determines if the collection is empty.
	 * @return true if empty; false, otherwise.
	 */
	boolean isEmpty(); 
	
	/**
	 * Searches a specified entry in the collection.
	 * @param key uniquely identifies the entry to look for
	 * @return null if entry with given key is not found; 
	 * otherwise, it returns reference to the entry having the
	 * particular element. 
	 */
	V get(K key); 
	
	/**
	 * If the collection does not have an entry with key “equal” to 
	 * the given key, then it adds a new entry containing the 
	 * given key-value pair and return null. I it already exists, 
	 * it replaces with value the existing value of the entry with 
	 * key equal to key and return the old value
	 * @param key key of the new element. 
	 * @param value value of the new element
	 * @return null if no entry exists in the collection with the 
	 * given key value; otherwise it returns reference to the value
	 * being replaced.
	 */
	V put(K key, V value);
	
	/**
	 * Return value in the entry currently in the collection having
	 * the given key value, if one exists; otherwise it returns 
	 * null. 
	 * @param key identifies the entry to look for.
	 * @return null if no entry is  found having the given key as 
	 * its key. Otherwise, it returns reference to the value paired 
	 * to the given key.
	 */
	V remove(K key); 
	
	/**
	 * Constructs an iterable collection containing all the keys 
	 * stored in the map collection. 
	 * @return the iterable collection of keys.
	 */
	Iterable<K> keySet(); 
	
	/**
	 * Constructs an iterable collection containing all the values 
	 * store in the map collection. 
	 * @return the iterable collection of values.
	 */
	Iterable<V> values();
	
	/**
	 * Constructs an iterable collection containing all the key-
	 * value entries in the map collection. 
	 * @return the iterable collection of entries.
	 */
	Iterable<Entry<K,V>> entrySet(); 
}


