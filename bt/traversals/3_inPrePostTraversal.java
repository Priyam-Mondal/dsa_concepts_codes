/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

 import java.util.ArrayList;
 import java.util.List;
 public class Solution {
 
     static void inOrder(TreeNode root,List<Integer> in){
         if(root==null){
             return;
         }
 
         inOrder(root.left, in);
         in.add(root.data);
         inOrder(root.right, in);
     }
     static void preOrder(TreeNode root,List<Integer> pre){
         if(root==null){
             return;
         }
 
         pre.add(root.data);
         preOrder(root.left, pre);
         preOrder(root.right, pre);
     }
     static void postOrder(TreeNode root,List<Integer> post){
         if(root==null){
             return;
         }
 
         postOrder(root.left, post);
         postOrder(root.right, post);
         post.add(root.data);
 
     }
     public static List<List<Integer>> getTreeTraversal(TreeNode root) {
         
         List<List<Integer>> ans=new ArrayList<>();
         List<Integer> in=new ArrayList<>();
         List<Integer> pre=new ArrayList<>();
         List<Integer> post=new ArrayList<>();
 
         inOrder(root, in);
         preOrder(root, pre);
         postOrder(root, post);
 
         ans.add(in);
         ans.add(pre);
         ans.add(post);
 
         return ans;
 
     }
 }