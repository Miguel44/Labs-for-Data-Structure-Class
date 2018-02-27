package treeClasses;

import java.util.Comparator;

import positionalStructures.Position;
import treeClasses.LinkedBinaryTree.Node;

/**
 * Implementation of the AVL Binary Search Tree as a linked structure. The 
 * approach is to implement it as a subclass of LinkedBinaryTree. That
 * way, we will be able to reuse code from the LinkedBinaryTree, and 
 * from the AbstractTree classes. 
 * 
 * Here, each node holds an element of type E. Data type E represents 
 * a valid object data type satisfying an order relation compatible with
 * the comparator that is received by any created instance of the BST. 
 * 
 * 
 * @author pedroirivera-vega
 *
 * @param <E>
 */
public class LinkedAVL_BST<E> extends LinkedBinaryTree<E> {
	// The comparator that defines the order relation satisfied by objects of type E
	private Comparator<E> cmp; 

	/**
	 * The constructor.
	 * @param cmp the comparator
	 */
	public LinkedAVL_BST(Comparator<E> cmp) { 
		super();         // invoke default constructor of LinkedBinaryTree
		// to initialize inherited components

		this.cmp = cmp;  // the comparator
	}

	/**
	 * Adds a new element of type E to the tree. After insertion, the tree must continue being a bst. 
	 * In this case, elements in the bst can be repeated. A new position will be eventually created 
	 * holding the new element, and that node is then inserted at the correct location in the tree. 
	 * 
	 * @param e the new element
	 */
	public void addElement(E e) { 
		Node<E> newNode; 
		if (isEmpty()) {
			addRoot(e);    // in this case, the new position will become the root,  
		                   // and the only node of the tree		
			return;        // nothing else needs to be done
		}
		else {
			// in this case, traverse the tree in search of the right
		    // location where to put the new element’s position. 
		    // returns reference to the new node holding the new element e
			newNode = recInsert(root(), e);      
		
			// rebalance wherever needed on the critical path all the way up to the 
			// root of the tree. Return the final root of the tree once balanced. 
			// Note the the new node is not the root in this case; so, it has a parent
			root = upwardBalance(newNode); 
		}
	}


	// the following methods are used for restructuring the tree at some nodes
	// whenever rebalancing is needed. 
	//... NEED TO SEE IF IT CAN BE IMPROVED...
	protected void restructure(Node<E> a, Node<E> b, Node<E> c) { 
		
		Node<E> t2Root = (a.getParent() == b ? a.getRight() : b.getLeft());
		Node<E> t3Root = (c.getParent() == b ? c.getLeft() : b.getRight());

		attachRight(a, t2Root); 
		attachLeft(c, t3Root); 

		attachSubtrees(b, a, c); 
	}
	
	protected void attachSubtrees(Node<E> r, Node<E> left, Node<E> right) {
		r.setLeft(left); 
		r.setRight(right); 
		left.setParent(r);
		right.setParent(r);
		setHeight(r); 
	}

	protected void attachLeft(Node<E> r, Node<E> left) {
		r.setLeft(left); 
		if (left != null)
			left.setParent(r);
		setHeight(r); 		
	}

	protected void attachRight(Node<E> r, Node<E> right) {
		r.setRight(right); 
		if (right != null)
			right.setParent(r);
		setHeight(r); 		
	}

	protected void setHeight(Node<E> r) {
		int hl = (r.getLeft() != null ? r.getLeft().getNodeHeight() : -1); 
		int hr = (r.getRight() != null ? r.getRight().getNodeHeight() : -1);
		r.setNodeHeight(Math.max(hl, hr) + 1);
	}

