/*Given a Binary Tree of size N, you need to find all the possible paths 
from the root node to all the leaf nodes of the binary tree.

Example 1:

Input:
       1
    /     \
   2       3
Output: 
1 2 
1 3 
Explanation: 
All possible paths:
1->2
1->3

Example 2:

Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 
10 20 40 
10 20 60 
10 30  */


import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class 1_RootToLeaves {
    // Method to find all paths from root to leaf nodes
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // Create a list to store all the paths
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // Create a list to store the current path
        ArrayList<Integer> temp = new ArrayList<>();
        // Helper function to find paths
        helper(root, temp, ans);
        // Return all paths found
        return ans;
    }

    // Helper function to recursively find paths
    static void helper(Node root, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans) {
        // Base case: If the root is null, return
        if (root == null) {
            return;
        }

        // Add the current node's value to the path
        temp.add(root.data);
        
        // If it's a leaf node, add the path to the answer
        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(temp));
        } else {
            // Continue traversing the left and right subtrees
            helper(root.left, temp, ans);
            helper(root.right, temp, ans);
        }
        
        // Backtrack: Remove the last element (current node) from the path
        temp.remove(temp.size()-1);
    }

    public static void main(String args[]) {
        // Sample tree creation
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        // Find all paths from root to leaf nodes
        ArrayList<ArrayList<Integer>> result = Paths(root);

        // Print all the paths found
        for (ArrayList<Integer> path : result) {
            for (Integer nodeValue : path) {
                System.out.print(nodeValue + " ");
            }
            System.out.println();
        }
    }
}
