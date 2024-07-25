public class 8_MorrisInorder {

    ArrayList<Integer> inOrder(Node root)
    {
        
        ArrayList<Integer> in=new ArrayList<>();
        Node cur=root;
        
        while(cur!=null){
            if(cur.left==null){
                in.add(cur.data);
                cur=cur.right;
            }else{
                //find rightmost node of left subtree
                Node prev=cur.left;
                while(prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                }
                //create the thread
                if(prev.right==null){
                    prev.right=cur;
                    //go to left subtree
                    cur=cur.left;
                }else{
                    //delete the thread
                    prev.right=null;
                    //add into ans the root data
                    in.add(cur.data);
                    //move cur to right subtree
                    cur=cur.right;
                    
                }
            }
        }
        return in;
    }
}

