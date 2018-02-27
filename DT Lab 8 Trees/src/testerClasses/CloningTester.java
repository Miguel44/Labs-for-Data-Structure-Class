package testerClasses;

import labUtils.Utils;
import treeClasses.LinkedTree;

public class CloningTester {

	public static void main(String[] args) throws CloneNotSupportedException {
		LinkedTree<Integer> linkedTree = new LinkedTree<>();
		LinkedTree<Integer> clonedLT = null;
		try{ clonedLT = linkedTree.clone(); }
		catch(Exception e){ e.printStackTrace(); }
		linkedTree = Utils.buildExampleTreeAsLinkedTree();
		clonedLT = linkedTree.clone();	
		Utils.displayTree("The tree is: ", clonedLT); 

		LinkedTree<Integer> linkedBinaryTree = new LinkedTree<>();
		LinkedTree<Integer> clonedLBT = null;
		try{ clonedLBT = linkedBinaryTree.clone(); }
		catch(Exception e){ e.printStackTrace(); }
		linkedBinaryTree = Utils.buildExampleTreeAsLinkedTree();
		clonedLBT = linkedBinaryTree.clone();	
		Utils.displayTree("The tree is: ", clonedLBT);
	}

}
