/*********************************************
Same as top view, but just adding in map without any condition checking.
Because map.put() will store the latest value, 
all the previous value will get replaced.so, we will get only bottom nodes.

 *********************************************/

 import java.util.*;

 class Pair{
     TreeNode node;
     int hd;
     Pair(){}
     Pair(TreeNode node, int hd){
         this.node=node;
         this.hd=hd;
     }
 }
 public class Solution {
     public static List<Integer> bottomView(TreeNode root) {
 
         List<Integer> ans=new ArrayList<>();
         if(root==null){
             return ans;
         }
         
         //map to store node horizontal distance and node val
         TreeMap<Integer,Integer> map=new TreeMap<>();
 
         Queue<Pair> q=new LinkedList<Pair>();
         q.offer(new Pair(root,0));
 
         while(!q.isEmpty()){
             Pair p=q.poll();
             TreeNode node=p.node;
             int hd=p.hd;
 
             //adding without checking any condition
             //so all the previous nodes for that horizontal distance would get 
             //replaced by the bottom most node only
             map.put(hd,node.val);
 
             if(node.left!=null){
                 //for left x axis will be decremented
                 q.offer(new Pair(node.left, hd-1));
             }
             if(node.right!=null){
                 //for left x axis will be incremented
                 q.offer(new Pair(node.right, hd+1));
             }
         }
 
         //adding into ans
         for(Map.Entry<Integer,Integer> entry : map.entrySet()){
             ans.add(entry.getValue());
         }
 
         return ans;         
     }
 }
 