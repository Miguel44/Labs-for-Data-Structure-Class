package treeClasses;

import java.util.ArrayList;

import treeInterfaces.Position;
import treeInterfaces.Tree;

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
	 public static Iterable<Integer> theValues(Tree<Integer> t) { 
         ArrayList<Integer> result = new ArrayList<>(); 
         if (!t.isEmpty()) 
            genValues(t, t.root(), 0, result); 
         return result;
  } 
	 private static void genValues(Tree<Integer> t, Position<Integer> r, Integer pathValue, 
             ArrayList<Integer> result) { 
		 if(t.isExternal(r)){
			 pathValue+= r.getElement();
			 result.add(pathValue);
		 }else
			 pathValue+= r.getElement();
		 for(Position<Integer> p : t.children(r)){
			 genValues(t,p,pathValue,result);
		 }
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