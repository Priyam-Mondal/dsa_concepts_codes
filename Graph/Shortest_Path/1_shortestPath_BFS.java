/*For finding the shortest path in an undirected graph with unit weight,
 the technique we use is the Breadth-First Search (BFS). 
 Now, the question arises why do we use the BFS technique in finding the 
 shortest path here when we could’ve easily used other standard graph 
 shortest path algorithms to implement the same? If we start traversal 
 from the src node, we move to other adjacent nodes, everyone is at a distance of 1, 
 so everyone goes into the queue, then subsequently we get the next set of nodes at 1 more distance, 
 making the distance to 2, and if you look at the queue closely, 
 it will look something like below. Queue here acts as a sorted Queue, 
 hence we don’t need any sorted ds which we generally require in the other graph algorithms. */



import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static int[] shortestPath(int n, int [][]edges, int src) {
        
        int m=edges.length;

        // Step 1: Create graph
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        // Step 2: Make adjacency list
        for(int i=0; i<m; i++){
            adj.get(edges[i][0]).add(edges[i][1]); 
            adj.get(edges[i][1]).add(edges[i][0]); 
        }

        // Step 3: Create and fill dist array with infinity
        int[] dist=new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Step 4: BFS
        Queue<Integer> q=new LinkedList<>();
        q.add(src); // Add the source node to the queue
        dist[src]=0;

        while(!q.isEmpty()){
            int node=q.remove();
            for(int it:adj.get(node)){
                if(1+dist[node] < dist[it]){
                    dist[it]=1+dist[node];
                    q.add(it);
                }
            }
        }

        // Step 5: Updated shortest distances are stored in the resultant array.
        // Unreachable nodes are marked as -1. 
        for(int i = 0;i<n;i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1; 
            }
        }
        return dist; 
    }
}
 