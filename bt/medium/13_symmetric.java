/*

if we draw a mirror on the root-
traversing of root's left would be opposite in the mirror's right

for left subtree root.left is equivalent to root.right in mirror's right side

*/
class Solution {
    
    static boolean helper(TreeNode left, TreeNode right){
        // Base case: if both nodes are null, they are symmetric
        if(left == null || right == null){
            return left == right;
        }

        // Check if the values of the current nodes are equal
        if(left.val != right.val){
            return false;
        }

        // Recursively check the symmetry of subtrees
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
    
    // Main method to check if a binary tree is symmetric
    public boolean isSymmetric(TreeNode root) {
        // If the root is null or the left and right subtrees are symmetric, the tree is symmetric
        if(root == null || helper(root.left, root.right)){
            return true;
        }
        // Otherwise, it is not symmetric
        return false;
    }
}
