package queue;

public class SLLQueue<E> implements Queue<E> {
	private static class Node<E> {   // Inner class for nodes. 
		private E element; 
		private Node<E> next; 
		
		public Node(E e) {
			element = e;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
		public E getElement() {
			return element;
		}
	
	}
	private Node<E> first, last;   // references to first and last node
	private int size; 
	
	public SLLQueue() {           // initializes instance as empty queue
		first = last = null; 
		size = 0; 
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public E first() {
		if (isEmpty()) return null;
		return first.getElement(); 
	}
	public E dequeue() {
		if (isEmpty()) return null;	
		E etr = first.getElement();
		first = first.getNext();
		size--;
		return etr;
		 
	}
	public void enqueue(E e) {
		Node<E> newNode = new Node<E>(e);
		if (size == 0) 
			first = last = newNode;
		else 
		last.setNext(newNode);
		last = newNode;	
		
		size++; 
	}


	@Override
	public void showReverse() { 
	    if (size == 0)
		   System.out.println("Queue is empty."); 
		else
		   recSR(first);
    } 
    private void recSR(Node<E> f) { 
		if (f != null) { 
		   recSR(f.getNext()); 
		   System.out.println(f.getElement()); 
	     } 
    } 

}
