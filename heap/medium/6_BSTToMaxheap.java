/*Input :
                 4
               /   \
              2     6
            /  \   /  \
           1   3  5    7  

Output : 1 2 3 4 5 6 7 
Exaplanation :
               7
             /   \
            3     6
          /   \  /   \
         1    2 4     5
The given BST has been transformed into a
Max Heap and it's postorder traversal is
1 2 3 4 5 6 7. */


class Solution
{
    static ArrayList<Integer> in=new ArrayList<>();
    static int index=0;
    
    static void inOrder(Node root){
        if(root==null){
            return;
        }
        
        inOrder(root.left);
        in.add(root.data);
        inOrder(root.right);
    }
    
    static void populatePostOrder(Node root){
        if(root==null){
            return;
        }
        
        
        
        populatePostOrder(root.left);
        populatePostOrder(root.right);
        //populating tree
        root.data=in.get(index++);
    }
    
    public static void convertToMaxHeapUtil(Node root)
    {
        
        
        //step1: calculate inorder(sorted for BST)
        inOrder(root);
        
        //step2: populate tree as postorder manner
        //      take value from inorder and put in tree in LRN(postorder) manner
        populatePostOrder(root);
        
    }
}