	/**
	 * When the method begins execution the node received as parameter (z) is known
	 * to be unbalanced. Hence, node z is not null, it has at least one child, 
	 * and it also must have at least one grandson. The process will balance 
	 * node z and continue moving upward over the path from z to the root of
	 * the tree (path of ancestors of z) to check for more unbalanced nodes 
	 * and to recompute height of each subtree having root at nodes in that path. 
	 * @param z The unbalanced node from where the process begins. 
	 * PRE: z is not null and is unbalanced.
	 * @return the root of the final tree once verified, and rebalanced wherever 
	 * needed. 
	 */
	private Node<E> upwardBalance(Node<E> z) {
		Node<E> newRoot = null;      // this will hold the final root of the tree
		Node<E> y = null, x = null; 
		while (z != null) {   // the first time, z can't be null in this method

			// z is the root of the current subtree being analyzed upward in the critical path
			Node<E> zParent = z.getParent();   // preparing for the future...
			Node<E> a = null, b = null, c = null; 
			
			if (!balanced(z)) {

				boolean leftChild = false; 
				if (zParent != null && z == zParent.getLeft()) 
					leftChild = true; 
				// if leftChild is true, then z is the left child of its parent; otherwise, 
				// it is its right child. This is needed when the subtree with root at z
				// is rebalanced and its new root (possibly different from z) needs to be
				// attach as a child of its parent. That root will be to that parent the
				// new child in substitution of z; so, if z was the left (right) child, then  
				// the new root becomes the left (right) child of that parent node (zParent).

				// since z is unbalanced, then z has at least one grandson...
				y = tallestChild(z);    // y is the tallest child of z
				x = tallestChild(y);    // x is the tallest child of y

				// determine the order of elements in x, y, and z and let a, b, c represent
				// that order (a is the first of x, y, z that will be visited in an inorder, 
				// traversal of the tree, b will be the second, and c the last of the three).
				// See discussion about the 4 cases in the lab document.

				if (x == y.getLeft() && y == z.getLeft()) {          // case 1
					a = x; 
					b = y; 
					c = z; 
				} else if (x == y.getRight() && y == z.getLeft()) {  // case 2
					a = y; 
					b = x; 
					c = z; 
				} else if (x == y.getLeft() && y == z.getRight()) {  // case 3
					a = z; 
					b = x; 
					c = y; 
				} else {           // case 4
					a = z; 
					b = y; 
					c = x; 
				}
				restructure(a, b, c);   // restructure as in Fig 4 in document.....
				// b becomes the root, a its left child, and b its right child. 
				// Subtrees T1 and T2 become left/right subtrees of a; and subtrees
				// T3 and T4 become left/right subtrees of c
				if (zParent != null) {
					if (leftChild)
						attachLeft(zParent, b);   // attach to z the root 
					else
						attachRight(zParent, b); //y); 
					setHeight(zParent);
				}
				else newRoot = b;   // the root for the whole tree is b
			}
			else // z is balanced
				if (zParent != null) 
					setHeight(zParent); 
				else 
					newRoot = z;     // newRoot is the final root of the tree

			z = zParent; 
			// if z is null, the while loop will end -- the root hasb been reached; 
			// the tree is balanced.... Its final root is current newRoot
		} // closes while (z != null)

		// just in case, set the parent of the root to null
		newRoot.setParent(null);
		return newRoot;          // return root of the whole balanced tree
	}

	/**
	 * Internal private method. 
	 * Recursively look for the location where the new position with element e is to be inserted. 
	 * That new position will be inserted as a new leaf of the binary tree. 
	 * @param r root of the subtree where the insertion will take place.
	 * 
	 * @param e the new element to be added to the tree in a new position
	 */
	private Node<E> recInsert(Position<E> r, E e) {
		int c = cmp.compare(e, r.getElement()); 
		if (c < 0) 
			if (!hasLeft(r))
				return (Node<E>) addLeft(r, e); 
			else 
				return recInsert(left(r), e); 
		else 
			if (!hasRight(r))
				return (Node<E>) addRight(r, e); 
			else 
				return recInsert(right(r), e); 		
	}

	/**
	 * Internal private method. 
	 * Search for a position whose element matches the element being searched for
	 * @param r the root of the subtree where the search is done
	 * @param e the element to search for. This parameter refers to an object of type E 
	 * which have at least enough information to be able to compare with existing elements
	 * in the tree and distinguish which element in the tree matches the search.
	 * @return reference to a position in the tree containing a matching element. If none is 
	 * found, then it returns null. 
	 */
	private Position<E> findPosition(Position<E> r, E e) { 
		if (r == null) return null; 
		int c = cmp.compare(e, r.getElement()); 
		if (c == 0) return r; 
		if (c < 0) return findPosition(left(r), e); 
		return findPosition(right(r), e);
	}

	/**
	 * 
	 * @param e
	 * @return
	 */
	public Position<E> getPosition(E e) { 
		return findPosition(root(), e); 
	}

	/**
	 * Removes element e from the tree, and also one position. The
	 * position being removed is not necessarily the same position 
	 * where e is located. But the only element to be removed is e
	 * and the tree will continue satisfying the binary search tree
	 * fundamental property. 
	 * 
	 * @param e the element to be removed. It is presumed that e 
	 * contains at least whatever internal data is necessary
	 * to successfully compare with existing objects. 
	 *  
	 * @return the whole version of e as contained in the tree
	 * if it is the case that a matching element is found, and
	 * successfully removed. If no element is found, it returns null. 
	 */
	public E removeElement(E e) { 
		Position<E> pos = findPosition(root(), e); 

		Position<E> parentPos = null; 

		if (pos == null) return null; 

		// Element To Return, the actual element in the tree that matches the searh criteria
		E etr = pos.getElement(); 

		// Initiate the action to delete a position. The position finally deleted will be pos, only 
		// if pos has at most one child; otherwise, if pos has more than one child, the position to be 
		// finally removed will be the position containing the element that immediately follows element e
		// in order in the tree (the successor of e in the tree). That successor element will be moved to 
		// position pos, replacing the value there; which is the value to delete! ... 
		// The method returns reference to the parent node of the node that is finally physically
		// removed from the tree.
		parentPos = deletePosition(pos); 
		
		// if parentPos == null, then the physically removed node was the root of the tree. 
		// Then the new root, if any, is whatever was the only child of that root; hence, the
		// tree is balanced and no further actions are required. If parentPost != null, then
		// we still need to explore the critical path upwards in order to rebalance wherever
		// needed and to recompute height of nodes whose height could be altered by the removal
		// (or that can be altered during the rebalancing process)
		if (parentPos != null) {    
			setHeight((Node<E>) parentPos); 
			root = upwardBalance((Node<E>) parentPos); 
		}
		return etr;     // returns a full copy of e as it is in the tree.
	}


