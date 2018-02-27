package indexList;

import java.util.Comparator;



public class SLRIndexList<E> implements IndexList<E> {

	private SNode<E> first; 
	private int size; 

	public SLRIndexList() { 
		first = null; 
		size = 0; 
	} 

	public boolean isEmpty() { 
		return size == 0; 
	} 

	public int size() { 
		return size; 
	} 

	public E get(int index) 
	throws IndexOutOfBoundsException 
	{ 
		if (index < 0 || index >= size) 
			throw new IndexOutOfBoundsException(
					"SLRIndexList.get: invalid index = " + index); 

		// index is valid
		return recGet(first, index); 
	}

	public void add(int index, E e) 
	throws IndexOutOfBoundsException 
	{ 
		if (index < 0 || index > size) 
			throw new IndexOutOfBoundsException(
					"SLRIndexList.add: invalid index = " + index); 

		first = recAdd(first, index, e); 
		size++; 
	} 

	public E remove(int index) 
	throws IndexOutOfBoundsException 
	{ 
		if (index < 0 || index >= size) 
			throw new IndexOutOfBoundsException(
					"SLRIndexList.remove:invalid index = " + index); 

		// index is valid for remove operation
		E etr = get(index); 
		 recRemove(first,index);
		
		size--; 

		return etr; 
	} 

	public E set(int index, E e) 
	throws IndexOutOfBoundsException 
	{ 
		if (index < 0 || index >= size) 
			throw new IndexOutOfBoundsException(
					"SLRIndexList.set: invalid index = "+ index); 

		// index is valid for set operation
		return recSet(first, index, e);  
	} 


	// Auxiliary recursive methods for get, add, remove, and set
	private static <E> E recGet(SNode<E> f, int i) 
	{ 
		if (i==0)
			return f.getElement(); 
		else 
			return recGet(f.getNext(), i-1);
	} 

	/*************************************************************/
	/* RECURSIVE AUXILIARY METHODS FOR THE STANDARD METHODS      */
	/* OF INDEX LIST ADT. SEE DESCRIPTIONS IN SPECIFICATIONS     */
	/* DOCUMENT.                                                 */
	/*************************************************************/
	private static <E> SNode<E> recRemove(SNode<E> f, int i) 
	{ 
		if (i==0) {
			SNode<E> ntd = f;  
			f = f.getNext(); 
			ntd.clean(); 
			return f; 
		}
		else { 
			f.setNext( recRemove(f.getNext(), i-1)); 
			return f; 
		}
	} 
	
	private static <E> SNode<E> recAdd(SNode<E> f, int i, E e) 		
	{ 

		if (i==0) { 
			SNode<E> newNode = new SNode<E>(e,f);
			
		
			return newNode;
		}
		else {
		SNode<E> nextNode = (recAdd(f.getNext(),i-1,e));	
		f.setNext(nextNode);
		
		return f;
		}
	   
	} 

	private static <E> E recSet(SNode<E> f, int index, E e) 
	{ 
		if(index==0){
			E newElem =  f.getElement();
			f.setElement(e);
			
			
			return newElem;
		}else{
			E newElem = (recSet(f.getNext(),index-1,e));
			return newElem;
		}
		
	
	} 
	
	

	/***********************************************************************/
	/*  METHOD TO SORT THE LIST RECURSIVELY - BASED ON THE INSERSTION SORT */
	/***********************************************************************/
	
	/** Sorts the elements in non-decreasing order based on the 
	 * comparator object received. 
	 * @param cmp the comparator object. It establishes the
	 * relation order upon which the ordering will be based. 
	 **/ 
	public void sort(Comparator<E> cmp) { 
		if (first == null) 
			return; 
		else 
			first = recInsertionSort(first, cmp); 
	}
	
	private static <E> SNode<E> recInsertionSort(SNode<E> first, Comparator<E> cmp) {
		if (first.getNext() == null)
			return first; 
		else { 
			SNode<E> first2 = recInsertionSort(first.getNext(), cmp); 
			return recInsertByOrder(first, first2, cmp); 
		}
	}
	
	/**
	 * Inserts a new node into the sll whose first node is given and assumed ordered in
	 * non-decreasing order based on the order implied by a comparator given. 
	 * @param <E> 
	 * @param nti the node to insert
	 * @param first the first node of the list where the insertion is to take place.
	 *     The list is assumed sorted.
	 * @param cmp the comparator upon which the sorting is based
	 * @return reference to the first node of the resulting list (the original
	 *     list with the new node inserted into the right place...)
	 */
	private static <E> SNode<E> recInsertByOrder(SNode<E> nti, SNode<E> first, Comparator<E> cmp)
	{
		if (first == null) { 
			nti.setNext(null); 
			return nti; 
		}
		else if (cmp.compare(nti.getElement(), first.getElement()) <= 0) { 
			nti.setNext(first); 
			return nti; 
		} 
		else {
			first.setNext(recInsertByOrder(nti, first.getNext(), cmp)); 
			return first; 
		}
	}

	
	/*****************************************************************/
	/**   METHOD TO RECURSIVELY REVERSE THE CONTENT ON A LINKED LIST */
	/*****************************************************************/
	
	/**
	 * Reverses the content of the list. The elements of the
	 * list will be repositioned in the opposite order as
	 * they are
	 */
	public void reverseContent() { 
		if (first != null)
    		first = recReverseContent(first); 
	}
	
	private static <E> SNode<E> recReverseContent(SNode<E> h) { 
		if (h.getNext() == null)
			return h; 
		else { 
			SNode<E> nh = recReverseContent(h.getNext()); 
			h.getNext().setNext(h); 
			h.setNext(null); 
			return nh; 
		}
			
	}

	
	/*************************************************************/
	/*  MISCELLANEOUS METHODS TO RELEASE THE MEMORY USED BY THE  */
	/*  LINKED LIST WHEN NOT TO BE USED ANYMORE, OR WHEN IT      */
	/*  NEEDS TO BE EMPTIED.                                     */
	/*************************************************************/
	
	/**
	 * Prepares every node so that the garbage collector can free 
	 * its memory space, at least from the point of view of the
	 * list. This method is supposed to be used whenever the 
	 * list object is not going to be used anymore. Removes all
	 * physical nodes (data nodes and control nodes, if any)
	 * from the linked list
	 */
	private void removeAll() {
		while (first != null) { 
			SNode<E> nnode = first.getNext(); 
			first.setElement(null); 
			first.setNext(null); 
			first = nnode; 
		}
	}

	/**
	 * The execution of this method removes all the data nodes
	 * from the current instance of the list. 
	 */
	public void makeEmpty() { 
		// TODO
	}

	protected void finalize() throws Throwable {
		try {
			System.out.println("GC is WORKING!");
			System.out.println("Number of nodes to remove is: "+ this.size); 
			this.removeAll(); 
		} finally {
			super.finalize();
		}
	}

	
	/***************************************************************/
	/* PRIVATE CLASS FOR nodes in the singly linked list: SNode<E> */
	/***************************************************************/
	private static class SNode<E>  {
		private E element; 
		private SNode<E> next; 
		public SNode() { 
			element = null; 
			next = null; 
		}
		public SNode(E data, SNode<E> next) { 
			this.element = data; 
			this.next = next; 
		}
		public SNode(E data)  { 
			this.element = data; 
			next = null; 
		}
		public E getElement() {
			return element;
		}
		public void setElement(E data) {
			this.element = data;
		}
		public SNode<E> getNext() {
			return next;
		}
		public void setNext(SNode<E> next) {
			this.next = next;
		}
		public void clean() { 
			element = null; 
			next = null; 
		}
	}

}
