/*Input : 1 -> 2 -> 3 -> 4 -> 'NULL'  and  'K' = 2
Output: 1 -> 2 -> 4 -> 'NULL'
Explanation:
After removing the second node from the end, the linked list become 1 -> 2 -> 4 -> 'NULL'. */



public class Solution {
    // Function to remove the kth node from the end of a linked list
    public static Node removeKthNode(Node head, int K) {
        // Initialize two pointers, slow and fast, both starting from the head
        Node slow = head;
        Node fast = head;
        
        // Move the fast pointer K steps ahead
        for (int i = 0; i < K; i++) {
            fast = fast.next;
        }

        // If fast becomes null, it means we need to remove the first node
        // Return the head's next node in this case
        if (fast == null) {
            head = head.next;
            return head;
        }
        
        // Move both slow and fast pointers until fast reaches the end of the list
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the kth node by skipping over it
        slow.next = slow.next.next;

        // Return the head of the modified list
        return head;
    }
}
