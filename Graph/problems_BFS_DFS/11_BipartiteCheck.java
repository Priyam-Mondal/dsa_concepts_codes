/*Given an adjacency list of a graph adj of V no. of vertices having 0 based index. 

If we are able to colour a graph with two colours such that no 
adjacent nodes have the same colour, it is called a bipartite graph. */


class Solution
{
    
    static boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>>adj){
        color[node]=col;
        
        for(int it:adj.get(node)){
            //if uncolored
            if(color[it]==-1){
                if(dfs(it,1-col,color,adj)==false){
                    return false;
                }
            }
            
            //if previously colored and it is same color
            else if(color[it]==col){
                return false;
            }
        }
        
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int color[]=new int[V];
        
        Arrays.fill(color, -1);
        
        //for all the components
        for(int i=0; i<V; i++){
            //call dfs if not colored
            if(color[i]==-1){
                if(dfs(i,0,color,adj) == false){
                    return false;
                }
            }
        }
        
        return true;
    }
}