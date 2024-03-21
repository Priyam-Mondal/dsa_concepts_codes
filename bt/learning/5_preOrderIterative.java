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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> ans=new ArrayList<>();

        if(root==null){
            return ans;
        }

        Stack<TreeNode> st=new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode t=st.pop();
            ans.add(t.val);
            
            //push right child first so we get left first when pop
            if (t.right != null) {
                st.push(t.right);
            }

            if (t.left != null) {
                st.push(t.left);
            }
        }

        return ans;
    }
}