package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import linkedLists.LinkedList;
import linkedLists.SLList.SNode;

public class SLFLList<E> 
implements LinkedList<E>
{

	private SNode<E> first, last; 
	int length = 0; 
	
	public SLFLList() { 
		first = last = null; 
	}
	
	
	public void addFirstNode(Node<E> nuevo) {
	      ((SNode<E>) nuevo).setNext(first);
	      first = (SNode<E>) nuevo;
	      addLast(first.getNext());
	      
	      length++;
		// TODO Auto-generated method stub
		
	}
	public void addLast(Node<E> nuevo){
		((SNode<E>) nuevo).setNext(null);
		
		last = (SNode<E>) nuevo;
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		((SNode<E>) nuevo).setNext(((SNode<E>) target).getNext()); 
		((SNode<E>) target).setNext((SNode<E>) nuevo); 									
		length++; 
		 
		// TODO Auto-generated method stub
		
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		if (target == first)
			this.addFirstNode(nuevo); 
		else { 
			Node<E> prevNode = first ; 
			while(((SNode<E>)prevNode).getNext()!=target && prevNode!=null){
				((SNode<E>)prevNode).getNext();
				}
			this.addNodeAfter(prevNode, nuevo); 
		}
				
	}

	public Node<E> getFirstNode() throws NodeOutOfBoundsException {
		if (first == null)
			throw new NodeOutOfBoundsException("getFirstNode() : linked list is empty..."); 
		

		return first;
	}

	public Node<E> getLastNode() throws NodeOutOfBoundsException {
		if (first == null)
			throw new NodeOutOfBoundsException("getLastNode() : linked list is empty...");
		return last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NodeOutOfBoundsException {
		SNode<E> afterNode = ((SNode<E>) target).getNext(); 
		if (afterNode == null)  
			throw new NodeOutOfBoundsException("getNextNode(...) : target is the last node."); 
		else
		return afterNode;
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NodeOutOfBoundsException {
		if (target == first)  
			throw new NodeOutOfBoundsException("getPrevNode(...) : target is the first node."); 
		else {
		SNode<E> beforeNode = first;
		while(target != beforeNode){
			beforeNode = beforeNode.getNext();
		}
	
		return beforeNode;
		}
	}

	public int length() {
		
		return this.length;
	}

	public void removeNode(Node<E> target) {
		if (target == first) {
			// the list is not empty....
			SNode<E> ntr = first; 
			first = first.getNext(); 
			ntr.setNext(null);      // notice that the node keeps its data..
		}
		else if(target == last){
			this.addLast(this.getNodeBefore(target));
		}
		else { 
			SNode<E> prevNode = (SNode<E>) this.getNodeBefore(target); 
			prevNode.setNext(((SNode<E>) target).getNext()); 
		}
		length--; 
		
	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}


	///////////////////////////////////////////////////
	// private and static inner class that defines the 
	// type of node that this list implementation uses
	private static class SNode<T> implements Node<T> {
		private T element; 
		private SNode<T> next; 
		public SNode() { 
			element = null; 
			next = null; 
		}
		public SNode(T data, SNode<T> next) { 
			this.element = data; 
			this.next = next; 
		}
		public SNode(T data)  { 
			this.element = data; 
			next = null; 
		}
		public T getElement() {
			return element;
		}
		public void setElement(T data) {
			this.element = data;
		}
		public SNode<T> getNext() {
			return next;
		}
		public void setNext(SNode<T> next) {
			this.next = next;
		}
	}

}
