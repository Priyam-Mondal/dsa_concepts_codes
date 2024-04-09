/*
Example 1:
Input:Binary Tree: 1 2 3 4 5 -1 6
				

Output: [[1],[3, 2],[4, 5, 6]]
Explanation: 
Level 1 (Root): Visit the root node 1 from left to right. Zigzag Traversal: [1]
Level 2: Visit nodes at this level in a right-to-left order. Zigzag Traversal:  [1], [3, 2]
Level 3: Visit nodes at this level in a left-to-right order. Zigzag Traversal:  [1], [3, 2], [4, 5, 6]

Example 2:
Input:Binary Tree: 1 2 -1 4 5 -1 -1 7 8
				

Output : [[1], [2], [4, 5], [8, 7]]
Explanation: 
Level 1 (Root): Visit the root node 1 from left to right. Zigzag Traversal: [1]
Level 2: Visit nodes at this level in a right-to-left order. Zigzag Traversal:  [1], [2]
Level 3: Visit nodes at this level in a left-to-right order. Zigzag Traversal:  [1], [3, 2], [4, 5]
Level 4: Visit nodes at this level in a right-to-left order. Zigzag Traversal:  [1], [3, 2], [4, 5], [8, 7]
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
