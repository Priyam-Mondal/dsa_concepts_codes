package bst;

public class 6_CreateBSTInPre {
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] ind={0};
        return helper(preorder,Integer.MAX_VALUE,ind);
    }
    static TreeNode helper(int[] preorder, int up_bound, int[] ind){
        //exhaust the preorder or value > root val
        if(ind[0]>=preorder.length || preorder[ind[0]]>up_bound){
            return null;
        }
        TreeNode root=new TreeNode(preorder[ind[0]++]);
        //go left, up_bound will be root.val
        root.left=helper(preorder,root.val,ind);
        //go right, up_bound will be previous up_bound
        root.right=helper(preorder,up_bound,ind);
        return root;
    }
}
