/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 class Pair{
    boolean balance;
    int height;

    Pair(){};

    Pair(boolean balance, int height){
        this.balance=balance;
        this.height=height;
    }
}
class Solution {

    static Pair helper(TreeNode root){
        if(root==null){
            return new Pair(true,0);
        }

        //get balance and height for left subtree
        Pair left=helper(root.left);

        //get balance and height for right subtree
        Pair right=helper(root.right);

        int heightDiff=Math.abs(left.height-right.height);

        Pair temp=new Pair();
        //condition to check balance for current node
        temp.balance=left.balance && right.balance && heightDiff<=1 ? true : false;
        //height at current node
        temp.height=Math.max(left.height,right.height)+1;

        return temp;
    }

    public boolean isBalanced(TreeNode root) {
        return helper(root).balance;
    }
}