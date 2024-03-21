/*********************************************************

 Following is the TreeNode structure:

 class TreeNode<T>
 {
     T data;
     TreeNode<T> left;
     TreeNode<T> right;

     TreeNode(T data)
     {
         this.data = data;
         left = null;
         right = null;
     }
 };
 ********************************************************/

 import java.util.ArrayList;
 import java.util.LinkedList;
 import java.util.List;
 import java.util.Queue;
 public class Solution {
 
     static void levelOrder(TreeNode<Integer> root, List<Integer> lvl){
         if(root==null){
             return;
         }
         
         Queue<TreeNode<Integer>> q=new LinkedList<>();
         q.add(root);
 
         while(!q.isEmpty()){
             TreeNode<Integer> temp=q.poll();
             lvl.add(temp.data);
 
             // Enqueue left child if not null
             if (temp.left != null) {
                 q.add(temp.left);
             }
 
             // Enqueue right child if not null
             if (temp.right != null) {
                 q.add(temp.right);
             }
         }
 
     }
     public static List<Integer> levelOrder(TreeNode<Integer> root){
         
         List<Integer> lvl=new ArrayList<>();
 
         levelOrder(root, lvl);
 
         return lvl;
     }
 }