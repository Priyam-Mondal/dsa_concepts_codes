class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Call helper function to recursively find the largest BST subtree
        Tuple ans = helper(root);
        // Return the size of the largest BST subtree
        return ans.size;
    }
    
    // Helper function to recursively find the largest BST subtree
    static Tuple helper(Node root){
        // Base case: If the current node is null, return a Tuple representing an empty subtree
        if(root == null){
            return new Tuple(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0);
        }
        
        // Recursively calculate the Tuple for the left subtree
        Tuple l = helper(root.left);
        // Recursively calculate the Tuple for the right subtree
        Tuple r = helper(root.right);
        
        // Create a new Tuple to represent the current subtree
        Tuple cur = new Tuple();
        
        // Update the maximum value of the current subtree
        cur.maxi = Math.max(root.data, r.maxi);
        // Update the minimum value of the current subtree
        cur.mini = Math.min(root.data, l.mini);
        
        // Check if the current subtree is a valid BST
        if(l.valid && r.valid && (root.data > l.maxi && root.data < r.mini)){
            // If the current subtree is a valid BST, update the size accordingly
            cur.valid = true;
            cur.size = l.size + r.size + 1;
        }else{
            // If the current subtree is not a valid BST, set valid flag to false
            cur.valid = false;
            // Set the size of the current subtree to the maximum size of its left or right subtree
            cur.size = Math.max(l.size, r.size);
        }
        
        // Return the Tuple representing the current subtree
        return cur;
    }
    
}

// Class representing a Tuple to store information about a subtree
class Tuple{
    int maxi; // Maximum value in the subtree
    int mini; // Minimum value in the subtree
    boolean valid; // Flag indicating whether the subtree is a valid BST
    int size; // Size of the subtree
    Tuple(){
        
    }
    
    // Constructor to initialize a Tuple object
    Tuple(int maxi, int mini, boolean valid, int size){
        this.maxi = maxi;
        this.mini = mini;
        this.valid = valid;
        this.size = size;
    }
}
