public class Solution {
    // Function to add two numbers represented by linked lists
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode t1 = head1; // Pointer for the first linked list
        LinkedListNode t2 = head2; // Pointer for the second linked list

        LinkedListNode dummy = new LinkedListNode(-1); // Dummy node to simplify adding
        LinkedListNode temp = dummy; // Pointer to the current node of the result list

        int carry = 0; // Carry initially is zero
        
        // Traverse both lists until both are null and there's no carry left
        while (t1 != null || t2 != null || carry == 1) {

            int sum = 0;
            // Add the values of current nodes of both lists and the carry
            if (t1 != null) {
                sum += t1.data;
                t1 = t1.next;
            }
            if (t2 != null) {
                sum += t2.data;
                t2 = t2.next;
            }
            sum += carry;
            carry = sum / 10; // Calculate the new carry
            temp.next = new LinkedListNode(sum % 10); // Add the digit to the result list
            temp = temp.next; // Move to the next node in the result list
        }

        return dummy.next; // Return the head of the resulting linked list
    }
}

// Time Complexity: O(max(m, n)), where m and n are the lengths of the input linked lists
// Space Complexity: O(max(m, n)), where m and n are the lengths of the input linked lists
