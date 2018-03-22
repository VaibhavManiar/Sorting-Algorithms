package me.practice.algo.matrix;

public class FindMatrixCost {
	
	int[][] minCostMatrix;
	int[][] maxCostMatrix;
	
	int[][] minOppCostMatrix;
	
	public int minCost(int x, int y, int[][] matrix) {
		if(matrix.length <= 0 || matrix[0].length <= 0)
			return -1;
		
		if(x >= matrix.length || y >= matrix[0].length)
			return -1;
		
		int n = matrix.length - 1;
		int m = matrix[0].length - 1;
		
		minCostMatrix = this.setMatrixDefaultValue(new int[matrix.length][matrix[0].length]);
		minCostMatrix[0][0] = matrix[0][0];
		
		/* Initialize first col of minCostMatrix array */
		for (int i = 1; i <= m; i++)
			minCostMatrix[i][0] = minCostMatrix[i-1][0] + matrix[i][0];
	 
	     /* Initialize first row of minCostMatrix array */
	     for (int j = 1; j <= n; j++)
	    	 minCostMatrix[0][j] = minCostMatrix[0][j-1] + matrix[0][j];
	 
	     /* Construct rest of the minCostMatrix array */
	     for (int i = 1; i <= m; i++)
	        for (int j = 1; j <= n; j++)
 	        	minCostMatrix[i][j] = min(/*minCostMatrix[i-1][j-1], */
	        			minCostMatrix[i-1][j], 
	        			minCostMatrix[i][j-1]) + matrix[i][j];
		
		return minCostMatrix[x][y];
	}
	
	public int minOppositCost(int x, int y, int[][] matrix) {
		if (matrix.length <= 0 && matrix[0].length <= 0)
			return -1;
		int n = matrix.length - 1;
		int m = matrix[0].length - 1;

		minOppCostMatrix = this.setMatrixDefaultValue(new int[matrix.length][matrix[0].length]);
		minOppCostMatrix[matrix.length - 1][matrix[0].length - 1] = matrix[matrix.length - 1][matrix[0].length - 1];

		/* Initialize first col of minCostMatrix array */
		for (int i = m; i >= 1; i--)
			minOppCostMatrix[i - 1][m] = matrix[i - 1][m] + minOppCostMatrix[i][m];

		/* Initialize first row of minCostMatrix array */
		for (int j = n; j >= 1; j--)
			minOppCostMatrix[n][j - 1] = matrix[n][j - 1] + minOppCostMatrix[n][j];

		/* Construct rest of the minCostMatrix array */
		for (int i = m; i >= 1; i--)
			for (int j = n; j >= 1; j--)
				minOppCostMatrix[i-1][j-1] = min(/* minCostMatrix[i-1][j-1], */
						minOppCostMatrix[i-1][j], minOppCostMatrix[i][j-1]) + matrix[i-1][j-1];

		return minOppCostMatrix[x][y];
	}
	
	public int maxCost(int x, int y, int[][] matrix) {
		if(matrix.length <= 0 && matrix[0].length <= 0)
			return -1;
		
		if(x >= matrix.length || y >= matrix[0].length)
			return -1;
		
		int n = matrix.length - 1;
		int m = matrix[0].length - 1;
		
		maxCostMatrix = this.setMatrixDefaultValue(new int[matrix.length][matrix[0].length]);
		maxCostMatrix[0][0] = matrix[0][0];
		
		/* Initialize first col of minCostMatrix array */
		for (int i = 1; i <= m; i++)
			maxCostMatrix[i][0] = maxCostMatrix[i-1][0] + matrix[i][0];
	 
	     /* Initialize first row of minCostMatrix array */
	     for (int j = 1; j <= n; j++)
	    	 maxCostMatrix[0][j] = maxCostMatrix[0][j-1] + matrix[0][j];
	 
	     /* Construct rest of the minCostMatrix array */
	     for (int i = 1; i <= m; i++)
	        for (int j = 1; j <= n; j++)
	        	maxCostMatrix[i][j] = max(/*minCostMatrix[i-1][j-1], */
	        			maxCostMatrix[i-1][j], 
	        			maxCostMatrix[i][j-1]) + matrix[i][j];
		
		return maxCostMatrix[x][y];
	}
	
	public int max(int x, int y) {
		if(x>y)
			return x;
		else
			return y;
	}
	
	public int max(int x, int y, int z) {
		if(x>y)
			return (x>z)? x:z;
		else
			return (y>z) ? y:z;
	}
	
	public int min(int x, int y, int z) {
		if(x<y)
			return (x<z)? x:z;
		else
			return (y<z) ? y:z;
	}
	
	public int min(int x, int y) {
		if(x<y)
			return x;
		else
			return y;
	}
	
	public static void main(String[] args) {
		FindMatrixCost matrixCost = new FindMatrixCost();
		int [][] matrix = new int[3][3];
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		
		System.out.println(matrixCost.minCost(2, 2, matrix));
		System.out.println(matrixCost.maxCost(2, 2, matrix));
		System.out.println(matrixCost.minOppositCost(0, 0, matrix));
	}
	
	public int[][] setMatrixDefaultValue(int[][] matrix) {
		for(int i=0; i<matrix.length; i++)
			for(int j=0; j<matrix[i].length; j++)
				matrix[i][j] = 0;
		return matrix;
	}
}