public class Solution {
    public static Node deleteMiddle(Node head) {

        if(head.next==null){
            return null;
        }

        Node slow=head;
        Node fast=head.next.next;

        while(fast!=null && fast.next!=null){

            fast=fast.next.next;
            slow=slow.next;
            
        }
        slow.next=slow.next.next;
        
        return head;

    }
}