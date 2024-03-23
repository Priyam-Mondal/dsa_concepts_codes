/*

Same as right view. Just recursive call to left subtree would be before right subtree.

 */
class Solution {

    static void helper(TreeNode root, List<Integer> ans, int lvl){
        if(root==null){
            return;
        }

        if(lvl == ans.size()){
            ans.add(root.val);
        }

        helper(root.left, ans, lvl+1);
        helper(root.right,ans,lvl+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans=new ArrayList<>();
        helper(root, ans, 0);

        return ans;
    }
}