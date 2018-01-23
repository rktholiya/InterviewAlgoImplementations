package trees.common.parent.binary.tree;

public class Node {
	int value;
	Node right;
	Node left;
	
	public Node(Integer value, Node right, Node left) {
		super();
		this.value = value;
		this.right = right;
		this.left = left;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	@Override
	public String toString() {
		return "Node [value=" + value + ", right=" + right + ", left=" + left + "]";
	}
	
}
