/*Given a Binary Tree, convert the value of its nodes to follow the Children Sum Property. 
The Children Sum Property in a binary tree states that for every node, 
the sum of its children's values (if they exist) should be equal to the node's value. 
If a child is missing, it is considered as having a value of 0.

Note:

The node values can be increased by any positive integer any number of times, but decrementing any node value is not allowed.
A value for a NULL node can be assumed as 0.
We cannot change the structure of the given binary tree. 



Example 1:
Input:Binary Tree: 2 35 10 2 3 5 2
				

Output: Binary Tree: 45 35 10 30 5 8 2

Explanation: We cannot decrement the value of the node but only increment. 
There are many different ways to do this but we have to ensure that we are 
only increasing the values of the nodes in such a way that its value is equal to the sum of its left and right children.

*/




package bt.hard;

public class 4_ChildSumProperty {
    // Function to change the values of the nodes
    // based on the sum of its children's values.
    public void changeTree(TreeNode root) {
        // Base case: If the current node
        // is null, return and do nothing.
        if (root == null) {
            return;
        }

        // Calculate the sum of the values of
        // the left and right children, if they exist.
        int child = 0;
        if (root.left != null) {
            child += root.left.val;
        }
        if (root.right != null) {
            child += root.right.val;
        }

        // Compare the sum of children with
        // the current node's value and update
        if (child >= root.val) {
            root.val = child;
        } else {
            // If the sum is smaller, update the
            // child with the current node's value.
            if (root.left != null) {
                root.left.val = root.val;
            } else if (root.right != null) {
                root.right.val = root.val;
            }
        }

        // Recursively call the function
        // on the left and right children.
        changeTree(root.left);
        changeTree(root.right);

        // Calculate the total sum of the
        // values of the left and right
        // children, if they exist.
        int tot = 0;
        if (root.left != null) {
            tot += root.left.val;
        }
        if (root.right != null) {
            tot += root.right.val;
        }

        // If either left or right child
        // exists, update the current node's
        // value with the total sum.
        if (root.left != null || root.right != null) {
            root.val = tot;
        }
    }
}
