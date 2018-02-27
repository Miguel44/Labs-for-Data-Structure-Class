package queue;

public interface Queue<E> {
	int size();
	boolean isEmpty(); 
	E first(); 
	E dequeue(); 
	void enqueue(E e);
	//just for testing
	void showReverse(); 
}
