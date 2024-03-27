import java.util.ArrayList;

public class Solution {
    
    // Depth First Search (DFS) function
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, 
                    boolean[] vis, ArrayList<Integer> dfsList){
        
        // Mark the current node as visited and add it to the DFS list
        vis[node] = true;
        dfsList.add(node);
        
        // Traverse the neighbors of the current node
        for (int neigh : adj.get(node)) {
            // If neighbor is not visited, recursively call DFS on it
            if (!vis[neigh]) {
                dfs(neigh, adj, vis, dfsList);
            }
        }
    }
    
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        // Initialize an ArrayList to store the DFS traversal result
        ArrayList<Integer> dfsList = new ArrayList<>();
        
        // Initialize a boolean array to keep track of visited nodes
        boolean[] vis = new boolean[V];
        
        // Start DFS traversal from node 0
        dfs(0, adj, vis, dfsList);
        
        // Return the DFS traversal result
        return dfsList;
    }
}


/*TC: For an undirected graph, O(N) + O(2E), 
    For a directed graph, O(N) + O(E), 
    Because for every node we are calling the recursive function once, 
    the time taken is O(N) and 2E is for total degrees as we traverse for all adjacent nodes.

SC: O(3N) ~ O(N), Space for dfs stack space, visited array and an adjacency list. */