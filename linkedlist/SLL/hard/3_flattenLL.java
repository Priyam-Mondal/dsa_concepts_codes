public class Solution {
    // Helper function to merge two linked lists
    // Time Complexity: O(n + m), where n and m are the lengths of the input lists 'a' and 'b', respectively.
    static Node mergeTwoLists(Node a, Node b) {
        // Create a dummy node to facilitate merging
        Node temp = new Node(0);
        Node res = temp; // Pointer to the result
        
        // Merge nodes from lists 'a' and 'b' in sorted order
        while(a != null && b != null) {
            if(a.data < b.data) {
                temp.child = a; 
                temp = temp.child; 
                a = a.child; 
            } else {
                temp.child = b;
                temp = temp.child; 
                b = b.child; 
            }
        }
        
        // Append the remaining nodes from 'a' or 'b'
        if(a != null) temp.child = a; 
        else temp.child = b;
        
        // Return the merged list
        return res.child; 
    }
    
    // Function to flatten a given linked list
    // Time Complexity: O(n * m), where n is the number of nodes in the main list and m is the average number of nodes in child lists.
    public static Node flattenLinkedList(Node head) {
        // Base case: if the list is empty or has only one node, return the list as it is
        if(head == null || head.next == null) {
            return head;
        }

        // Recursively flatten the next level (linked list after 'head')
        Node mergedHead = flattenLinkedList(head.next);
        
        // Merge the current level (head) with the flattened next level
        head.next = mergeTwoLists(head, mergedHead);

        // Return the flattened list
        return head;
    }
}
