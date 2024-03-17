/*head = [1,2,3,4,5] k = 2000000000

If we see a brute force approach, it will take O(5*2000000000) which is not 
a good time complexity when we can optimize it.

We can see that for every k which is multiple of the length of the list, 
we get back the original list. 
Try to operate brute force on any linked list for k as a multiple of the length of the list.

This gives us a hint that for k greater than the length of the list, 
we have to rotate the list for k%length of the list. This reduces our time complexity.

Steps to the algorithm:-

    1.Calculate the length of the list.
    2.Connect the last node to the first node, converting it to a circular linked list.
    3.Iterate to cut the link of the last node and start a node of k%length of the list rotated list. */




public class Solution {

    // Helper function to find the n-th node from the head of the list
    private static Node findNthNode(Node head, int steps) {
        steps--; // Adjust steps since indexing starts from 1
        Node t = head;
        while (t != null && steps > 0) {
            t = t.next;
            steps--;
        }
        return t;
    }
    
    // Function to rotate the given linked list by k positions
    public static Node rotate(Node head, int k) {
        // Find the length of the linked list and locate its tail
        Node tail = head;
        int len = 1;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        // If k is a multiple of the list length, no rotation is needed
        if (k % len == 0) {
            return head;
        } else {
            // Calculate the effective rotation steps
            k = k % len;
            // Find the new last node after rotation
            Node newLast = findNthNode(head, len - k);
            // Connect the tail of the original list to the head
            tail.next = head;
            // Update the head to the node after the new last node
            head = newLast.next;
            // Break the link from the new last node to the next node to complete rotation
            newLast.next = null;
        }
        // Return the head of the rotated list
        return head;
    }
}
