/*Sample Input 1:
4 3
1 2
0 3
2 3
Sample Output 1:
0 3
1 2
2 1 3
3 0 2
Explanation For Sample Input 1:

So, the neighbour of node 0 is 3. So, in the first line, 
the first integer is 0 followed by its neighbour 3. 
Similarly in the second line, 1 is followed by its neighbour 2. 

In the third line, 2 is followed by its neighbours 1 and 3. 
And in the fourth line, 3 is followed by its neighbours 0 and 2. */



import java.util.ArrayList;

public class Solution {
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
        
        //make graph
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(i, new ArrayList<Integer>());
        }

        //storing graph
        for(int i=0; i<m; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);

        }

        // convert into 2d array
        int[][] adjacencyList = new int[n][];
        for(int i=0; i<n; i++){
            int size=graph.get(i).size();
            int[] temp=new int[size+1];
            temp[0]=i;
            for(int j=0; j<size; j++){
                temp[j+1]=graph.get(i).get(j);
            }
            adjacencyList[i]=temp;
        }

        return adjacencyList;


    }
}