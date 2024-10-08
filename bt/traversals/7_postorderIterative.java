/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();

        if(root==null){
            return ans;
        }

        Stack<TreeNode> st=new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode t=st.pop();
            ans.add(t.val);
            
            //first put left child
            if (t.left != null) {
                st.push(t.left);
            }
            //then push right child
            if (t.right != null) {
                st.push(t.right);
            }
        }
        //reverse before returning
        Collections.reverse(ans);

        return ans;
    }
}