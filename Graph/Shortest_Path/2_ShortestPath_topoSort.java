/*Finding the shortest path to a vertex is easy if you already know the 
shortest paths to all the vertices that can precede it. Processing the vertices
 in topological order ensures that by the time you get to a vertex, you've already processed 
 all the vertices that can precede it which reduces the computation time significantly.
  In this approach, we traverse the nodes sequentially according to their reachability from the source.

Dijkstra's algorithm is necessary for graphs that can contain cycles because they 
can't be topologically sorted. In other cases, the topological sort would work fine 
as we start from the first node, and then move on to the others in a directed manner. */




class Pair {
    int v, wt;
    Pair(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}
//User function Template for Java
class Solution {
    static void dfs(int node, Stack<Integer> st, int[] vis, ArrayList<ArrayList<Pair>> adj) {
        vis[node] = 1;

        for (Pair p : adj.get(node)) {
            int v = p.v;
            int wt = p.wt;

            if (vis[v] == 0) {
                dfs(v, st, vis, adj);
            }
        }
        st.push(node);
    }
	public int[] shortestPath(int n,int m, int[][] edges) {
		// Create the graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(v, wt)); // Correctly adding to adj.get(u)
        }
        
        // Topo sort using DFS
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, st, vis, adj);
            }
        }

        // Pop from stack and relax edges
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Make dist of source 0
        dist[0] = 0;

        while (!st.isEmpty()) {
            int node = st.pop();
            
            for (Pair p : adj.get(node)) {
                int v = p.v;
                int wt = p.wt;

                if (dist[node] != Integer.MAX_VALUE && dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                }
            }
        }

        // Making dist of unreachable node -1
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
	}
}