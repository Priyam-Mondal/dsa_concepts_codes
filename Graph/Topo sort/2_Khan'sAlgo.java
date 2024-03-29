/*Points to remember when a node is popped out, indegrees for all its 
adjacent nodes are decreased by one and if any of them becomes 0, 
we push that node into the queue. Meanwhile, we include the current node 
in the answer immediately after it is popped out of the queue. */



public class Solution {
    
    // Function to return a list containing vertices in Topological order using Khan's Algorithm.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // Array to store the indegree of each vertex.
        int indegree[] = new int[V];
        
        // Calculating the indegree of each vertex.
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Queue to store vertices with indegree 0.
        Queue<Integer> q = new LinkedList<Integer>();
        
        // Adding vertices with indegree 0 to the queue.
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        // Array to store the topological order.
        int[] topo = new int[V];
        int i = 0;
        
        // Performing BFS starting from vertices with indegree 0.
        while (!q.isEmpty()) {
            // Removing a vertex from the queue.
            int node = q.remove();
            // Adding the vertex to the topological order array.
            topo[i++] = node;
            
            // Decreasing the indegree of adjacent vertices and adding them to the queue if their indegree becomes 0.
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        
        // Returning the topological order array.
        return topo;
    }
}
