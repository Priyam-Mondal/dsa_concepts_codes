public class Solution {
    public static Node cloneLL(Node head) {
        if (head == null) {
            return null;
        }
        
        Node t = head;

        // Step 1: Creating new nodes with t.data and placing in between original nodes
        while (t != null) {
            Node copy = new Node(t.data);
            copy.next = t.next;
            t.next = copy;
            t = copy.next;
        }

        // Step 2: Creating random pointers for copied nodes
        t = head;
        while (t != null) {
            if (t.random != null) {
                t.next.random = (t.random.next != null) ? t.random.next : null;
            }
            t = t.next.next;
        }

        // Step 3: Disconnecting copied nodes from original list and making separate list of copied nodes
        Node dummy = new Node(-1);
        Node res = dummy;
        t = head;
        while (t != null) {
            res.next = t.next;
            t.next = (t.next != null) ? t.next.next : null;
            res = res.next;
            t = (t.next != null) ? t.next : null;
        }

        return dummy.next;
    }
}
