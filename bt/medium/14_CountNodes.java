/*Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled 
in a complete binary tree, and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

*/




public class 14_CountNodes {

    public int countNodes(TreeNode root) {
        
        if(root==null){
            return 0;
        }
        
        // Get the height of the left subtree
        int lh=getHeightLeft(root.left);
        // Get the height of the right subtree
        int rh=getHeightRight(root.right);

        // If the left subtree and right subtree have the same height,
        // it indicates that the tree is a complete binary tree
        if(lh==rh) {
            // In a complete binary tree, the total number of nodes can be calculated as 2^h - 1
            // where h is the height of the tree
            return (2<<lh)-1;
        }
        // If the left subtree and right subtree have different heights,
        // the tree is not a complete binary tree
        else{
            // Recursively count nodes in the left subtree and right subtree,
            // and add 1 for the root node
            return countNodes(root.left)+countNodes(root.right)+1;
        }
    }
    
    
    static int getHeightLeft(TreeNode root){
        int h=0;
        
        while(root!=null){
            h++;
            root=root.left;
        }
        return h;
    }
    
    
    static int getHeightRight(TreeNode root){
        int h=0;
        
        while(root!=null){
            h++;
            root=root.right;
        }
        return h;
    }
}
