public class Solution {
    // Function to find the middle node of a linked list
    static Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next; // Initially, move fast pointer two steps ahead

        // Traverse the list until fast reaches the end (or null)
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer one step ahead
            fast = fast.next.next; // Move fast pointer two steps ahead
        }

        return slow; // Return the middle node
    }

    // Function to merge two sorted linked lists
    static Node merge(Node fir, Node sec) {
        Node t1 = fir;
        Node t2 = sec;
        Node dummy = new Node(-1); // Dummy node to simplify merging
        Node temp = dummy; // Pointer to the current node of the merged list

        // Merge the two lists while maintaining the sorted order
        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                temp.next = t1;
                temp = temp.next;
                t1 = t1.next;
            } else {
                temp.next = t2;
                temp = temp.next;
                t2 = t2.next;
            }
        }

        // Append the remaining nodes of either list, if any
        if (t1 != null) {
            temp.next = t1;
        } else {
            temp.next = t2;
        }

        return dummy.next; // Return the head of the merged list
    }

    // Function to perform merge sort on a linked list
    public static Node sortList(Node head) {
        // Base case: If the list is empty or has only one node, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle node of the list
        Node mid = findMid(head);

        // Split the list into two halves at the middle node
        Node right = mid.next; // Start of the second half
        mid.next = null; // Disconnect the first half from the second half
        Node left = head; // Start of the first half

        // Recursively sort both halves
        left = sortList(left);
        right = sortList(right);

        // Merge the sorted halves
        Node mergeHead = merge(left, right);

        return mergeHead; // Return the head of the sorted list
    }
}
