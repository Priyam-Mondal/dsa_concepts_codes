/*

    // Current position of node in the tree
    // Node: x (column), y (row)
    // For demonstration purposes:
    //          0
    //         / \
    //       -1   1
    //      / \   \
    //    -2  -1   1
    //        /   / \
    //      -1   0   2
    //    Node: (x, y)
*/


class Tuple {
    TreeNode node;  // The TreeNode
    int row;        // The row index in the grid
    int col;        // The column index in the grid
    
    // Constructor to initialize Tuple object
    public Tuple(TreeNode _node, int _row, int _col) {
        node = _node;
        row = _row;
        col = _col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        // List to store the result
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null){
            return ans;
        }

        // TreeMap to store nodes vertically
        // Outer TreeMap: key is the column index
        // Inner TreeMap: key is the row index
        // PriorityQueue: to store nodes with the same position, ordered by value
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // Queue for level order traversal
        Queue<Tuple> q = new LinkedList<Tuple>();

        // Start with the root node at position (0, 0)
        q.offer(new Tuple(root, 0, 0));

        // Level order traversal
        while(!q.isEmpty()){
            Tuple tup = q.poll();
            
            TreeNode node = tup.node;
            int x = tup.row;    // Current row index
            int y = tup.col;    // Current column index
            
            // Initialize map entries if not present
            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            
            // Insert node value into the appropriate position in the map
            map.get(x).get(y).offer(node.val);

            // Add left child to the queue with adjusted position
            if(node.left != null){
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            
            // Add right child to the queue with adjusted position
            if(node.right != null){
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        // Traverse the map to construct the result
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : ys.values()){
                // Add nodes with the same position to the result
                while(!nodes.isEmpty()){
                    ans.get(ans.size() - 1).add(nodes.poll());
                }
            }
        }

        return ans;
    }
}
