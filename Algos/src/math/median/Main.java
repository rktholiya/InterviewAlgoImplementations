package math.median;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	static Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

	static Queue<Integer> minHeap = new PriorityQueue<Integer>();

	public static void main(String[] args) {
		Integer[] numbers = { 3, 13, 7, 5, 21, 23, 23, 40, 23, 14, 12, 56, 23, 29 };
		for (Integer num : numbers) {
			addNumber(num);
		}
		System.out.println("Median: "+getMedian());
	}

	public static void addNumber(Integer num) {
		if (maxHeap.size() == minHeap.size() && maxHeap.size() != 0) {
			if (num > minHeap.peek()) {
				maxHeap.offer(minHeap.poll());
				minHeap.offer(num);
			} else {
				maxHeap.offer(num);
			}
		} else {
			if (maxHeap.size() > minHeap.size()) {
				minHeap.offer(num);
			} else {
				maxHeap.offer(num);
			}
		}

	}

	public static int getMedian() {
		if (minHeap.size() > maxHeap.size()) {
			return minHeap.peek();
		}else if(minHeap.size() < maxHeap.size()){
			return maxHeap.peek();
		}else{
			return (maxHeap.peek() + minHeap.peek())/2;
		}
	}
}
