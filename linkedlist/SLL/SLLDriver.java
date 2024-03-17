/*1. Write a menu driven program to implement a singly linked list with the following
operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list
d. Perform a linear search on the list
e. Insert an element after a specified element
f. Delete a specified element
g. Count the number of nodes
h. Reverse the list, so that the last element becomes the first, and so on
i. Concatenate two lists */


package DSA.LinkedList;
import java.util.*;

//separate node class
class Node<T>{
	T data;
	Node<T> next;

	Node(){

	}
	Node(T data){
		this.data=data;
		this.next=null;
	}
}

class SLL<T>{
	public Node<T> head;
	SLL(){
		this.head=null;
	}

	public void insertFront(T data) {
		//empty list
		if(head==null) {
			head=new Node<>(data);
		}else {
			Node<T> newNode=new Node<>(data);
			newNode.next=head;
			head=newNode;
		}
	}
	public void insertEnd(T data) {
		if(this.head==null) {
			this.head=new Node<>(data);
		}else {
			//traversing to last node then inserting in end
			Node<T> newNode=new Node<>(data);
			Node<T> temp=this.head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=newNode;
		}
	}
	public void insertAtPos(T data, int pos) {
		if(pos<1 || pos>nodeCount()+1) {
			System.out.println("Invalid position");
		}else if(pos==1) {
			insertFront(data);
		}else {
			Node<T> newNode=new Node<>(data);
			Node<T> temp=this.head;
			//traversing one node before where the newNode to insert
			for(int i=0; i<pos-2 && temp!=null; i++) {
				temp=temp.next;
			}
			if(temp==null) {
				System.out.println("Invalid position");
			}
			newNode.next=temp.next;
			temp.next=newNode;
		}
	}
	public void deleteFront() {
		if(head==null) {
			System.out.println("empty list");
		}else {
			//moving head one step ahead
			head=head.next;
		}
	}
	public void deleteEnd() {
		if(head==null) {
			System.out.println("Empty list");
		}else if(head.next==null) {
			head=null;
		}else {
			Node<T> temp=head;
			while(temp.next.next!=null) {
				temp=temp.next;
			}
			temp.next=null;
		}
	}
	public void deleteAtPos(int pos) {
		if(pos<1) {
			System.out.println("Invalid position");
		}else if(pos==1) {
			deleteFront();
		}else {
			Node<T> temp=this.head;
			for(int i=0; i<pos-2 && temp!=null; i++) {
				temp=temp.next;
			}
			if(temp==null) {
				System.out.println("Invalid position");
			}
			temp.next=temp.next.next;
		}
	}
	//linear search on the list
	public boolean linearSearch(T key) {
		//empty list
		if(head==null) {
			return false;
		}
		else {
			Node<T> temp=head;
			while(temp!=null) {
				//key found
				if(temp.data.equals(key)) {
					return true;
				}
			}
			//key not found
			return false;
		}

	}
	public void insertAfterEle(T key, T data) {
		if (head == null) {
			System.out.println("Empty list");
		} else {
			
			Node<T> temp = head;
			while (temp != null && !temp.data.equals(key)) {
				temp = temp.next;
			}
			//key not found
			if (temp == null) {
				System.out.println("Element not found");
			} else {
				//key found
				Node<T> newNode = new Node<>(data);
				newNode.next = temp.next;
				temp.next = newNode;
			}
		}
	}

	public void deleteEle(T key) {
		if (head == null) {
			System.out.println("Empty list");
		} else {
			Node<T> temp = head;
			//traversing till temp!=null and key not found
			while (temp != null && !temp.next.data.equals(key)) {
				temp = temp.next;
			}
			if (temp == null || temp.next == null) {
				System.out.println("Key not found");
			} else {
				//key found
				temp.next = temp.next.next;
			}
		}
	}
	//return number of nodes
	public int nodeCount() {
		if(head==null) {
			return 0;
		}else if(head.next==null) {
			return 1;
		}else {
			Node<T> temp=head;
			int cnt=0;
			while(temp!=null) {
				cnt++;
				temp=temp.next;
			}
			return cnt;
		}
	}
	// reverse list
	public void reverse() {
		if(head==null) {
			System.out.println("Empty list");
		}else {
			Node<T> front=null;
			Node<T> prev=null;
			Node<T> cur=head;
			while(cur!=null) {
				front=cur.next;
				cur.next=prev;
				prev=cur;
				cur=front;
			}
			head=prev;
		}
	}
	//concatenating current list with another list
	public void concatenate(Node<T> otherHead){
		Node<T> resHead=this.head;
		Node<T> temp=this.head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=otherHead;
	}
	//overriding toString method
	public String toString() {
		StringBuilder ans=new StringBuilder();
		Node<T> temp=head;
		while(temp!=null) {
			ans.append(temp.data+" ");
			temp=temp.next;
		}
		return ans.toString();
	}
}
public class SLLDriver {

	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    SLL<Integer> l1 = new SLL<>();
	    SLL<Integer> l2 = new SLL<>(); // Create another linked list

