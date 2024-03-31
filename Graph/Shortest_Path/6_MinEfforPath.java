/*You are a hiker preparing for an upcoming hike. You are given heights, 
a 2D array of size rows x columns, where heights[row][col] represents the height of the cell (row, col). 
You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell,
 (rows-1, columns-1) (i.e.,0-indexed). You can move up, down, left, or right, 
 and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Examples:

Example 1:
Input:
heights = [[1,2,2],[3,8,2],[5,3,5]]
Output:
2
Explanation: 

The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

Example 2:

Input:

heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output:
0
Explanation: 
The route of [1,1,1,1,1,1,1,1,1,1,1,1,1,1] has a maximum absolute difference of 0 in consecutive cells.
This is better than the route of [1,1,1,1,1,1,2,1], where the maximum absolute difference is 1. */



class Solution {
    
    // Method to find the minimum effort required
    int MinimumEffort(int heights[][]) {
        
        // Priority queue to store tuples based on distance
        PriorityQueue<Tuple> pq = new PriorityQueue<>(
            (x, y) -> x.distance - y.distance);
        
        int n = heights.length; // Number of rows
        int m = heights[0].length; // Number of columns
        int[][] dist = new int[n][m]; // Distance array
        
        // Initialize distance array with a large value
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) (1e9);
            }
        }
        
        dist[0][0] = 0; // Starting position
        pq.add(new Tuple(0, 0, 0)); // Add the starting position to the priority queue
        
        // Array to represent delta rows and delta columns for adjacent positions
        int dr[] = {-1, 0, 1, 0}; // Up, right, down, left
        int dc[] = {0, 1, 0, -1}; // Up, right, down, left
        
        // Loop until priority queue is empty
        while (!pq.isEmpty()) {
            Tuple t = pq.remove(); // Extract the tuple with minimum distance
            
            int diff = t.distance; // Current distance
            int row = t.row; // Row of current position
            int col = t.col; // Column of current position
            
            // If destination is reached, return the minimum distance
            if (row == n - 1 && col == m - 1) {
                return diff;
            }
            
            // Explore adjacent positions
            for (int i = 0; i < 4; i++) {
                int nrow = row + dr[i]; // New row
                int ncol = col + dc[i]; // New column
                
                // Check if the new position is valid
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    // Calculate the new difference in heights
                    int newDiff = Math.max(diff, Math.abs(heights[row][col] - heights[nrow][ncol]));
                    
                    // If the new difference is less than the previously stored distance
                    if (newDiff < dist[nrow][ncol]) {
                        dist[nrow][ncol] = newDiff; // Update the distance array
                        pq.add(new Tuple(newDiff, nrow, ncol)); // Add the new position to the priority queue
                    }
                }
            }
        }
        return 0; // Default return value
    }
}

// Class to represent a tuple containing distance, row, and column
class Tuple {
    int distance; // Distance
    int row; // Row
    int col; // Column
    
    // Constructor to initialize the tuple
    public Tuple(int distance, int row, int col) {
        this.row = row;
        this.distance = distance;
        this.col = col; 
    }
}
