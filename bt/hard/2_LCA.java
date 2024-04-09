package bt.hard;

public class 2_LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: If the root is null or either p or q is found, return root
        if(root==null || root==p || root==q){
            return root;
        }

        // Recursively search for p and q in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If either left or right is null, it means both p and q are in the other subtree
        if(left==null){
            return right;
        } else if(right==null){
            return left;
        } else {
            // If both left and right are non-null, then root is the lowest common ancestor
            return root;
        }
    }
}
