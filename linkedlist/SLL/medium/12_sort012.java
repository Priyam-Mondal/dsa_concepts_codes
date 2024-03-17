public class Solution
{
    public static Node sortList(Node head) {
        if(head==null || head.next==null){
            return head;
        }
        // creating dummy node
        Node zeroHead = new Node();
        Node zeroTail = zeroHead;

        Node oneHead = new Node();
        Node oneTail = oneHead;

        Node twoHead = new Node();
        Node twoTail = twoHead;

        Node cur = head;
        // creating 3 separate list for 0s 1s 2s
        while(cur!=null){
            int val = cur.data;
            if(val==0){
                zeroTail.next=cur;
                zeroTail=cur;
            } else if(val==1){
                oneTail.next=cur;
                oneTail=cur;
            } else{
                twoTail.next=cur;
                twoTail=cur;
            }
            cur=cur.next;
        }
        // merging 3 lists
        head=zeroHead.next;
        // checking if 1s list not empty
        if(oneHead.next!=null){
            zeroTail.next=oneHead.next;
            oneTail.next=twoHead.next;
            twoTail.next=null;
        } else{
            zeroTail.next=twoHead.next;
        }
        // free memory 
        zeroHead=null;
        oneHead=null;
        twoHead=null;

        return head;
    }
}