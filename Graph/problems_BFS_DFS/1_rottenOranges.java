/*You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. 
If this is impossible, return -1.

 
Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0. */


class Solution {
    public int orangesRotting(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int freshCnt=0;

        //push all rotten positions
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                //count the number of fresh oranges
                if(grid[i][j]==1){
                    freshCnt++;
                }
            }
        }

        if(freshCnt == 0) return 0;
        if (q.isEmpty())
            return -1;

        //min time required to rot
        int minTime=-1;
        //count fresh
        int cnt=0;
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};

        //bfs from initial rotten orange
        while(!q.isEmpty()){
            int size=q.size();
            // Update the count of oranges affected in this round
            cnt+=size;

            for(int i=0; i<size; i++){
                int[] point=q.poll();
                for(int j=0; j<4; j++){
                    int x=point[0]+dx[j];
                    int y=point[1]+dy[j];

                    // Check if the adjacent cell is within the grid bounds and is fresh
                    if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1) {
                        grid[x][y] = 2; // Mark the adjacent fresh orange as rotten
                        q.offer(new int[]{x, y}); // Add it to the queue for the next round
                        //decremen fresh count
                        freshCnt--;
                    }
                }
            }
            // Increment the minute after processing each round
            minTime++;
        }

        // If all fresh oranges have been affected, return the minimum time
        if (freshCnt>0) {
            return -1;
        }

        // If there are still fresh oranges left, it means they couldn't be affected
        return minTime;
        
    }
}


/*
TC : O ( n x n ) x 4    
    Reason: Worst-case – We will be making each fresh orange rotten in 
    the grid and for each rotten orange will check in 4 directions

SC : O ( n x n )
    Reason: worst-case –  If all oranges are Rotten, 
    we will end up pushing all rotten oranges into the Queue data structure */