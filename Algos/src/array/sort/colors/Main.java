package array.sort.colors;

public class Main {

	public static void main(String[] args) {
		int[] multicolors = { 0, 1, 1, 2, 1, 2, 1, 0, 1, 2, 0, 0, 0 };
		System.out.println("Before");
		printArray(multicolors);
		multicolors = sortColors(multicolors);
		System.out.println("After");
		printArray(multicolors);
	}

	/**
	 * Have three counters, one at the beginning and two at the end. start with
	 * beginning and one of the end counter and make sure 0 is at the beginning
	 * and non zeros after them. Once these two pointers cross each other start
	 * the second end counter at the end and do same for second element till p1
	 * and p3 crosses.
	 * 
	 * @param multicolors
	 * @return
	 */
	public static int[] sortColors(int[] multicolors) {
		int p1 = 0, p2 = multicolors.length - 1, p3 = multicolors.length - 1;
		while (p1 <= p3) {
			if (p1 <= p2) {
				while (multicolors[p1] == 0) {
					p1++;
				}
				while (multicolors[p2] != 0) {
					p2--;
				}
				if (p1 <= p2) {
					// swap numbers
					int tmp = multicolors[p1];
					multicolors[p1] = multicolors[p2];
					multicolors[p2] = tmp;
				}
			} else {
				// all 0's are at beginning start the other pointer
				if (p1 <= p3) {
					while (multicolors[p1] == 1) {
						p1++;
					}
					while (multicolors[p3] != 1) {
						p3--;
					}
					if (p1 <= p3) {
						int tmp = multicolors[p1];
						multicolors[p1] = multicolors[p3];
						multicolors[p3] = tmp;
					}
				}
			}
		}
		return multicolors;
	}

	public static void printArray(int[] multicolors) {
		for (int i : multicolors) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
