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
class Solution {

    static int helper(TreeNode root, int[] maxSum){
        if(root==null){
            return 0;
        }

        // Calculate the maximum sum of the left and right subtrees recursively
        
        //if sum came negative, we are making it 0
        int lSum=Math.max(helper(root.left, maxSum), 0);
        int rSum=Math.max(helper(root.right, maxSum), 0);

        // Update the maximum path sum if the current path through the node is greater
        maxSum[0]=Math.max(maxSum[0], lSum+rSum+root.val);

        // Return the maximum sum possible if the current node is included in the path
        return Math.max(lSum,rSum)+root.val;
    }

    public int maxPathSum(TreeNode root) {
        // Initialize maxSum with the smallest possible integer value
        int[] maxSum={Integer.MIN_VALUE};
        helper(root, maxSum);
        return maxSum[0];
    }
}
