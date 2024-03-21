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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        
        while (root != null || !st.isEmpty()) {
            // Traverse left subtree and push nodes onto stack
            //actually going as left as possible
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            // Process the current node (top of stack)
            TreeNode current = st.pop();
            ans.add(current.val);
            // Traverse right subtree
            root = current.right;
        }

        return ans;
    }
}