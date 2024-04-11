package bst;

public class 2_Floor {
    public static int floor(Node root, int key) {
        int[] floor_ans={Integer.MIN_VALUE};
        helper(root,key,floor_ans);
        if(floor_ans[0]==Integer.MIN_VALUE){
            return -1;
        }
        return floor_ans[0];
    }
    static void helper(Node root,int key,int[] floor_ans){
        if(root==null){
            return;
        }
        if(root.data==key){
            floor_ans[0]=root.data;
        }
        else if(root.data>key){
            helper(root.left,key,floor_ans);
        }else{
            //max value which is less than key
            floor_ans[0]=Math.max(floor_ans[0],root.data);
            helper(root.right,key,floor_ans);
        }
    }
}
