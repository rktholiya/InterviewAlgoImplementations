package multi.dimentional.array.rotate;

public class Main {
	
	public static int[][] matrix = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13, 14, 15, 16}
	};
	
	public static void main(String[] args) {
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("...After rotation...");
		matrix = rotate(matrix, matrix.length);
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] rotate(int[][] matrix, int n){
		/**
		 * {1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13, 14, 15, 16}
		 */
		int start = 0, end = n-1;
		while(start < end){
			for(int i=start;i<=end;i++){
				for(int j=start;j<=end;j++){
					int tmp = matrix[i][j];
//					matrix[i][j] = matrix[n-1-j][i];
//					matrix[n-1-j][i] = matrix[end][n-1-j];
					matrix[end][n-1-j] = matrix[j][n-1-end];
				}
				break;
			}
			start++;
			end--;
		}
		return matrix; 
	}

}
