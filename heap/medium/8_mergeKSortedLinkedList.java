/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Custom comparator to compare ListNode objects based on their values.
class MyComparator implements Comparator<ListNode> {
    // Compare method to compare two ListNode objects based on their values.
    public int compare(ListNode a, ListNode b) {
        int aData = a.val;
        int bData = b.val;

        if (aData < bData) return -1;
        else if (aData > bData) return 1;
        else return 0;
    }
}

class Solution {
    // Method to merge k sorted linked lists.
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;

        // If the array of lists is empty, return null.
        if (k == 0) {
            return null;
        }

        // Priority queue to store ListNode objects based on their values.
        // Custom comparator is used for ordering the elements.
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new MyComparator());

        // Add the first nodes of every list in the queue.
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                minHeap.add(lists[i]);
            }
        }

        ListNode head = null, tail = null;

        // Iterate through the minHeap until it's empty.
        while (!minHeap.isEmpty()) {
            // Get the minimum node from the minHeap.
            ListNode minNode = minHeap.poll();

            // If head is null, set head and tail to the first minimum node.
            if (head == null) {
                head = minNode;
                tail = minNode;
            } else {
                // Otherwise, link the next minimum node to the tail and update tail.
                tail.next = minNode;
                tail = tail.next;
            }

            // If the minimum node has a next node, add it to the minHeap and set its next to null.
            if (minNode.next != null) {
                minHeap.add(minNode.next);
                minNode.next = null;
            }
        }

        return head;
    }
}
