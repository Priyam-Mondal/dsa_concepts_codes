/*1. Write a menu driven program to implement a doubly linked list with the following
operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list */


//package LinkedList;


package DSA.LinkedList;
import java.util.Scanner;


class NodeD<T> {
    T data;
    
    //prev will point to previous node
    NodeD<T> prev;
    //next will point to next node
    NodeD<T> next;

    NodeD() {
    }

    NodeD(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DLL<T>{
    NodeD<T> head;

    DLL() {
        this.head = null;
    }

    //return number nodes
    public int nodeCount() {
        NodeD<T> temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void insertFront(T data) {
        NodeD<T> newNode = new NodeD<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    public void insertEnd(T data) {
        NodeD<T> newNode = new NodeD<>(data);
        if (head == null) {
            head = newNode;
        } else {
            NodeD<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }
    public void insertAtPos(T data, int pos){
        NodeD<T> newNode = new NodeD<>(data);
        
        //getting number of nodes in list
        int count = nodeCount();
        
        if(pos < 1 || pos > count + 1){
            System.out.println("Invalid position");
            return;
        }
        if(pos == 1){
            insertFront(data);
            return;
        }
        if(pos == count + 1){
            insertEnd(data);
            return;
        }
        NodeD<T> t = head;
        
        //traversing one node before where newNode to be inserted
        for(int i = 1; i < pos - 1 && t != null; i++){
            t = t.next;
        }
        newNode.next = t.next;
        t.next.prev = newNode;
        t.next = newNode;
        newNode.prev = t;
    }
    
    public void deleteFront(){
        if(head==null){
            System.out.println("Empty list");
        }else if(head.next==null){
            head=null;
        }else{
            head=head.next;
            head.prev=null;
        }
    }
    public void deleteEnd(){
        if(head==null){
            System.out.println("Empty list");
        }else if(head.next==null){
            head=null;
        }else{
            NodeD<T> temp=head;

            //traversing one node before where newNode to be inserted
            while(temp.next.next!=null){
                temp=temp.next;
            }
            temp.next=null;
        }
    }
    public void deleteAtPos(int pos){
        if(head==null){
            System.out.println("Empty list");
        }else if(pos<1){
            System.out.println("Invalid position");
        }else if(pos==nodeCount()){
            this.deleteEnd();
        }else{
            NodeD<T> t=head;

            // /traversing one node before where newNode to be inserted
            for(int i=0; i<pos-2 && t!=null; i++){
                t=t.next;
            }
            NodeD<T> front=t.next;
            t.next=front.next;
            front.next.prev=t;
            front.next=null;
            front.prev=null;
        }
    }

    //overriding toString method
    public String toString(){
        StringBuilder ans=new StringBuilder();
        if(head==null){
            return null;
        }
        NodeD<T> t=head;
        while(t!=null){
            ans.append(t.data+" ");
            t=t.next;
        }
        return ans.toString();
    }
}

public class DLLDriver {
    public static void main(String[] args){

        //creating doubly linked list object
        DLL<Integer> dll = new DLL<>();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {

            System.out.println("1. Insert at Front");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete at Front");
            System.out.println("5. Delete at End");
            System.out.println("6. Delete at Position");
            System.out.println("7. Display List");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
                
            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    int frontData = scanner.nextInt();
                    dll.insertFront(frontData);
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    int endData = scanner.nextInt();
                    dll.insertEnd(endData);
                    break;
                case 3:
                    System.out.print("Enter data to insert: ");
                    int positionData = scanner.nextInt();
                    System.out.print("Enter position to insert: ");
                    int position = scanner.nextInt();
                    dll.insertAtPos(positionData, position);
                    break;
                case 4:
                    dll.deleteFront();
                    break;
                case 5:
                    dll.deleteEnd();
                    break;
                case 6:
                    System.out.print("Enter position to delete: ");
                    int deletePosition = scanner.nextInt();
                    dll.deleteAtPos(deletePosition);
                    break;
                case 7:
                    System.out.println("Doubly Linked List:"+dll.toString());
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

/*----output----
 1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice: 5
Empty list
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice: 1
Enter data: 10
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice: 1
Enter data: 20
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice: 1
Enter data: 30
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice: 6
Enter position to delete: 2    
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice: 50
Invalid choice!
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice: 7
Doubly Linked List:30 10       
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice: 7
Doubly Linked List:30 10       
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice:
PS D:\MCA\core_java\core_java\src\DSA\linkedlist>  d:; cd 'd:\MCA\core_java\core_java\src\DSA\linkedlist'; & 'C:\Users\priya\AppData\Local\Programs\Eclipse Adoptium\jdk-17.0.10.7-hotspot\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\priya\AppData\Roaming\Code\User\workspaceStorage\98523643a51d48381c4a0e92bd36eb0d\redhat.java\jdt_ws\jdt.ls-java-project\bin' 'LinkedList.DLLDriver'
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice: 1
Enter data: 10
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice: 1
Enter data: 20
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice: 1
Enter data: 30
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice: 7
Doubly Linked List:30 20 10    
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice: 3
Enter data to insert: 50
Enter position to insert: 3    
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice: 7
Doubly Linked List:30 20 50 10 
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice: 6
Enter position to delete: 2    
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice: 7
Doubly Linked List:30 50 10    
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice: 6
Enter position to delete: 3    
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice: 7
Doubly Linked List:30 50       
1. Insert at Front
2. Insert at End
3. Insert at Position
4. Delete at Front
5. Delete at End
6. Delete at Position
7. Display List
8. Exit
Enter your choice:
 */