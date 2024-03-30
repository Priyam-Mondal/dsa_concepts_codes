/*Given a n * m matrix grid where each element can either be 0 or 1. 
You need to find the shortest distance between a given source cell to a destination cell. 
The path can only be created out of a cell if its value is 1. 

If the path is not possible between source cell and destination cell, then return -1.

Example 1:

Input:
grid[][] = {{1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}}
source = {0, 1}
destination = {2, 2}
Output:
3
Explanation:
1 1 1 1
1 1 0 1
1 1 1 1
1 1 0 0
1 0 0 1
The highlighted part in the matrix denotes the 
shortest path from source to destination cell.
Example 2:

Input:
grid[][] = {{1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0},
            {1, 0, 1, 0, 1}}
source = {0, 0}
destination = {3, 4}
Output:
-1
Explanation:
The path is not possible between source and 
destination, hence return -1. */




class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Edge Case: if the source is only the destination.
        if(source[0] == destination[0] && 
           source[1] == destination[1]) return 0; 

        // Create a queue for storing cells with their distances from source
        // in the form {dist,{cell coordinates pair}}.
        Queue<Tuple> q = new LinkedList<>();  
        int n = grid.length; 
        int m = grid[0].length;

        // Create a distance matrix with initially all the cells marked as
        // unvisited and the source cell as 0. 
        int[][] dist = new int[n][m]; 
        for(int i = 0;i<n;i++) {
            for(int j =0;j<m;j++) {
                dist[i][j] = (int)(1e9); 
            }
        }
        dist[source[0]][source[1]] = 0; 
        q.add(new Tuple(0, source[0], source[1])); 

        // The following delta rows and delts columns array are created such that
        // each index represents each adjacent node that a cell may have 
        // in a direction.
        int dr[] = {-1, 0, 1, 0}; 
        int dc[] = {0, 1, 0, -1}; 
 
        // Iterate through the maze by popping the elements out of the queue
        // and pushing whenever a shorter distance to a cell is found.
        while(!q.isEmpty()) {
            Tuple it = q.peek(); 
            q.remove(); 
            int dis = it.first; 
            int r = it.second; 
            int c = it.third; 
            
            // Through this loop, we check the 4 direction adjacent nodes
            // for a shorter path to destination.
            for(int i = 0;i<4;i++) {
                int newr = r + dr[i]; 
                int newc = c + dc[i]; 
                
                // Checking the validity of the cell and updating if dist is shorter.
                if(newr >= 0 && newr < n && newc >= 0 && newc < m 
                && grid[newr][newc] == 1 && dis + 1 < dist[newr][newc]) {
                    dist[newr][newc] = 1 + dis; 

                    // Return the distance until the point when
                    // we encounter the destination cell.
                    if(newr == destination[0] && 
                       newc == destination[1]) return dis + 1; 
                    q.add(new Tuple(1+dis, newr, newc)); 
                }
            }
        }
        // If no path is found from source to destination.
        return -1; 
    }
}
class Tuple{
    int first, second, third; 
    Tuple(int _first, int _second, int _third) {
        this.first = _first; 
        this.second = _second; 
        this.third = _third; 
    }
}