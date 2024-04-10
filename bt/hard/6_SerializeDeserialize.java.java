
public class 6_SerializeDeserialize.java {

    public String serialize(TreeNode root) {
        if(root==null){
            return ""; // If the root is null, return an empty string.
        }

        Queue<TreeNode> q=new LinkedList<>(); // Create a queue to perform level order traversal.
        StringBuilder data=new StringBuilder(); // StringBuilder to construct the serialized string.

        q.offer(root); // Add the root node to the queue.

        // Perform level order traversal
        while(!q.isEmpty()){
            TreeNode t=q.poll(); // Dequeue the node.

            if(t==null){
                data.append("n "); // If the node is null, append "n" to represent null node.
                continue;
            }

            data.append(t.val+" "); // Append the value of the current node followed by a space.

            // Enqueue the left and right children of the current node.
            q.offer(t.left);
            q.offer(t.right);
        }

        return data.toString(); // Return the serialized string.
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==""){
            return null; // If the serialized data is empty, return null.
        }

        Queue<TreeNode> q=new LinkedList<>(); // Create a queue to reconstruct the tree.
        String[] sArr=data.split(" "); // Split the serialized string into an array.
        TreeNode root=new TreeNode(Integer.parseInt(sArr[0])); // Create the root node.
        q.offer(root); // Add the root node to the queue.

        int ind=1; // Initialize index to traverse the array starting from index 1.
        while(!q.isEmpty()){
            TreeNode t=q.poll(); // Dequeue the node.

            // Process left child
            String leftData=sArr[ind++];
            if(!leftData.equals("n")){
                TreeNode leftChild=new TreeNode(Integer.parseInt(leftData));
                t.left=leftChild;
                q.offer(leftChild);
            }

            // Process right child
            String rightData=sArr[ind++];
            if(!rightData.equals("n")){
                TreeNode rightChild=new TreeNode(Integer.parseInt(rightData));
                t.right=rightChild;
                q.offer(rightChild);
            }
        }
        return root; // Return the root of the reconstructed tree.
    }
    
}