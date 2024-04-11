package bst;


public class 3_KthSmall {

    public int kthSmallest(TreeNode root, int k) {
        int[] ans={-1};
        int[] counter={0};
        inorder(root,k,counter,ans);
        return ans[0];
    }
    static void inorder(TreeNode root, int k,int[] counter, int[] ans){
        if(root==null || counter[0]>k){
            return;
        }
        inorder(root.left,k,counter,ans);
        //when backtrack to node
        counter[0]++;
        if(counter[0]==k){
            ans[0]=root.val;
        }

        inorder(root.right,k,counter,ans);
    }
}