package bitmanipulation.next.largest.smallest.number;

public class Main {
	/**
	 * Given an integer, print the next largest and smallest number
	 * that have the same number of 1 bits in their binary representation.
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length > 0){
			System.out.println("Next largest number: "+nextLargestNumber(Integer.parseInt(args[0])));
			System.out.println("Next smallest number: "+nextSmallestNumber(Integer.parseInt(args[0])));
		}else{
			System.out.println("Next largest number for: "+nextLargestNumber(Integer.parseInt("21")));
			System.out.println("Next smallest number: "+nextSmallestNumber(Integer.parseInt("21")));
		}
		
	}
	
	/**
	 * Return a 32 bit char array representing binary for a given number
	 * @param binaryChars
	 * @return
	 */
	public static char[] get32BitRepresentation(Integer number){
		char[] binaryChars = Integer.toBinaryString(number).toCharArray();
		if(binaryChars.length == 32 && binaryChars[0] == '1'){
			//Negative number
		}
		else{
			char[] tmp = new char[32];
			int i=0,j=0;
			while(i<32){
				if(i < (32 - binaryChars.length)){
					tmp[i] = '0';
				}else{
					tmp[i] = binaryChars[j];
					j++;
				}
				i++;
			}
			binaryChars = tmp;
		}
		return binaryChars;
	}
	
	/**
	 * Next largest number can be obtained by converting first 0 to 1 which follows
	 * 1's when moving right to left and converting last such one to 0 after which rearranging 
	 * all ones to get the smallest value possible
	 * @param number
	 * @return
	 */
	public static Integer nextLargestNumber(Integer number){
		
		char[] binaryChars = get32BitRepresentation(number);
		int i=binaryChars.length - 1;
		for(;i >= 0;i--){
			if(i > 0 && binaryChars[i] == '1' && binaryChars[i-1] == '0'){
				//Swap char at i with at i-1
				char tmp = binaryChars[i];
				binaryChars[i] = binaryChars[i-1];
				binaryChars[i-1] = tmp;
				int j = i;
				int k = binaryChars.length - 1;
				while(j <= k){
					if(binaryChars[j] == '1' && binaryChars[k] == '0'){
						tmp = binaryChars[j];
						binaryChars[j] = binaryChars[k];
						binaryChars[k] = tmp;
						j++;
						k--;
					}
					if(binaryChars[j] != '1'){ j++; }
					if(binaryChars[k] != '0'){ k--; }
					
				}
				break;
			}
		}
		return Integer.parseInt(new String(binaryChars), 2);
	}
	
	public static Integer nextSmallestNumber(Integer number){
		char[] binaryChars = get32BitRepresentation(number);
		int i=binaryChars.length - 1;
		for(;i >= 0;i--){
			if(i > 0 && binaryChars[i] == '0' && binaryChars[i-1] == '1'){
				//Swap char at i with at i-1
				char tmp = binaryChars[i];
				binaryChars[i] = binaryChars[i-1];
				binaryChars[i-1] = tmp;
				int j = i;
				int k = binaryChars.length - 1;
				while(j <= k){
					if(binaryChars[j] == '0' && binaryChars[k] == '1'){
						tmp = binaryChars[j];
						binaryChars[j] = binaryChars[k];
						binaryChars[k] = tmp;
						j++;
						k--;
					}
					if(binaryChars[j] != '0'){ j++; }
					if(binaryChars[k] != '1'){ k--; }
					
				}
				break;
			}
		}
		return Integer.parseInt(new String(binaryChars), 2);
	}
}
