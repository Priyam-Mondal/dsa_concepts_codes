public class Solution
{
    public static Node reverseDLL(Node head){
        if(head.next==null){
        return head;
    }
    Node last=null;
    Node cur=head;

    while(cur!=null){
        last=cur.prev;
        cur.prev=cur.next;
        cur.next=last;

        cur=cur.prev;
    }
    return last.prev;
    }
}