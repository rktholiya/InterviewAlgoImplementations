package trees.common.parent.binary.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ravindra
 *
 */
public class Main {
	/**
	 * Build binary search tree with given list of integers
	 * 
	 * @param numbers
	 * @return
	 */
	public static Node buildTree(List<Integer> numbers) {
		Node root = new Node(numbers.get(0), null, null);
		for (int i = 1; i < numbers.size(); i++) {
			addToTree(numbers.get(i), root);
		}
		return root;
	}

	/**
	 * Add a node to binary search tree starting from root
	 * 
	 * @param number
	 * @param root
	 */
	public static void addToTree(Integer number, Node root) {
		if (number > root.getValue()) {
			if (root.getRight() == null) {
				root.setRight(new Node(number, null, null));
			} else {
				addToTree(number, root.getRight());
			}
		} else {
			if (root.getLeft() == null) {
				root.setLeft(new Node(number, null, null));
			} else {
				addToTree(number, root.getLeft());
			}
		}
	}

	/**
	 * Returns common ancestor node for left and right nodes First node having
	 * left on left and right on right side is the common ancestor. Logic
	 * recursively calls itself till both nodes lies on one side of the node.
	 * 
	 * @param root
	 * @param left
	 * @param right
	 * @return common ancestor node for left and right nodes
	 */
	public static Node findCommonAncestor(Node root, Node left, Node right) {
		if (!inSubtree(root, left) || !inSubtree(root, right)) {
			return null;
		}
		if (inSubtree(root.getLeft(), left) && inSubtree(root.getLeft(), right)) {
			return findCommonAncestor(root.getLeft(), left, right);
		}

		if (inSubtree(root.getRight(), left) && inSubtree(root.getRight(), right)) {
			return findCommonAncestor(root.getRight(), left, right);
		}
		return root;
	}

	/**
	 * Checks if a node is present in subtree starting from root node.
	 * 
	 * @param root
	 * @param n
	 * @return true/false based on presence of node in subtree
	 */
	public static boolean inSubtree(Node root, Node n) {
		if (root == null) {
			return false;
		} else if (root.getValue() == n.getValue()) {
			return true;
		} else {
			return inSubtree(root.getLeft(), n) || inSubtree(root.getRight(), n);
		}
	}

	/**
	 * Problem: Design an algorithm and write code to find the first common
	 * ancestor of two nodes in a binary tree. Avoid storing additional nodes in
	 * a data structure.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		10
//		 |
//    |   |
//    2   11
//	    |     |     
//	    5      16
//    | |    |  |
//   4  8   14 19
		List<Integer> numbers = new ArrayList<>();
		numbers.add(10);
		numbers.add(11);
		numbers.add(2);
		numbers.add(5);
		numbers.add(8);
		numbers.add(4);
		numbers.add(16);
		numbers.add(14);
		numbers.add(19);

		Node root = buildTree(numbers);
		System.out.println(findCommonAncestor(root, new Node(14, null, null), new Node(19, null, null)));
	}

}
