import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Class representing a pair of integers (node, parent)
class Pair {
    int node;
    int parent;

    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class Solution {

    // Function to perform cycle detection using BFS
    static boolean detect(int n, int[] vis, List<List<Integer>> adj) {
        vis[n] = 1; // Mark the current node as visited
        Queue<Pair> q = new LinkedList<>();
        // Add the root node with parent -1 to the queue
        q.add(new Pair(n, -1));

        // Perform BFS traversal
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            int node = temp.node;
            int parent = temp.parent;

            // Iterate through the adjacent nodes of the current node
            for (Integer it : adj.get(node)) {
                if (vis[it] == 0) {
                    // If the adjacent node is not visited, add it to the queue with its parent
                    q.add(new Pair(it, node));
                    vis[it] = 1; // Mark the adjacent node as visited
                } else if (parent != it) {
                    // If the adjacent node is visited and is not its own parent node, a cycle is detected
                    return true;
                }
            }
        }
        return false; // No cycle found
    }

    static class Graph {
        // Function to detect cycles in the graph
        boolean detectCycle(int V, List<List<Integer>> adj) {
            int[] vis = new int[V];
            for (int i = 0; i < V; i++) {
                if (vis[i] == 0) {
                    // If the current node is not visited, perform cycle detection
                    if (detect(i, vis, adj)) {
                        return true; // If a cycle is found, return true
                    }
                }
            }
            return false; // No cycle found in the graph
        }
    };
}

/*Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 
2E is for total degrees as we traverse all adjacent nodes. 
In the case of connected components of a graph, it will take another O(N) time.

Space Complexity: O(N) + O(N) ~ O(N), Space for queue data structure and visited array. */