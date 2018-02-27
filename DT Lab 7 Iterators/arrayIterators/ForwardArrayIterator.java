package arrayIterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardArrayIterator<E> implements Iterator<E> {

	private E[] arr;  
	private int current; 
	// the array to iterate over
	// other internal fields...
	
	public ForwardArrayIterator(E[] arr) { 
		this.arr = arr;
		this.current = 0;
		// initialize other internal fields as needed
	}
	
	public boolean hasNext() {
		return current < arr.length;
  
	}

	public E next() throws NoSuchElementException {
		if (!hasNext())
			throw new 
				NoSuchElementException("No more elements to iterate over."); 
	
		return arr[current++];
	}

	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException(
				"Remove peration not implemented.");
	
	}
}