	/**
	 * Finds the tallest child of a given node.
	 * @param r the node to which the tallest child is to be found
	 * @return reference to the tallest child of r
	 */
	private Node<E> tallestChild(Node<E> r) {
		int hLeft = -1, hRight = -1; 
		if (hasLeft(r))
			hLeft = r.getLeft().getNodeHeight();
		if (hasRight(r))
			hRight = r.getRight().getNodeHeight(); 
		if (hLeft > hRight) 
			return r.getLeft(); 
		else 
			return r.getRight(); 
	}

	/**
	 * Determines if a given node is balanced as per the AVL definition.
	 * @param r the node to be tested
	 * @return true or false....
	 */
	public boolean balanced(Node<E> r) {
		return (Math.abs(balanceOf(r)) <= 1); 	
	}
	
	/**
	 * Returns the balance factor of a given node....
	 * @param r the node to test
	 * @return -1, 0 or 1
	 */
	public int balanceOf(Node<E> r) {
		int hLeft = (r.getLeft() == null ? -1 : r.getLeft().getNodeHeight()); 
		int hRight = (r.getRight() == null ? -1 : r.getRight().getNodeHeight()); 
		return hLeft - hRight; 
	}
	
	/**
	 * Internal private method. 
	 * Initiates the removal of a position. That position is physically removed only
	 * if it has at most one child. If it has more than one child, then its element
	 * is replaced by the successor element in the tree and the node containing that
	 * successor element (since it will have at most one child) is the one to be
	 * physically removed from the tree. This process will also guarantee that the
	 * tree continues being a binary search tree. 
	 * @param pos the position that contains the element that matches the one to be
	 * removed from the collection represented by the tree elements. 
	 * @return reference to the parent of the physically removed position; which is
	 * null if that position was the root of the tree.
	 */
	private Position<E> deletePosition(Position<E> pos) {
		Position<E> parent = this.parent(pos); 
		if (left(pos) == null || right(pos) == null) { 
			// In this case, position pos has at most one child. Hence, pos itself
			// will be the position removed from the tree. For that, just apply the
			// remove operation that is inherited from LinkedBinaryTree. 
			remove(pos);       // inherited from LinedBinaryTree (see remove in that class)
		}
		else {
			// pos has two children. Find the position containing the element
			// in the tree that, in the order given, should go immediately after
			// the element in pos. In this case, that element is the minimum 
			// element in the right subtree of pos. 
			Position<E> smallest = findSmallestPosition(right(pos));  

			// smallest is now the position in the tree that contains the
			// successor of pos.getElement(). Note that by property of the
			// binary search tree, position smallest has no left child; it
			// has at most only a right child. 

			// copy that successor element to position pos. 
			pos.setElement(smallest.getElement());

			// rectify parent node of the physically removed node...
			parent = this.parent(smallest); 
			
			// apply the inherited method from LinkedBinaryTree to remove position
			// smallest. Since smallest has at most only one child (the right child), 
			// the remove should work without any problem (See remove method in class
			// LinkedBinaryTree.
			remove(smallest);   // remove method that is inherited from LinkedBinaryTree
		}
		
		// return reference to parent node of the node that is physically removed from
		// the tree
		return parent; 
	}


	/**
	 * Internal private method. 
	 * Find the smallest element in the binary search tree whose
	 * root is given. It is assumed the the tree is not empty.
	 * 
	 * @param r the root of the tree (or subtree) to explore. 
	 * PRE: r != null  
	 * 
	 * @return reference to the position in the tree with root
	 * r containing the smallest element in that subtree. Notice
	 * that to find such position we just need to move, beginning
	 * at r, all the way to the left until we find the first node  
	 * that does not have left child. That node will contain the
	 * smallest element in the binary search tree rooted a r. 
	 * This is so because of the binary search tree property. 
	 */
	private Position<E> findSmallestPosition(Position<E> r) {
		while (left(r) != null) 
			r = left(r); 
		return r;
	}
	
	protected void recDisplay(Position<E> r, 
			int[] control, int level) 
	{
		printPrefix(level, control); 
		System.out.println(); 
		printPrefix(level, control); 
		Position<E> parent = parent(r); 
		if (parent != null) 
			if (left(parent) == r)
				System.out.print("__L("+r.getElement()+")");
			else 
				System.out.print("__R("+r.getElement()+")");
		else 
			System.out.print("__ROOT("+r.getElement()+")");
		System.out.println(":BALANCE = " + balanceOf((Node<E>) r) + 
				" HEIGHT = " + ((Node<E>) r).getNodeHeight()); 
		control[level]--; 
		int nc = this.numChildren(r); 
		control[level+1] = nc; 
		for (Position<E>  p : this.children(r)) {
			recDisplay(p, control, level+1);  
		}
	}

}