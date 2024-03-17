public class Solution {
    // Function to reverse a linked list
    public static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        Node rest = reverseLinkedList(head.next);
        
        // Reverse the current node's pointer
        head.next.next = head;
        head.next = null;

        return rest;
    }

    // Function to add one to a linked list representing a non-negative integer
    public static Node addOne(Node head) {
        // Reverse the linked list to simplify addition
        Node revHead = reverseLinkedList(head);

        Node temp = revHead;
        int carry = 1; // Initial carry is 1 since we are adding 1
        int sum = 0;

        // Traverse the reversed list and add 1
        while (temp != null) {
            sum = temp.data + carry;
            temp.data = sum % 10; // Update the value of the current node with the sum modulo 10
            carry = sum / 10; // Update the carry for the next iteration

            // Break if there is no carry left
            if (carry == 0) {
                break;
            }

            // Add a new node if there's still a carry and we have reached the end of the list
            if (temp.next == null && carry > 0) {
                temp.next = new Node(carry);
                break;
            }
            temp = temp.next; // Move to the next node
        }

        // Reverse the modified linked list to get the final result
        Node ans = reverseLinkedList(revHead);

        return ans;
    }
    
}

// Time Complexity: O(n), where n is the number of nodes in the linked list
// Space Complexity: O(1), excluding the space required for the output (which is not extra space)
