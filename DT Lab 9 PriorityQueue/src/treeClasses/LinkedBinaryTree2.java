package treeClasses;

import positionalStructures.Position;

public class LinkedBinaryTree2<E extends Comparable<E>> extends AbstractBinaryTree<E> {

	private LinkedBinaryTree<E> t = new LinkedBinaryTree<>(); 
	
	public void insert(E e) { 
		if (isEmpty())
			t.addRoot(e); 
		else
			recInsert(t.root(), e); 
	}

	private void recInsert(Position<E> r, E e) {
		int c = e.compareTo(r.getElement()); 
		if (c < 0) 
			if (!t.hasLeft(r))
				t.addLeft(r, e); 
			else 
				recInsert(t.left(r), e); 
		else 
			if (!t.hasRight(r))
				t.addRight(r, e); 
			else 
				recInsert(t.right(r), e); 		
	}

	@Override
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		return t.left(p);
	}

	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		return t.right(p);
	}

	@Override
	public Position<E> root() {
		return t.root();
	}

	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		return t.parent(p);
	}

	@Override
	public int size() {
		return t.size();
	}
}