/*You are given the root of a binary search tree (BST), where the values of 
exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

 

Example 1:


Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid. */



class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE); // Initialize prev with a minimum value

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);

        // Found violation
        if (root.val < prev.val) {
            // First violation
            if (first == null) {
                first = prev;
                second = root;
            } else {
                // Second violation
                second = root;
            }
        }
        prev = root;

        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        inorder(root);

        // Swap the nodes if violations are found
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
