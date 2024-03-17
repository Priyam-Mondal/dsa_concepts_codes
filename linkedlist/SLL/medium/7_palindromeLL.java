class Solution {
    public ListNode reverse(ListNode head){
        if(head==null){
            return head;
        }
        ListNode pre=null;
        ListNode cur=head;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
    public boolean isPalindrome(ListNode head) {
        if(head.next==null){
            return true;
        }

        // finding mid node
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode mid=slow;

        // reversing 2nd half
        ListNode temp=mid.next;
        mid.next=reverse(temp);

        // comparing both halves
        ListNode head1=head;
        ListNode head2=mid.next;
        while(head2!=null){
            if(head1.val!=head2.val){
                return false;
            }
            head1=head1.next;
            head2=head2.next;
        }

        return true;
    }
}