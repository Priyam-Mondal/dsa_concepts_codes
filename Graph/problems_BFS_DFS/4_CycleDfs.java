import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair{
    int node;
    int parent;
    Pair(int node, int parent){
        this.node=node;
        this.parent=parent;
    }
}
public class Solution {

    static boolean dfs(int node, int parent, int[] vis, List<List<Integer>> adj){
        vis[node]=1;

        // go to all adjacent nodes
        for(Integer it: adj.get(node)){
                if(vis[it]==0){
                    if(dfs(it,node,vis,adj)==true){
                        return true;
                    }
                    else if(it!=parent){
                        return true;
                    }
                }
        }
        return false;
    }
    static class Graph {
        boolean detectCycle(int V, List<List<Integer>> adj) {
            int[] vis=new int[V];
            for(int i=0; i<V; i++){
                if(vis[i]==0){
                    if(dfs(i,-1,vis,adj)==true){
                        return true;
                    }
                }
            }
            return false;
        }
    };
}
