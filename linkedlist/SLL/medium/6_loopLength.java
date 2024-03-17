public class Solution {
    // Function to find the length of the loop in a linked list
    public static int lengthOfLoop(Node head) {
        // If the list is empty or has only one node, there's no loop
        if (head == null || head.next == null) {
            return 0;
        }

        // Initialize two pointers, slow and fast, both starting from the head
        Node slow = head;
        Node fast = head;

        // Move the slow pointer by one step and the fast pointer by two steps
        // If there's a loop, they will eventually meet
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If fast or its next or next.next is null, there's no loop
            if (fast == null || fast.next == null || fast.next.next == null) {
                return 0;
            }

            // If slow and fast meet, there's a loop
            if (slow == fast) {
                break;
            }
        }

        // Reset the slow pointer to the head
        slow = head;

        // Move both pointers (slow and fast) at the same speed until they meet again
        // This gives us the length of the loop
        int cnt = 1;
        while (fast.next != slow) {
            cnt++;
            fast = fast.next;
        }

        // Return the length of the loop
        return cnt;
    }
}
