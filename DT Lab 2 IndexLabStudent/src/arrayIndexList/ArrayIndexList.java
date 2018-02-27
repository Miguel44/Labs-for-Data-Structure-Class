package arrayIndexList;

import indexList.IndexList;

public class ArrayIndexList<E> implements IndexList<E> {
	private static final int INITCAP = 1; 
	private static final int CAPTOAR = 1; 
	private static final int MAXEMPTYPOS = 2; 
	private E[] element; 
	private int size; 

	public ArrayIndexList() { 
		element = (E[]) new Object[INITCAP]; 
		size = 0; 
	} 
	

	public void add(int index, E e) throws IndexOutOfBoundsException {
		if(index<0||index >= size+1){
			throw new IndexOutOfBoundsException("add: Invalid index = " + index);
		}
		if(size == element.length){
		      changeCapacity(CAPTOAR);
			}
		for(int i =size-1; i>=index;i--){
			element[i+1] = element[i];
		}
		element[index]=e;
		    size++;
	}


	public void add(E e) {
		if(size == element.length){
		      changeCapacity(CAPTOAR);
			}
			element[size] = e;
		    size++;
	}


	public E get(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index>=size){
			throw new IndexOutOfBoundsException("get: Invalid index = " + index);
		}
		
		return element[index]; 
	}


	public boolean isEmpty() {
		return size == 0;
	}


	public E remove(int index) throws IndexOutOfBoundsException {
		if(index<0||index>= size){
			throw new IndexOutOfBoundsException("remove: Invalid index = " + index);
		}
		int consecutivEmpty = 0;
		E removed = element[index];
		for(int i =index; i<size-1;i++){
			element[i] = element[i+1];
		}
		element[size-1]=null;
		for(int j = size-1; j>=element.length-MAXEMPTYPOS;j--){
			if(element[j]==null)
				consecutivEmpty++;
		}
		if(consecutivEmpty==MAXEMPTYPOS){
			int newCapacity = element.length -1; 
			E[] newElement = (E[]) new Object[newCapacity]; 
			for (int i=0; i<size; i++) { 
				newElement[i] = element[i]; 
				element[i] = null; 
			} 
			element = newElement; 
			size--;
		}
		size--;
		return removed;
	}


	public E set(int index, E e) throws IndexOutOfBoundsException {
		if(index<0||index >=size){
			throw new IndexOutOfBoundsException("set: Invalid index = " + index);
		}
		element[index] = e;
		return element[index];
	}


	public int size() {	
		return size;
	}	
	public int capacity(){
		return element.length;
	}
	
	
	
	// private methods  -- YOU CAN NOT MODIFY ANY OF THE FOLLOWING
	// ... ANALYZE AND USE WHEN NEEDED
	
	// you should be able to decide when and how to use
	// following method.... BUT NEED TO USE THEM WHENEVER
	// NEEDED ---- THIS WILL BE TAKEN INTO CONSIDERATION WHEN GRADING
	
	private void changeCapacity(int change) { 
		int newCapacity = element.length + change; 
		E[] newElement = (E[]) new Object[newCapacity]; 
		for (int i=0; i<size; i++) { 
			newElement[i] = element[i]; 
			element[i] = null; 
		} 
		element = newElement; 
	}
	
	// useful when adding a new element with the add
	// with two parameters....
	private void moveDataOnePositionTR(int low, int sup) { 
		// pre: 0 <= low <= sup < (element.length - 1)
		for (int pos = sup; pos >= low; pos--)
			element[pos+1] = element[pos]; 
	}

	// useful when removing an element from the list...
	private void moveDataOnePositionTL(int low, int sup) { 
		// pre: 0 < low <= sup <= (element.length - 1)
		for (int pos = low; pos <= sup; pos++)
			element[pos-1] = element[pos]; 
	}

}
