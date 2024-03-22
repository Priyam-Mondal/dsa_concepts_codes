
/**
 * This class contains a solution for finding the diameter of a binary tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * It may or may not pass through the root.
 * 
 * Time Complexity Analysis:
 * The time complexity of this solution is O(n), where n is the number of nodes in the binary tree.
 * - The height() method calculates the height of the tree in a bottom-up manner, visiting each node once.
 *   Therefore, its time complexity is O(n).
 * - The diameterOfBinaryTree() method calls the height() method once, which takes O(n) time.
 *   Thus, the overall time complexity is O(n).
 */
class Solution {
    
    static int height(TreeNode root, int[] diameter) {
        // Base case: If the root is null, return 0.
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of the left and right subtrees.
        int lh = height(root.left, diameter);
        int rh = height(root.right, diameter);

        // Update the diameter if the sum of left and right subtree heights exceeds the current diameter.
        diameter[0] = Math.max(diameter[0], lh + rh);

        // Return the height of the current node.
        return 1 + Math.max(lh, rh);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        // Initialize an array to store the diameter of the tree.
        int[] diameter = {0};
        
        // Calculate the height of the tree and update the diameter.
        height(root, diameter);
        
        // Return the diameter of the binary tree.
        return diameter[0];
    }
}
