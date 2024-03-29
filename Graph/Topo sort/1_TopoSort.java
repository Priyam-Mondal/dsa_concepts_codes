/*node u will always appear before node v if there is a directed edge from node u towards node v(u -> v).
 
Intuition: 

Since we are inserting the nodes into the stack after the completion of the traversal, 
we are making sure, there will be no one who appears afterward but may come before in 
the ordering as everyone during the traversal would have been inserted into the stack. 

 */



import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    
    // Depth First Search (DFS) function to traverse the graph and store visited nodes in a stack.
    static void dfs(int node, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        // Marking the current node as visited.
        vis[node] = 1;
        
        // Traverse through all adjacent nodes of the current node.
        for (int it : adj.get(node)) {
            // If the adjacent node is not visited, recursively call dfs on it.
            if (vis[it] == 0) {
                dfs(it, vis, st, adj);
            }
        }
        // Push the current node to the stack after visiting all its adjacent nodes.
        st.push(node);
    }
    
    // Function to return a list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // Array to store the visited status of nodes.
        int[] vis = new int[V];
        // Stack to store the topological order.
        Stack<Integer> st = new Stack<>();
        
        // Traverse through all nodes of the graph.
        for (int i = 0; i < V; i++) {
            // If the node is not visited, call dfs on it.
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }
        
        // Initialize an array to store the topological order.
        int[] ans = new int[V];
        int index = 0;
        
        // Pop elements from the stack and store them in the result array.
        while (!st.isEmpty()) {
            ans[index++] = st.peek();
            st.pop();
        }
        // Return the array containing vertices in topological order.
        return ans;
    }
}
 