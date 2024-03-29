import java.util.*;

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // Array to store the indegree of each vertex.
        int indegree[] = new int[V];
        
        // Calculating the indegree of each vertex.
        for (int i = 0; i < V; i++) {
            // Iterate over the adjacency list of each vertex.
            for (int it : adj.get(i)) {
                indegree[it]++; // Increment the indegree of the adjacent vertex.
            }
        }

        // Queue to store vertices with indegree 0.
        Queue<Integer> q = new LinkedList<Integer>();
        
        // Adding vertices with indegree 0 to the queue.
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i); // Add vertex with indegree 0 to the queue.
            }
        }
        
        int cnt = 0; // Counter to count the number of vertices in the topological order.
        
        // Performing BFS starting from vertices with indegree 0.
        while (!q.isEmpty()) {
            // Removing a vertex from the queue.
            int node = q.remove();
            cnt++; // Increment the counter.
            
            // Decreasing the indegree of adjacent vertices and adding them to the queue if their indegree becomes 0.
            for (int it : adj.get(node)) {
                indegree[it]--; // Decrement the indegree of the adjacent vertex.
                if (indegree[it] == 0) {
                    q.add(it); // If the indegree becomes 0, add it to the queue.
                }
            }
        }
        
        // If the count of vertices in topological order is not equal to the total number of vertices, there is a cycle.
        return (cnt != V);
    }
}
