public class Solution {
    // Function to segregate even and odd nodes in a linked list
    public static Node segregateEvenOdd(Node head) {
        // Create separate lists for even and odd nodes
        Node even = new Node(0);  // Dummy node for even list
        Node evenTemp = even;      // Pointer to the end of even list
        Node odd = new Node(0);   // Dummy node for odd list
        Node oddTemp = odd;        // Pointer to the end of odd list

        // Traverse the original linked list
        Node temp = head;
        while (temp != null) {
            // If the current node's data is even, add it to the even list
            if (temp.data % 2 == 0) {
                evenTemp.next = new Node(temp.data);
                evenTemp = evenTemp.next;
            } else { // If the current node's data is odd, add it to the odd list
                oddTemp.next = new Node(temp.data);
                oddTemp = oddTemp.next;
            }
            temp = temp.next; // Move to the next node in the original list
        }

        // Remove the dummy nodes and get the actual start nodes of even and odd lists
        even = even.next;
        odd = odd.next;

        // Connect the end of the even list to the start of the odd list
        temp = even;
        while (temp.next != null) {
            temp = temp.next; // Move to the end of the even list
        }
        temp.next = odd; // Connect the end of the even list to the start of the odd list

        // Return the head of the segregated list (even list followed by odd list)
        return even;
    }
}
