 public class Solution {
    public static int heightOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int height=Math.max(heightOfBinaryTree(root.left),heightOfBinaryTree(root.right)) +1;

        return height;
    }
}