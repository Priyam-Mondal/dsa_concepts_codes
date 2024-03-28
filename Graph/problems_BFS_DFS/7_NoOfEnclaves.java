/*You are given an n x m binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Find the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

Example 1:

Input:
grid[][] = {{0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}}
Output:
3
Explanation:
0 0 0 0
1 0 1 0
0 1 1 0
0 0 0 0
The highlighted cells represents the land cells. */


class Pair {
    int first;
    int second; 
    public Pair(int first, int second) {
        this.first = first; 
        this.second = second; 
    }
}

// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        Queue<Pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis= new int[n][m];
        
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, +0, -1}; 
        
        //if boundary and 1
        for(int i=0; i<n ;i++){
            for(int j=0; j<m; j++){
                
                // first row, first col, last row, last col 
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    
                    //if it is a land(1)
                    if(grid[i][j]==1){
                        q.add(new Pair(i,j));
                        vis[i][j]=1;
                    }
                }
            }
        }
        
        while(!q.isEmpty()){
            Pair t=q.poll();
            int row=t.first;
            int col=t.second;
            
            //visit 4 neighbours
            for(int i=0; i<4; i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                
                // check for valid coordinates and for land cell
                if(nrow >=0 && nrow <n && ncol >=0 && ncol < m 
                    && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1)
                {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol]=1;
                }
            }
        }
        
        int cnt = 0;
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                // check for unvisited land cell
                if(grid[i][j] == 1 & vis[i][j] == 0) 
                    cnt++; 
            }
        }
        return cnt; 
        
    }
}