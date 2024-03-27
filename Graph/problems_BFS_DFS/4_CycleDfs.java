import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Define a Pair class to represent a pair of nodes in the graph
class Pair {
    int node; // Current node
    int parent; // Parent node

    // Constructor to initialize the Pair with node and parent
    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class Solution {

    // Depth First Search (DFS) function to detect cycles in the graph
    static boolean dfs(int node, int parent, int[] vis, List<List<Integer>> adj) {
        vis[node] = 1; // Mark the current node as visited

        // Traverse all adjacent nodes
        for (Integer it : adj.get(node)) {
            // If the adjacent node is not visited, recursively call DFS on it
            if (vis[it] == 0) {
                if (dfs(it, node, vis, adj)) {
                    return true; // If cycle is detected in the subtree rooted at 'it', return true
                }

            } else if (it != parent) { // If the adjacent node is visited and not the parent node
                return true; // Cycle detected, return true
            }
        }
        return false; // No cycle found, return false
    }

    static class Graph {
        // Method to detect cycles in the graph
        boolean detectCycle(int V, List<List<Integer>> adj) {
            int[] vis = new int[V]; // Array to track visited nodes

            // Traverse each node in the graph
            for (int i = 0; i < V; i++) {
                if (vis[i] == 0) { // If the node is not visited yet
                    if (dfs(i, -1, vis, adj)) { // Call DFS to detect cycles from this node
                        return true; // If cycle is detected, return true
                    }
                }
            }
            return false; // No cycle found in the graph, return false
        }
    };
}


/*Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 2E is for total degrees as 
we traverse all adjacent nodes. In the case of connected components of a graph, it will take another O(N) time.

Space Complexity: O(N) + O(N) ~ O(N), Space for recursive stack space and visited array. */