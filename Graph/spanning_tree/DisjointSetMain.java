package Graph.spanning_tree;

import java.util.*;

class DisjointSet {
    ArrayList<Integer> rank=new ArrayList<>();
    ArrayList<Integer> parent=new ArrayList<>();

    DisjointSet(int v){
        for(int i=0;i<=v;i++){
            rank.add(0);
            parent.add(i);
        }
    }

    //find ultimate parent of each node
    int findParent(int node){
        //same as its parent, so it is ultimate parent
        if(node==parent.get(node)){
            return node;
        }
        //find parent of parent recursivley
        int ulPar=findParent(parent.get(node));
        //set current nodes parent to its ultimate parent
        parent.set(node,ulPar);
        return ulPar;
    }
    void unionByRank(int u,int v){
        int pu=findParent(u);
        int pv=findParent(v);
        
        //same parent, belong to same component
        if(pu==pv){
            return;
        }

        //merge small edge with greater edge
        if(rank.get(pu) < rank.get(pv)){
            parent.set(pu,pv);
        }else if(rank.get(pv) < rank.get(pu)){
            parent.set(pv,pu);
        }else{
            //rank same
            parent.set(pv,pu);
            //merge u->v or v->u and increment rank by 1
            rank.set(pu, rank.get(pu)+1);
        }
    }
    
}

public class DisjointSetMain{
    public static void main (String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}