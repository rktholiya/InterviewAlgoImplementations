package linkedlist.merge.sorted.list;

import linkedlist.reverse.list.Node;

public class Main {
	public static void main(String[] args) {
		Node list1 = new Node(String.valueOf(3), null);
		Node list2 = new Node(String.valueOf(4), null);
		
		int[] nums1 = {5, 8, 9, 10, 12};
		int[] nums2 = {6, 8, 9, 15};
		
		for(int number : nums1){
			linkedlist.reverse.list.Main.buildTree(list1, number);
		}
		System.out.println("List1: "+ list1);
		
		for(int number : nums2){
			linkedlist.reverse.list.Main.buildTree(list2, number);
		}
		System.out.println("List1: "+ list2);
		
		mergeList(list1, list2);
	}
	
	public static void mergeList(Node list1, Node list2){
		Node result = list1;
		while(true){
			int val1 = Integer.valueOf(list1.getValue());
			int val2 = Integer.valueOf(list2.getValue());
			Node previous = null;
			while( val1 <= val2){
				previous = list1;
				if(null != list1.getNext()){
					list1 = list1.getNext();
					val1 = Integer.valueOf(list1.getValue());
					val2 = Integer.valueOf(list2.getValue());
				}
			}
			
			System.out.println("Previous: "+previous.getValue());
			System.out.println("List1: "+list1.getValue());
			System.out.println("List2: "+list2.getValue());
			System.out.println("Result: "+result);
			//put element in b/w
			previous.setNext(list2);
			list2.setNext(list1);
			
			list1 = list2;
			list2 = list2.getNext();
		}
	}

}
