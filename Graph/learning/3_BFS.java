import java.util.*;

public class Solution {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
        
        List<Integer> bfs=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        boolean[] vis=new boolean[n];

        //add root node and mark it as visited
        q.add(0);
        vis[0]=true;
        
        while(!q.isEmpty()){        //O(n)
            int node=q.poll();
            bfs.add(node);

            //add neighbours
            for(int neigh:adj.get(node)){       //O(2*E)
                //if not visited : mark visited and add to queue
                if(vis[neigh]==false){
                    vis[neigh]=true;
                    q.add(neigh);
                }
            }
        }

        return bfs;

    }
}

/*
 Time Complexity: O(N) + O(2E), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes.

Space Complexity: O(3N) ~ O(N), Space for queue data structure visited array and an adjacency list
 */

