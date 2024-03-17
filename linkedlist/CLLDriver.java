/*2. Write a menu driven program to implement a doubly circular linked list with the
following operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list*/



package DSA.LinkedList;

import java.util.Scanner;

class CLL<T> {
    NodeD<T> head;

    CLL() {
        head = null;
    }

    // Return number nodes
    public int nodeCount() {
    	if(head==null) {
    		return 0;
    	}else if(head.next==head) {
    		return 1;
    	}
        NodeD<T> temp = head;
        int count = 0;
        while (temp.next != head) {
            count++;
            temp = temp.next;
        }
        return count++;
    }

    public void insertFront(T data) {
        NodeD<T> newNode = new NodeD<>(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertEnd(T data) {
        NodeD<T> newNode = new NodeD<>(data);
        if (head == null) {
            this.insertFront(data);
        } else {
            newNode.prev = head.prev;
            newNode.next = head;
            head.prev.next = newNode;
            head.prev = newNode;
        }
    }


    public void deleteFront() {
        if (head == null) {
            System.out.println("Empty list");
        } else if (head.next == head) {
            head = null;
        } else {
            head.prev.next = head.next;
            head.next.prev = head.prev;
            head = head.next;
        }
    }

    public void deleteEnd() {
        if (head == null) {
            System.out.println("Empty List");
        } else if (head.next == head) {
            head = null;
        } else {
            NodeD<T> t = head.prev;
            t.prev.next = head;
            head.prev = t.prev;
        }
    }
    
    public void insertAtPos(T data, int pos) {
        NodeD<T> newNode = new NodeD<>(data);
        int count = nodeCount();
        if (pos < 1 || pos > count + 1) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
        	// if pos=1, insert at front
            insertFront(data);
            return;
        }
        if (pos == count + 1) {
        	//insert at last
            insertEnd(data);
            return;
        }
        NodeD<T> t = head;
        //traversing one node before of which to be inserted
        for (int i = 0; i < pos - 2 && t.next != head; i++) {
            t = t.next;
        }
        newNode.next = t.next;
        t.next.prev = newNode;
        t.next = newNode;
        newNode.prev = t;
    }

    public void deleteAtPos(int pos) {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        int count = nodeCount();
        if (pos < 1 || pos > count) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            deleteFront();
            return;
        }
        NodeD<T> t = head;
      //traversing one node before of which to be inserted
        for (int i = 1; i < pos - 1 && t.next != head; i++) {
            t = t.next;
        }
        NodeD<T> delNode = t.next;
        t.next = delNode.next;
        delNode.next.prev = t;
        if (delNode == head.prev) { // If deleting the last node
            head.prev = t;
            t.next = head;
        }
        delNode.next = null;
        delNode.prev = null;
    }


    public String toString() {
        StringBuilder ans = new StringBuilder();
        if (head == null) {
            ans.append("Empty List");
        } else {
            NodeD<T> t = head;
            while(t.next!=head) {
            	ans.append(t.data+" ");
            	t=t.next;
            	
            }
            ans.append(t.data);
        }
        return ans.toString();
    }
}

public class CLLDriver {

    public static void main(String[] args) {
    	
    	//creating CLL object
        CLL<Integer> cl = new CLL<>();
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Insert at front");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at a position");
            System.out.println("4. Delete from front");
            System.out.println("5. Delete from end");
            System.out.println("6. Delete from a position");
            System.out.println("7. Display");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert at front: ");
                    int frontData = scanner.nextInt();
                    cl.insertFront(frontData);
                    break;
                case 2:
                    System.out.print("Enter element to insert at end: ");
                    int endData = scanner.nextInt();
                    cl.insertEnd(endData);
                    break;
                case 3:
                    System.out.print("Enter element to insert: ");
                    int posData = scanner.nextInt();
                    System.out.print("Enter position to insert at: ");
                    int pos = scanner.nextInt();
                    cl.insertAtPos(posData, pos);
                    break;
                case 4:
                    cl.deleteFront();
                    break;
                case 5:
                    cl.deleteEnd();
                    break;
                case 6:
                    System.out.print("Enter position to delete from: ");
                    int delPos = scanner.nextInt();
                    cl.deleteAtPos(delPos);
                    break;
                case 7:
                    System.out.println("List: " + cl.toString());
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}

/*
 ----output-----
 
 
1. Insert at front
2. Insert at end
3. Insert at a position
4. Delete from front
5. Delete from end
6. Delete from a position
7. Display
8. Exit
Enter your choice: 1
Enter element to insert at front: 10

1. Insert at front
2. Insert at end
3. Insert at a position
4. Delete from front
5. Delete from end
6. Delete from a position
7. Display
8. Exit
Enter your choice: 2
Enter element to insert at end: 20

1. Insert at front
2. Insert at end
3. Insert at a position
4. Delete from front
5. Delete from end
6. Delete from a position
7. Display
8. Exit
Enter your choice: 7
List: 10 20

1. Insert at front
2. Insert at end
3. Insert at a position
4. Delete from front
5. Delete from end
6. Delete from a position
7. Display
8. Exit
Enter your choice: 3
Enter element to insert: 100
Enter position to insert at: 2

1. Insert at front
2. Insert at end
3. Insert at a position
4. Delete from front
5. Delete from end
6. Delete from a position
7. Display
8. Exit
Enter your choice: 7
List: 10 20 100

1. Insert at front
2. Insert at end
3. Insert at a position
4. Delete from front
5. Delete from end
6. Delete from a position
7. Display
8. Exit
Enter your choice: 3
Enter element to insert: 300
Enter position to insert at: 2

1. Insert at front
2. Insert at end
3. Insert at a position
4. Delete from front
5. Delete from end
6. Delete from a position
7. Display
8. Exit
Enter your choice: 7
List: 10 300 20 100

1. Insert at front
2. Insert at end
3. Insert at a position
4. Delete from front
5. Delete from end
6. Delete from a position
7. Display
8. Exit
Enter your choice: 4

1. Insert at front
2. Insert at end
3. Insert at a position
4. Delete from front
5. Delete from end
6. Delete from a position
7. Display
8. Exit
Enter your choice: 7
List: 300 20 100

1. Insert at front
2. Insert at end
3. Insert at a position
4. Delete from front
5. Delete from end
6. Delete from a position
7. Display
8. Exit
Enter your choice: 6
Enter position to delete from: 3
Invalid position

1. Insert at front
2. Insert at end
3. Insert at a position
4. Delete from front
5. Delete from end
6. Delete from a position
7. Display
8. Exit
Enter your choice: 7
List: 300 20 100

1. Insert at front
2. Insert at end
3. Insert at a position
4. Delete from front
5. Delete from end
6. Delete from a position
7. Display
8. Exit
Enter your choice: 6
Enter position to delete from: 2

1. Insert at front
2. Insert at end
3. Insert at a position
4. Delete from front
5. Delete from end
6. Delete from a position
7. Display
8. Exit
Enter your choice: 7
List: 300 100

1. Insert at front
2. Insert at end
3. Insert at a position
4. Delete from front
5. Delete from end
6. Delete from a position
7. Display
8. Exit
Enter your choice: 
 */

