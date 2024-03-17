/*Input:
n = 6
1<->1<->1<->2<->3<->4
Output:
1<->2<->3<->4
Explanation:
Only the first occurance of node with value 1 is 
retained, rest nodes with value = 1 are deleted.
Example 2:

Input:
n = 7
1<->2<->2<->3<->3<->4<->4
Output:
1<->2<->3<->4
Explanation:
Only the first occurance of nodes with values 2,3 and 4 are 
retained, rest repeating nodes are deleted. */


class Solution {
    
    Node removeDuplicates(Node head) {
       
        Node cur = head;          // Pointer to the current node
        Node front = head.next;   // Pointer to the next node
        
        // Iterate through the linked list until cur reaches the end
        while (cur != null) {
            // Move front until it reaches a node with different data than cur
            while (front != null && front.data == cur.data) {
                front = front.next;
            }
            // If front reaches the end, cur is the last node with unique data
            if (front == null) {
                // Disconnect cur from the subsequent nodes and break the loop
                cur.next = null;
                break;
            }
            // Connect cur to the next unique node pointed by front
            front.prev = cur;   
            cur.next = front;   
            
            // Move cur and front pointers to the next unique node
            cur = front;        
            front = front.next; 
        }
        
        return head;
    }
}
