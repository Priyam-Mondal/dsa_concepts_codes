public class 16_CreateTreeInPost {
    private static void createMapping(HashMap<Integer,Integer> nodeToMap, int inorder[], int n){
        for(int i=0; i<n; i++){
            nodeToMap.put(inorder[i], i); 
        }
    }

    
    private static TreeNode solve(int inorder[], int postorder[],int[] postIndex,int inStart, int inEnd,HashMap<Integer,Integer> nodeToMap, int n){
        // Base case: if the postorder index is out of bounds or the inorder range is invalid, return null.
        if(postIndex[0]<0 || inStart>inEnd){
            return null;
        }
        
        // Get the next element from the postorder array and decrement the postorder index.
        int element = postorder[postIndex[0]--];
        TreeNode root = new TreeNode(element); // Create a new node with the current element.
        int position = nodeToMap.get(element); // Find the position of the current element in the inorder array.
        
        // Recursively construct the right subtree.
        root.right = solve(inorder,postorder,postIndex,position+1,inEnd,nodeToMap,n);
        // Recursively construct the left subtree.
        root.left = solve(inorder,postorder,postIndex,inStart,position-1,nodeToMap,n);
        
        return root; 
    }

   
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> nodeToMap = new HashMap<>();
        
        int n = postorder.length;
        createMapping(nodeToMap, inorder, n); // Create the mapping of nodes to their indices.
        
        int[] postIndex = new int[1]; // Initialize the postorder index.
        postIndex[0]=n-1; // Start from the last element of the postorder array.
        TreeNode root = solve(inorder, postorder, postIndex, 0, n-1, nodeToMap, n); // Construct the tree.
        
        return root; 
    }
}
