package bst;

public class 4_CheckBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    static boolean helper(TreeNode root, long mini, long maxi){
        if(root==null){
            return true;
        }
        //outside of the range
        if(root.val<=mini || root.val>=maxi){
            return false;
        }
        //check for both left and right subtree
        return helper(root.left,mini,root.val) && helper(root.right,root.val,maxi);
    }
}
