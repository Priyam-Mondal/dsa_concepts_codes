/*
Push :
	When inserting new node, insert at beginning so that pop can be done in O(1)
Pop:
	Delete head node
 */



 /****************************************************************

 Following is the class structure of the Node class:

 static class Node
 {
     int data;
     Node next;
     Node()
     {
         this.data = 0;
         this.next = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 };


 *****************************************************************/
public class Solution {
    static class Stack {
        
        Node head;
        int size;
        Stack()
        {
            this.head=null;
            this.size=0;
        }

        int getSize()
        {
            return this.size;
        }

        boolean isEmpty()
        {
            return head==null;
        }

        void push(int data)
        {
            Node newNode=new Node(data);
            // inserting at front
            newNode.next=head;
            head=newNode;
            this.size++;
        }

        int pop()
        {
            if(head==null){
                return -1;
            }
            int val=head.data;
            this.size--;
            head=head.next;
            return val;
        }

        int getTop()
        {
            if(head==null){
                return -1;
            }
            return head.data;
        }
    }
}
