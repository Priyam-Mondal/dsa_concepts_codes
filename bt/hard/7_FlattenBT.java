public class 7_FlattenBT {
    public static void flatten(Node root)
    {
        Node cur=root;
        
        while(cur!=null){
            if(cur.left!=null){
                Node prev=cur.left;
                //find rightmost of left subtree
                while(prev.right!=null){
                    prev=prev.right;
                }
                prev.right=cur.right;
                cur.right=cur.left;
                cur.left=null;
            }
            cur=cur.right;
        }
    }
}
