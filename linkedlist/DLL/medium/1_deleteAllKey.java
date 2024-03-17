/*Input: Linked List: 10 <-> 4 <-> 10 <-> 3 <-> 5 <-> 20 <-> 10 and ‘k’ = 10

Output: Modified Linked List: 4 <-> 3 <-> 5 <-> 20

Explanation: All the nodes having ‘data’ = 10 are removed from the linked list

Sample Input 1:
7
10 4 10 3 5 20 10
10

Sample Output 1:
4 3 5 20

Explanation Of Sample Input 1:
All the nodes having ‘data’ = 10 are removed from the linked list.

Sample Input 2:
7
10 4 10 3 5 20 10
30

Sample Output 2:
10 4 10 3 5 20 10

Explanation Of Sample Input 2:
The linked list does not have any node with ‘data’ = 30. So the linked list is unchanged.

*/

public static Node deleteAllOccurrences(Node head, int k) {
    // Start traversing the linked list from the head
    Node t = head;
    while (t != null) {
        // Check if the current node's data matches the value to be deleted
        if (t.data == k) {
            // If the node to be deleted is the head node
            if (t == head) {
                // Update the head to the next node
                head = head.next;
            }
            // Store references to the next and previous nodes of the current node
            Node nextNode = t.next;
            Node prevNode = t.prev;
            // Update the next node's previous reference if it exists
            if (nextNode != null) 
                nextNode.prev = prevNode;
            // Update the previous node's next reference if it exists
            if (prevNode != null) 
                prevNode.next = nextNode;

            // Move to the next node
            t = nextNode;
        } else {
            // If the current node's data doesn't match the value to be deleted, move to the next node
            t = t.next;
        }
    }

    // Return the head of the modified linked list
    return head;
}
