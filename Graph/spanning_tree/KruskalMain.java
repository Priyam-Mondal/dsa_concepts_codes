package Graph.spanning_tree;

import java.util.*;


class Tuple{
    int src;
    int dest;
    int wt;
    Tuple(int src, int dest, int wt){
        this.src=src;
        this.dest=dest;
        this.wt=wt;
    }
}

public class KruskalMain {
    public static void main(String[] args)   {

        int E=5;
        int V=4;

        // (src, dest, weight)
        // int[][] edges={
        //     {0,1,4},
        //     {0,7,8},
        //     {1,2,8},
        //     {1,7,11},
        //     {7,8,7},
        //     {7,6,1},
        //     {2,8,2},
        //     {8,6,6},
        //     {2,3,7},
        //     {2,5,4},
        //     {6,5,2},
        //     {3,5,14},
        //     {5,4,10},
        //     {3,4,9}
        // };
        

        int[][] edges={
            {0,1,10},
            {0,2,6},
            {0,3,5},
            {1,3,15},
            {2,3,4}
        };

        //custom comparator
        Comparator<int[]> myCom=new Comparator<>(){
            public int compare(int[] a,int[] b){
                return a[2]-b[2];
            }
        };

        //sort according to weights
        Arrays.sort(edges,myCom);
        
        //disjoint set
        DisjointSet ds=new DisjointSet(V);
        
        int sum=0;
        ArrayList<ArrayList<Integer>> mstEdge=new ArrayList<>();

        //form mst
        for(int i=0; i<E; i++){
            int src=edges[i][0];
            int dest=edges[i][1];
            int wt=edges[i][2];

            if(ds.findParent(src) != ds.findParent(dest)){
                sum+=wt;
                //add the edge of mst
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(src);
                temp.add(dest);
                temp.add(wt);

                mstEdge.add(temp);

                ds.unionByRank(src, dest);
            }
        }

        System.out.println("Edge\tweight");
        for(int i=0; i<mstEdge.size(); i++){
            System.out.println(mstEdge.get(i).get(0)+"->"+mstEdge.get(i).get(1)+"\t"+
                                    mstEdge.get(i).get(2));
        }

        System.out.println("Sum: "+sum);
        
    }
}


/*
 output..............

 Edge    weight
2->3    4
0->3    5
0->1    10
Sum: 19
PS D:\DSA\dsa_concepts_codes>       

 */