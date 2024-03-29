/*Given a sorted dictionary of an alien language having N words 
and k starting alphabets of standard dictionary. 
Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may
 return any valid order and output will be 1 if the order of string 
 returned by the function is correct else 0 denoting incorrect string returned.

Example 1:

Input: 
N = 5, K = 4
dict = {"baa","abcd","abca","cab","cad"}
Output:
1
Explanation:
Here order of characters is 
'b', 'd', 'a', 'c' Note that words are sorted 
and in the given language "baa" comes before 
"abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.
Example 2:

Input: 
N = 3, K = 3
dict = {"caa","aaa","aab"}
Output:
1
Explanation:
Here order of characters is
'c', 'a', 'b' Note that words are sorted
and in the given language "caa" comes before
"aaa", therefore 'c' is before 'a' in output.
Similarly we can find other orders. */



class Solution
{
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
    
    public String findOrder(String [] dict, int N, int K)
    {
        //step 1: create graph
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0; i<K; i++){
            adj.add(new ArrayList<>());
        }
        
        //step 2: find the order
        for(int i=0; i<N-1; i++){
            String s1=dict[i];
            String s2=dict[i+1];
            
            int len=Math.min(s1.length(), s2.length());
            
            for(int j=0; j<len; j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    
                    //add a edge for every order found
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        
        // step 3: Perform topological sort
        int[] topoList = topoSort(K, adj);
        
        // step 4: Convert the topoList to string
        StringBuilder ans = new StringBuilder();
        for (int it : topoList) {
            char ch = (char) (it + 'a');
            ans.append(ch);
        }
        
        return ans.toString();
        
    }
}