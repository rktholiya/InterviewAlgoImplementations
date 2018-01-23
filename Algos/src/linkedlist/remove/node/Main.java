package linkedlist.remove.node;

import linkedlist.reverse.list.Node;

public class Main {
	
	public static void main(String[] args) {
		Node root = new Node(String.valueOf(1), null);
		int[] numbers = {2,3,4,5};
		for(int number : numbers){
			linkedlist.reverse.list.Main.buildTree(root, number);
		}
		System.out.println("LinkedList: "+root);
		
		Node remove = new Node(String.valueOf(4), null);
		
		removeNode(root, remove);
		
		System.out.println("After removal: "+root);
	}
	
	public static void removeNode(Node root, Node remove){
		while(!root.getValue().equals(remove.getValue())){
			root = root.getNext();
			if(null == root){
				return;
			}
		}
		root.setValue(root.getNext().getValue());
		root.setNext(root.getNext().getNext());
	}

}
