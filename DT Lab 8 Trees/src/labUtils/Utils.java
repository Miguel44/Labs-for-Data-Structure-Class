package labUtils;

import treeClasses.LinkedBinaryTree;
import treeClasses.LinkedTree;
import treeInterfaces.Position;
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
		Position<Integer> root = t.addRoot(4);
		// root children
		Position<Integer> parent1L = t.addChild(root, 9);
		Position<Integer> parent2R = t.addChild(root, 20);
		// parent1L children:
		 t.addChild(parent1L, 7);
		 t.addChild(parent1L, 10);
		 //parent2R 1L children:
		Position<Integer> p2cL = t.addChild(parent2R, 15);
		Position<Integer> p2cR = t.addChild(parent2R, 21);
		// p2cL children:
		 t.addChild(p2cL, 12);
		Position<Integer> p21cL = t.addChild(p2cL, 17);
		// p21cL child: 
		 t.addChild(p21cL, 19);
		// p2cR child:
		Position<Integer> p22cL = t.addChild(p2cR, 40);
		//p22cL child
		 t.addChild(p22cL, 30);
		 t.addChild(p22cL, 45);
		
		
		return t; 
	}
	
	public static LinkedBinaryTree<Integer> buildExampleTreeAsLinkedBinaryTree() { 
		LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>(); 
		Position<Integer> root = t.addRoot(4);
		// root children:
		Position<Integer> parent1L = t.addLeft(root, 9);
		Position<Integer> parent2R = t.addRight(root, 20);
		// parent1L children:
		   t.addLeft(parent1L, 7);
		   t.addRight(parent1L, 10);
		   //parent2R 1L children:
		Position<Integer> p2cL = t.addLeft(parent2R, 15);
		Position<Integer> p2cR = t.addRight(parent2R, 21);
		// p2cL children:
		t.addLeft(p2cL, 12);
		Position<Integer> p21cL = t.addRight(p2cL, 17);
		// p21cL child: 
		   t.addLeft(p21cL, 19);
		// p2cR child:
		Position<Integer> p22cL = t.addRight(p2cR, 40);
		//p22cL child
		   t.addLeft(p22cL, 30);
		   t.addRight(p22cL, 45);
		
		
		return t; 
	}


}
