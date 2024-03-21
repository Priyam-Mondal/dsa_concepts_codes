/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node left;
     public Node right;

     Node()
     {
         this.data = 0;
         this.left = null;
         this.right = null;
     }

     Node(int data)
     {
         this.data = data;
         this.left = null;
         this.right = null;
     }

     Node(int data, Node left, Node right)
     {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }

 *****************************************************************/
public class Solution {

    static Node helper(int[] arr, int index){
        if(index>=arr.length){
            return null;
        }

        Node root=new Node(arr[index]);

        //left part
        root.left=helper(arr, 2*index+1);
        
        //right part
        root.right=helper(arr, 2*index+2);

        return root;
    }
    public static Node createTree(int []arr){
        
        if(arr==null || arr.length==0){
            return null;
        }

        return helper(arr,0);
        
    }
}