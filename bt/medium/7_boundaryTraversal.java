import java.util.ArrayList;
import java.util.List;


public class Solution {

    static void traverseLeft(TreeNode root, List<Integer> ans){
        if(root==null || root.left==null && root.right==null){
            return;
        }

        ans.add(root.data);
        if(root.left!=null){
            traverseLeft(root.left, ans);
        }else{
            traverseLeft(root.right, ans);
        }
    }
    static void traverseRight(TreeNode root, List<Integer> ans){
        if(root==null || root.left==null && root.right==null){
            return;
        }

        if(root.right!=null){
            traverseRight(root.right, ans);
        }else{
            traverseRight(root.left, ans);
        }
        ans.add(root.data);
    }

    static void traverseLeaf(TreeNode root, List<Integer> ans){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            ans.add(root.data);
        }
        //calculate leaf boundary for left and right subtree
        traverseLeaf(root.left, ans);
        traverseLeaf(root.right, ans);
    }
    public static List<Integer> traverseBoundary(TreeNode root){
        
        List<Integer> ans=new ArrayList<>();

        if(root==null){
            return ans;
        }

        //root always be a part of boundary
        ans.add(root.data);

        //add left boundary excluding leaf nodes
        traverseLeft(root.left,ans);

        //add leaf nodes for left and right subtrees
        traverseLeaf(root.left,ans);
        traverseLeaf(root.right,ans);

        //add right boundary
        traverseRight(root.right, ans);

        return ans;


    }
}