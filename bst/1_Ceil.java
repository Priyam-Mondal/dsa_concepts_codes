package bst;

public class 1_Ceil {
    int findCeil(Node root, int key) {
        int[] ceil={Integer.MAX_VALUE};
        helper(root,key,ceil);
        if(ceil[0]==Integer.MAX_VALUE){
            return -1;
        }
        return ceil[0];
    }
    static void helper(Node root,int key,int[] ceil){
        if(root==null){
            return;
        }
        if(root.data==key){
            ceil[0]=root.data;
        }
        else if(root.data>key){
            //min value that is grater than key
            ceil[0]=Math.min(ceil[0],root.data);
            helper(root.left,key,ceil);
        }else{
            helper(root.right,key,ceil);
        }
    }
}
