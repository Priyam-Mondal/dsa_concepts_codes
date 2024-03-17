public class Solution
{
    public static Node findMiddle(Node head)
    {
        if(head==null || head.next==null){
            return head;
        }
        if(head.next.next==null){
            return head.next;
        }
        Node slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}