	    //inserting some values to check concatenate method
	    for (int i = 1; i <= 3; i++) {
	        l1.insertEnd(i*10); // inserting into l1 
	        l2.insertEnd(i*100); // inserting into l2
	    }

	    int ch = 0;

	    while (true) {
	        System.out.println("1. Insert at front");
	        System.out.println("2. Insert at end");
	        System.out.println("3. Insert at specified position");
	        System.out.println("4. Delete front");
	        System.out.println("5. Delete end");
	        System.out.println("6. Delete at specified position");
	        System.out.println("7. Insert after specified element: ");
	        System.out.println("8. Delete specified element: ");
	        System.out.println("9. Number of nodes");
	        System.out.println("10. Reverse");
	        System.out.println("11. Concatenate");
	        System.out.println("12. Display list");
	        System.out.println("13. Exit");

	        System.out.print("Enter choice: ");
	        ch = scanner.nextInt();
	        switch (ch) {
	            case 1:
	                // Insert at front
	                System.out.println("Enter data: ");
	                int data = scanner.nextInt();
	                l1.insertFront(data);
	                break;
	            case 2:
	                // Insert at end
	                System.out.println("Enter data: ");
	                data = scanner.nextInt();
	                l1.insertEnd(data);
	                break;
	            case 3:
	                // Insert at specified position
	                System.out.println("Enter data: ");
	                data = scanner.nextInt();
	                System.out.println("Enter position: ");
	                int pos = scanner.nextInt();
	                l1.insertAtPos(data, pos);
	                break;
	            case 4:
	                // Delete front
	                l1.deleteFront();
	                break;
	            case 5:
	                // Delete end
	                l1.deleteEnd();
	                break;
	            case 6:
	                // Delete at specified position
	                System.out.println("Enter position: ");
	                pos = scanner.nextInt();
	                l1.deleteAtPos(pos);
	                break;
	            case 7:
	                // Insert after specified element
	                System.out.println("Enter the element after which to insert: ");
	                int ele = scanner.nextInt();
	                System.out.println("Enter data: ");
	                data = scanner.nextInt();
	                l1.insertAfterEle(ele, data);
	                break;
	            case 8:
	                // Delete specified element
	                System.out.println("Enter the element to delete: ");
	                ele = scanner.nextInt();
	                l1.deleteEle(ele);
	                break;
	            case 9:
	                // Number of nodes
	                System.out.println("Number of nodes: ");
	                System.out.println(l1.nodeCount());
	                break;
	            case 10:
	                // Reverse
	                l1.reverse();
	                break;
	            case 11:
	                // Concatenate
	        
	                l1.concatenate(l2.head);
	                System.out.println("Concatenated list: " + l1.toString());
	                break;
	            case 12:
	                // Display list
	                System.out.println(l1.toString());
	                break;
	            case 13:
	                // Exit
	                System.exit(0);
	            default:
	                System.out.println("Invalid choice");
	        }
	    }
	}
}



/*
 --------output--------

 1. Insert at front
2. Insert at end
3. Insert at specified position
4. Delete front
5. Delete end
6. Delete at specified position
7. Insert after specified element: 
8. Delete specified element: 
9. Number of nodes
10. Reverse
11. Concatenate
12. Display list
13. Exit
Enter choice: 11
Concatenated list: 10 20 30 100 200 300 
1. Insert at front
2. Insert at end
3. Insert at specified position
4. Delete front
5. Delete end
6. Delete at specified position
7. Insert after specified element:
8. Delete specified element:
9. Number of nodes
10. Reverse
11. Concatenate
12. Display list
13. Exit
Enter choice: 8 
Enter the element to delete:
100
1. Insert at front
2. Insert at end
3. Insert at specified position
4. Delete front
5. Delete end
6. Delete at specified position
7. Insert after specified element:
8. Delete specified element:
9. Number of nodes
10. Reverse
11. Concatenate
12. Display list
13. Exit
Enter choice: 12
10 20 30 200 300
1. Insert at front
2. Insert at end
3. Insert at specified position
4. Delete front
5. Delete end
6. Delete at specified position
7. Insert after specified element:
8. Delete specified element:
9. Number of nodes
10. Reverse
11. Concatenate
12. Display list
13. Exit
Enter choice: 7
Enter the element after which to insert:   
30
Enter data:
500
1. Insert at front
2. Insert at end
3. Insert at specified position
4. Delete front
5. Delete end
6. Delete at specified position
7. Insert after specified element:
8. Delete specified element:
9. Number of nodes
10. Reverse
11. Concatenate
12. Display list
13. Exit
Enter choice: 12
10 20 30 500 200 300
 */