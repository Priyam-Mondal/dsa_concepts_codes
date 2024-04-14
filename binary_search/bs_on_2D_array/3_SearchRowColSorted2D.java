/*Given a matrix of size n x m, where every row and column is sorted in increasing order, 
and a number x. Find whether element x is present in the matrix or not.

Example 1:

Input:
n = 3, m = 3, x = 62
matrix[][] = {{ 3, 30, 38},
              {36, 43, 60},
              {40, 51, 69}}
Output: 0
Explanation:
62 is not present in the matrix, 
so output is 0.
Example 2:

Input:
n = 1, m = 6, x = 55
matrix[][] = {{18, 21, 27, 38, 55, 67}}
Output: 1
Explanation: 55 is present in the matrix. */




/*--------------------------Observations------------------------

Cell (0, 0): Assume we are starting traversal from (0, 0) and we are searching for 14. 
Now, this row and column are both sorted in increasing order. So, we cannot determine, 
how to move i.e. row-wise or column-wise. That is why, we cannot start traversal from (0, 0).

Cell (0, m-1): Assume we are starting traversal from (0, m-1) and we are searching for 14.
 Now, in this case, the row is in decreasing order and the column is in increasing order. 
 Therefore, if we start traversal from (0, m-1), in the following way, we can easily determine how we should move.
If matrix[0][m-1] > target: We should move row-wise.
If matrix[0][m-1] < target: We need bigger elements and so we should move column-wise.

Cell (n-1, m-1): Assume we are starting traversal from (n-1, m-1) and we are searching for 14.
Now, this row and column are both sorted in decreasing order. So, we cannot determine, 
how to move i.e. row-wise or column-wise. That is why, we cannot start traversal from (n-1, m-1).

Cell (n-1, 0): Assume we are starting traversal from (n-1, 0) and we are searching for 14. 
Now, in this case, the row is in increasing order and the column is in decreasing order. 
Therefore, if we start traversal from (n-1, 0), in the following way,  we can easily determine how we should move.
If matrix[n-1][0] < target: We should move row-wise.
If matrix[n-1][0] > target: We need smaller elements and so we should move column-wise */


class Solution 
{ 
    //Function to search a given number in row-column sorted matrix.
	static boolean search(int matrix[][], int n, int m, int x) 
	{  
        //start from right corner
	    int row=0;
	    int col=m-1;
	    
	    while(row<n && col>=0){
	        if(matrix[row][col] == x){
	            return true;
	        }else if(matrix[row][col] < x){
	            row++;
	        }else{
	            col--;
	        }
	    }
	    return false;
	} 
} 