package bst;


public class 8_MergeBST {

    void convertToDLL(TreeNode root, TreeNode head){
        if(root==null){
            return null;
        }
        
        //convert right part
        convertToDLL(root.right, head);
        
        //connect root.right to head of right converted DLL
        root.right = head;
        if(head!=null){
            head.left = root;
        }
        //modify head
        head = root;
        
        //convert left part
        convertToDLL(root.left, head);

    }
    
    TreeNode mergeDll(TreeNode head1, TreeNode head2){
        TreeNode head = null;
        TreeNode tail = null;
        
        while(head1!=null && head2!=null){
            if(head1.data < head2.data){
                if(head==null){
                    head = head1;
                    tail = head1;
                    head1 = head1.right;
                }
                else{
                    tail.right = head1;
                    head1.left = tail;
                    tail = head1;
                    head1 = head1.right;
                }
            }
            else{
                if(head==null){
                    
                }
                else{
                    tail.right = head2;
                    head2.left = tail;
                    tail = head2;
                    head1 = head2.right;
                }
            }
        }
        while(head1!=null){
            tail.right = head1;
            head1.left = tail;
            tail = head1;
            head1 = head1.right;
        }
        while(head2!=null){
            tail.right = head2;
            head2.left = tail;
            tail = head2;
            head1 = head2.right;
        }
        
        return head;
    }
    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        // convert into DLL
        TreeNode head1 = null;
        convertToDLL(root1, head1);
        head1.left=null;
        
        TreeNode head2 = null;
        convertToDLL(root2, head2);
        head2.left=null;

        //merge two sorted linked list
        TreeNode head = mergeDll(head1, head2);

        return head;


    }
}