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
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: If both nodes are null, they are identical.
        if(p==null && q==null){
            return true;
        }
        // If one of the nodes is null while the other is not, they are not identical.
        if(p!=null && q==null){
            return false;
        }
        if(p==null && q!=null){
            return false;
        }

        // Recursively check the left and right subtrees for identity.
        boolean left = isSameTree(p.left,q.left);
        boolean right = isSameTree(p.right,q.right);

        // Check if the current nodes have the same value.
        boolean data = p.val==q.val?true:false;

        // Return true if left, right, and data are all true, indicating identical trees.
        if(left && right && data){
            return true;
        }
        else{
            return false;
        }
    }
}
