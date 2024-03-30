
class Solution {
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        
        // Create adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            // Add both directions for undirected graph
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        // Create min heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);

        int parent[] = new int[n + 1];
        int dist[] = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            dist[i] = Integer.MAX_VALUE;
        }

        dist[1] = 0;
        pq.add(new Pair(1, 0)); // Start with source vertex and distance 0
        parent[1]=1;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            int dis = p.wt;

            // Traverse adjacency list for the current node
            for (Pair edge : adj.get(node)) {
                int adjNode = edge.node;
                int edgeWt = edge.wt;

                // Relax the edge if a shorter path is found
                if (dis + edgeWt < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWt;
                    pq.add(new Pair(adjNode, dist[adjNode]));

                    // Change parent
                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        int node = n;

        // Trace back the shortest path
        while (node != 1) {
            ans.add(node);
            node = parent[node];
        }
        ans.add(1); // Add the source node
        Collections.reverse(ans); // Reverse the list to get the correct order

        return ans;
        
    }
}

class Pair {
    int node, wt;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}