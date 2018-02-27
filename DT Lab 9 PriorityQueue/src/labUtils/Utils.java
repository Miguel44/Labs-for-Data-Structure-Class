package labUtils;

import positionalStructures.Position;
import treeClasses.LinkedBinaryTree;
import treeClasses.LinkedTree;
import treeInterfaces.Tree;

public class Utils {
	public static <E> void displayTree(String msg, Tree<E> t) { 
		System.out.println("\n\n" + msg); 
		t.display(); 
	}

	public static <E> void displayTreeElements(String msg, Tree<E> t) {
		System.out.println("\n\n" + msg); 
		for (E element : t)
			System.out.println(element); 
		
	}
	
	public static LinkedTree<Integer> buildExampleTreeAsLinkedTree() { 
		LinkedTree<Integer> t = new LinkedTree<>(); 
		Position<Integer> p = t.addRoot(4); 
		p = t.addChild(p, 9); 
		t.addChild(p, 7); 
		t.addChild(p, 10); 
		p = t.root(); 
		p = t.addChild(p, 20); 
		Position<Integer> q = t.addChild(p, 15); 
		t.addChild(q, 12); 
		q=t.addChild(q, 17); 
		t.addChild(q, 19);
		p = t.addChild(p, 21); 
		p = t.addChild(p, 40); 
		t.addChild(p, 30); 
		t.addChild(p, 45); 

		return t; 
	}
	
	public static LinkedBinaryTree<Integer> buildExampleTreeAsLinkedBinaryTree() { 
		LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>(); 
		
		Position<Integer> p = t.addRoot(4); 
		p = t.addLeft(p, 9); 
		t.addLeft(p, 7); 
		t.addRight(p, 10); 
		p = t.root(); 
		p = t.addRight(p, 20); 
		Position<Integer> q = t.addLeft(p, 15); 
		t.addLeft(q, 12);
		q = t.addRight(q, 17); 
		t.addLeft(q, 19); 
		p = t.addRight(p, 21); 
		p = t.addRight(p, 40); 
		t.addLeft(p, 30); 
		t.addRight(p, 45); 
		
		return t; 
	}


}
