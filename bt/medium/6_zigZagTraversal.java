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
import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans; // If the root is null, return an empty list
        }

        Queue<TreeNode> q = new LinkedList<>();
        //flag to decide the direction
        boolean leftToRight = true;
        q.offer(root);

        while (!q.isEmpty()) {
            int lvlNum = q.size();
            List<Integer> subList = new ArrayList<>();

            for (int i = 0; i < lvlNum; i++) {
                TreeNode node = q.poll();
                if (leftToRight) {
                    subList.add(node.val);
                } else {
                    subList.add(0, node.val); // Add at the beginning for right to left
                }
                
                // Add left and right children to the queue if they exist
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            
            leftToRight = !leftToRight; // Toggle direction after processing each level
            ans.add(subList);
        }

        return ans;
    }
}
