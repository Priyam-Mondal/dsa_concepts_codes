/*

Keep the track of current level.
If the currrent level== ans.size() add new node.
By doing this we are addding this only rightmost node for each level.

 */
class Solution {

    static void helper(TreeNode root, List<Integer> ans, int lvl){
        if(root==null){
            return;
        }

        if(lvl == ans.size()){
            ans.add(root.val);
        }

        helper(root.right,ans,lvl+1);
        helper(root.left, ans, lvl+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans=new ArrayList<>();
        helper(root, ans, 0);

        return ans;
    }
}