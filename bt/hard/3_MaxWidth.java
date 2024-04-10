/*The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between 
the end-nodes (the leftmost and rightmost non-null nodes),
where the null nodes between the end-nodes that would be present in
a complete binary tree extending down to that level are also counted into the length calculation. 



Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
Example 2:


Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
Example 3:


Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).

*/





public class 3_MaxWidth {
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root==null){
            return 0;
        }
        // Initialize the maximum width to -1
        int ans = -1;
        // Create a queue of pairs to store nodes and their corresponding indices
        Queue<Pair> q = new LinkedList<>();

        // Add the root node along with its index 0 to the queue
        q.offer(new Pair(root, 0));

        
        while(!q.isEmpty()){
            // Get the size of the current level of the tree
            int size = q.size();
            // Get the minimum index of the current level
            int minIndex = q.peek().ind;
            // Initialize variables to store the indices of the first and last nodes in the current level
            int first = 0, last = 0;

            // Iterate through all nodes in the current level
            for(int i = 0; i < size; i++){
                // Remove a node from the queue
                Pair tp = q.poll();

                // Calculate the index of the current node relative to the minimum index of the level
                int curIndex = tp.ind - minIndex;
                TreeNode node = tp.node;

                // Update the first and last indices of the level
                if(i == 0){
                    first = curIndex;
                }
                if(i == size - 1){
                    last = curIndex;
                }
                
                // Add the left child to the queue with index calculated based on the current index
                if(node.left != null){
                    q.offer(new Pair(node.left, 2 * curIndex + 1));
                }
                // Add the right child to the queue with index calculated based on the current index
                if(node.right != null){
                    q.offer(new Pair(node.right, 2 * curIndex + 2));
                }
            }
            // Update the maximum width using the first and last indices of the current level
            ans = Math.max(ans, last - first + 1);        
        }
        
        return ans;
    }
}

class Pair{
    TreeNode node;
    int ind;
    
    Pair(TreeNode node, int ind){
        this.node = node;
        this.ind = ind;
    }
}