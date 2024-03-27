public class Solution {

    // Depth-first search (DFS) function to traverse the graph
    static void dfs(int node, boolean[] vis, int[][] roads) {
        // Mark the current node as visited
        vis[node] = true;

        // Traverse all cities to find unvisited neighbors
        for (int j = 0; j < vis.length; j++) {
            // If city j is connected to the current city and not visited yet
            if (roads[node][j] == 1 && !vis[j]) {
                // Recursively call DFS on the unvisited neighbor
                dfs(j, vis, roads);
            }
        }
    }

    // Function to find the number of provinces in the given graph
    public static int findNumOfProvinces(int[][] roads, int n) {
        // Variable to store the number of provinces
        int components = 0;
        
        // Array to keep track of visited cities
        boolean[] vis = new boolean[n];

        // Iterate through all cities
        for (int i = 0; i < n; i++) {
            // If city i is not visited yet, perform DFS from it
            if (!vis[i]) {
                components++;
                dfs(i, vis, roads);
            }
        }

        // Return the number of provinces
        return components;
    }
}

/*
TC : O(N^2), where ‘N’ is the number of cities.
The time complexity of DFS is ‘O(V^2)’ when an adjacency matrix is used, 
where ‘V’ is the number of nodes. As there are ‘N’ cities ‘V = N’, so the time complexity is ‘O(N^2)’.

SC : O(N), where ‘N’ is the number of cities. 

*/