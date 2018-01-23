package linkedlist.reverse.list;

public class Main {

	public static void main(String[] args) {
		int[] numbers = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		Node root = new Node(String.valueOf(1), null);
		for (int number : numbers) {
			buildTree(root, number);
		}
		System.out.println("Linkelist: " + root);
		Node reverseRoot = rotateRecursive(root);

		System.out.println("Reverse Linkedlist Recursive: " + reverseRoot);

		root = new Node(String.valueOf(1), null);
		for (int number : numbers) {
			buildTree(root, number);
		}

		System.out.println("Reverse Linkedlist Iterative: " + rotateIterative(root));

		root = new Node(String.valueOf(1), null);
		for (int number : numbers) {
			buildTree(root, number);
		}
		System.out.println("Reverse Linkedlist Iterative in Group:" + rotateIterative(root, 3));
	}

	public static void buildTree(Node root, int number) {
		while (root.getNext() != null) {
			root = root.getNext();
		}
		root.setNext(new Node(String.valueOf(number), null));
	}

	/**
	 * Recursive
	 * 
	 * @param root
	 * @return
	 */
	public static Node rotateRecursive(Node root) {
		Node nxt = root.getNext();
		Node nxt2nxt = root.getNext().getNext();
		Node newRoot = null;
		if (nxt2nxt != null) {
			newRoot = rotateRecursive(nxt);
		}
		root.setNext(null);
		nxt.setNext(root);
		if (nxt2nxt == null) {
			return nxt;
		}
		return newRoot;
	}

	/**
	 * Iterative
	 * 
	 * @param root
	 * @return
	 */
	public static Node rotateIterative(Node root) {
		Node nxt = root.getNext();
		Node nxt2nxt = nxt.getNext();
		root.setNext(null);
		while (nxt != null) {
			nxt.setNext(root);
			root = nxt;
			nxt = nxt2nxt;
			if (nxt2nxt != null)
				nxt2nxt = nxt2nxt.getNext();
			else {
				return root;
			}
		}
		return null;
	}

	/**
	 * Iterative in group
	 * 
	 * @param root
	 * @return
	 */
	public static Node rotateIterative(Node root, int groupSize) {
		int i = 0;
		Node start = root;
		Node result = null;
		while (root != null) {
			if (((i + 1) % groupSize) == 0) {
				// set new start
				Node tmpstart = root.getNext();
				root.setNext(null);
				start = rotateIterative(start);
				if (null == result) {
					result = start;
				} else {
					Node tmpResult = result;
					while (result.getNext() != null) {
						result = result.getNext();
					}
					result.setNext(start);
					result = tmpResult;
				}
				start = tmpstart;
				root = start;
			}else{
				root = root.getNext();
			}
			i++;
		}
		return result;
	}
}
