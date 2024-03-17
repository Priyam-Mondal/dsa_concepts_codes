public class Solution {
    // Function to find the first node of a cycle in a linked list
    public static Node firstNode(Node head) {
        // If the list is empty or has only one node, there's no cycle
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize two pointers, slow and fast, both starting from the head
        Node slow = head;
        Node fast = head;

        // Move the slow pointer by one step and the fast pointer by two steps
        // If there's a cycle, they will eventually meet
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If fast or its next or next.next is null, there's no cycle
            if (fast == null || fast.next == null || fast.next.next == null) {
                return null;
            }

            // If slow and fast meet, there's a cycle
            if (slow == fast) {
                break;
            }
        }

        // Reset the slow pointer to the head
        slow = head;

        // Move both pointers (slow and fast) at the same speed
        // The point where they meet is the start of the cycle
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Return the node where the slow and fast pointers meet (start of the cycle)
        return slow;
    }
}
