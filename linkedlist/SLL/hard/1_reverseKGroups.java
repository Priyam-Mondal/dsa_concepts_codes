/*
`reverseLinkedList`: This function takes the head of a segment as input and 
                    reverses the linked list formed by that segment. 

`getKthNode`: The purpose of this function is to identify the end of a segment of K nodes 
            in the linked list. Given a starting node, it traverses K nodes in the list
             and returns the Kth node, allowing the segmentation of the list into smaller parts for reversal.

`kReverse`: It iterates through the linked list and identifies segments of K nodes using getKthNode. 
            For each identified segment, it utilizes reverseLinkedList to reverse
             the nodes within that segment. This iterative approach efficiently 
             reverses the linked list nodes in groups of K. 

*/


class Solution {

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }


    private static ListNode getkthNode(ListNode temp, int k) {
        k--;
        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        
        // Initialize a pointer to track the
        // last node of the previous group
        ListNode prevLast = null;
        
        // Traverse through the linked list
        while (temp != null) {
            
            // Get the Kth node of the current group
            ListNode kThNode = getkthNode(temp, k);
            
            // If the Kth node is NULL
            // (not a complete group)
            if (kThNode == null) {
               
                // If there was a previous group,
                // link the last node to the current node
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                
                // Exit the loop
                break;
            }
            
            // Store the next node
            // after the Kth node
            ListNode nextNode = kThNode.next;
            
            // Disconnect the Kth node
            // to prepare for reversal
            kThNode.next = null;
            
            // Reverse the nodes from
            // temp to the Kth node
            reverse(temp);
            
             // Adjust the head if the reversal
            // starts from the head
            if (temp == head) {
                head = kThNode;
            } else {
                // Link the last node of the previous
                // group to the reversed group
                prevLast.next = kThNode;
            }
            
            // Update the pointer to the
            // last node of the previous group
            prevLast = temp;
            
            // Move to the next group
            temp = nextNode;
        }
        
        // Return the head of the
        // modified linked list
        return head;
    }
}