
class Solution {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Create min heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);

        // Initialize dist array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[S] = 0;
        pq.add(new Pair(S, 0)); // Start with source vertex and distance 0

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            int dis = p.wt;

            // Traverse adjacency list for the current node
            for (ArrayList<Integer> edge : adj.get(node)) {
                int adjNode = edge.get(0);
                int edgeWt = edge.get(1);

                // Relax the edge if a shorter path is found
                if (dis + edgeWt < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWt;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        return dist;
    }
}

class Pair {
    int node, wt;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}


/*Time Complexity : O( E log(V) ) 

Where E = Number of edges and V = Number of Nodes.

Space Complexity : O( |E| + |V| ) 

Where E = Number of edges and V = Number of Nodes.


WHY NOT DIJKSTRA FOR -VE WEIGHT GRAPHS?
    https://www.geeksforgeeks.org/why-does-dijkstras-algorithm-fail-on-negative-weights/

*/

