public class Solution {
    // Function to find the intersection point of two linked lists
    public static int findIntersection(Node firstHead, Node secondHead) {
        Node t1 = firstHead; // Pointer for the first linked list
        Node t2 = secondHead; // Pointer for the second linked list

        // Traverse both lists until an intersection is found or both pointers reach the end
        while (t1 != t2) {
            // Move both pointers forward
            t1 = t1.next;
            t2 = t2.next;

            // If an intersection is found, return the data value of the intersection node
            if (t1 == t2) {
                return t1.data;
            }

            // If t1 reaches the end of the first list, reset it to the head of the second list
            if (t1 == null) {
                t1 = secondHead;
            }
            
            // If t2 reaches the end of the second list, reset it to the head of the first list
            if (t2 == null) {
                t2 = firstHead;
            }
        }

        // If no intersection is found, return the data value of t1 (or t2, as they are equal at this point)
        return t1.data;
    }
}

 // Time Complexity: O(m + n), where m and n are the lengths of the two linked lists
