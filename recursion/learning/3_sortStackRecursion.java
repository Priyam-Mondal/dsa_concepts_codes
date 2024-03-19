import java.util.* ;
import java.io.*;

public class Solution {
    
    // Recursive function to sort a stack in ascending order using recursion
    static void sortInsert(Stack<Integer> s, int num) {
        // Base case: if the stack is empty or the top element is smaller than 'num', push 'num' onto the stack
        if (s.isEmpty() || s.peek() < num) {
            s.push(num);
            return;
        }

        // If the top element is greater than or equal to 'num', pop elements recursively until we find the correct position
        int n = s.pop();
        sortInsert(s, num);
        s.push(n); // Push the popped element back onto the stack
    }

    // Function to sort the stack using recursion
    public static Stack<Integer> sortStack(Stack<Integer> s) {
        // Base case: if the stack is empty, return the stack as it is
        if (s.isEmpty()) {
            return s;
        }

        // Pop the top element from the stack
        int num = s.pop();
        
        // Recursively sort the remaining stack
        sortStack(s);
        
        // Insert the popped element at its correct position in the sorted stack
        sortInsert(s, num);

        // Return the sorted stack
        return s;
    }
}
