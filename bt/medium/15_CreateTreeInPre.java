public class 15_CreateTreeInPre {
    private static void createMapping(HashMap<Integer,Integer> nodeToMap, int inorder[], int n){
        for(int i=0; i<n; i++){
            nodeToMap.put(inorder[i], i); 
        }
    }

   
    private static TreeNode solve(int inorder[], int preorder[], int[] preIndex, int inStart, int inEnd, HashMap<Integer,Integer> nodeToMap, int n){
        // Base case: if the preorder index is out of bounds or the inorder indices are invalid
        if(preIndex[0] >= n || inStart > inEnd){
            return null; 
        }
        
        // Construct the root node using the value at the current preorder index
        int element = preorder[preIndex[0]];
        TreeNode root = new TreeNode(element);
        int position = nodeToMap.get(element); // Find the position of the root in inorder traversal
        preIndex[0]++; // Move to the next element in the preorder traversal
        
        // Recursive call to construct left subtree using elements before root in inorder traversal
        root.left = solve(inorder, preorder, preIndex, inStart, position - 1, nodeToMap, n);
        // Recursive call to construct right subtree using elements after root in inorder traversal
        root.right = solve(inorder, preorder, preIndex, position + 1, inEnd, nodeToMap, n);
        
        return root; 
    }
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // (node, index) in inorder
        HashMap<Integer,Integer> nodeToMap = new HashMap<>();
        
        int n = preorder.length; 
        createMapping(nodeToMap, inorder, n); 
        
        int[] preIndex = new int[1]; // Create an array to hold the current index of the preorder traversal
        // Call the recursive method to construct the tree and return the root node
        TreeNode root = solve(inorder, preorder, preIndex, 0, n - 1, nodeToMap, n);
        
        return root; 
    }
}
