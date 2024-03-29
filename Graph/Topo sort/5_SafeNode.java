/*There is a directed graph of n nodes with each node labeled from 0 to n - 1. 
The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an 
integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if
 every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 
Example 1:

Illustration of graph
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
Example 2:

Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
Output: [4]
Explanation:
Only node 4 is a terminal node, and every path starting at node 4 leads to node 4. */




class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n=graph.length;
        int m=graph[0].length;

        //step 1: create graph
        ArrayList<ArrayList<Integer>> adjRev=new ArrayList<>();
        for(int i=0; i<n; i++){
            adjRev.add(new ArrayList<>());
        }

        // Array to store the indegree of each vertex.
        int indegree[] = new int[n];

        //step 2: reverse graph and increment indegree
        for(int i=0; i<n; i++){
            for(int t:graph[i]){
                adjRev.get(t).add(i);
                indegree[i]++;
            }
        }

        

        // step 3: add vertices with indegree 0 into queue
        Queue<Integer> q = new LinkedList<Integer>();
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
    
        ArrayList<Integer> topo=new ArrayList<>();
        
        // Performing BFS starting from vertices with indegree 0.
        while (!q.isEmpty()) {
     
            int node = q.remove();
            // store topo order
            topo.add(node);
            
            // Decreasing the indegree of adjacent vertices 
            // adding them to the queue if their indegree becomes 0.
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        
        Collections.sort(topo);
        return topo;
    }
}