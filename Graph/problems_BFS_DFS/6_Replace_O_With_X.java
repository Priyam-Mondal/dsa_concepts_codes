/*Given a 2D array grid G of 'O's and 'X's. The task is to replace all 'O' with 'X' contained in each island. 
Where, an island is a set of 'O's connected horizontally or vertically and surrounded by 'X' from all of it's boundaries.
 (Boundary means top, bottom, left and right) 
 

Sample Input 1:
5 4
X X O O
X O X X
X O O X
X O X X
X X X X
Sample Output 1:
X X O O
X X X X
X X X X
X X X X
X X X X
Explanation of Sample Output 1:
There is only one island in the above input. Considering zero based indexing, 
The co-ordinates of the island are (1, 1), (2, 1), (2, 2) and (3, 1).
 We just need to replace the O's at this co-ordinates with X's. Hence the output.

*/


public class Solution {
    
    // Depth First Search function
    static void dfs(int row, int col, int[][] vis, char[][] matrix, 
                    int[] delrow, int[] delcol) {
        vis[row][col] = 1;
        int n = matrix.length;
        int m = matrix[0].length;

        // Check for top, right, bottom, left 
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i]; 

            // Check for valid coordinates and unvisited 'O's
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                && vis[nrow][ncol] == 0 && matrix[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, matrix, delrow, delcol); 
            }
        }
    }
    
    // Function to replace 'O's with 'X's
    public static void replaceOWithX(char matrix[][]) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        // Initialize visit array and directional arrays
        int[][] vis = new int[n][m];
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};

        // Check for unvisited 'O's in the boundary rows
        for (int j = 0; j < m; j++) {
            // First row 
            if (vis[0][j] == 0 && matrix[0][j] == 'O') {
                dfs(0, j, vis, matrix, delrow, delcol); 
            }
            
            // Last row 
            if (vis[n - 1][j] == 0 && matrix[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, matrix, delrow, delcol); 
            }
        }
        
        // Check for unvisited 'O's in the boundary columns
        for (int i = 0; i < n; i++) {
            // First column
            if (vis[i][0] == 0 && matrix[i][0] == 'O') {
                dfs(i, 0, vis, matrix, delrow, delcol); 
            }
            
            // Last column
            if (vis[i][m - 1] == 0 && matrix[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, matrix, delrow, delcol); 
            }
        }

        // Replace unvisited 'O's with 'X's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && matrix[i][j] == 'O') {
                    matrix[i][j] = 'X';
                }
            }
        }	
    }
}
