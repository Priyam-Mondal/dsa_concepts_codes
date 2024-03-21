import java.util.Stack;

public class Solution {
    
    // This method inserts an integer 'num' at the end of a stack recursively
    static void insertAtEnd(Stack<Integer> stack, int num){
        // If the stack is empty, push 'num' onto the stack and return
        if(stack.isEmpty()){
            stack.push(num);
            return;
        }

        // If the stack is not empty, pop the top element
        int x = stack.pop();
        // Recursively call insertAtEnd to insert 'num' at the end of the stack
        insertAtEnd(stack, num);
        // Push the popped element back onto the stack
        stack.push(x);
    }

    // This method reverses the order of elements in the given stack
    public static void reverseStack(Stack<Integer> stack) {
        // If the stack is empty, return
        if(stack.isEmpty()){
            return;
        }

        // If the stack is not empty, pop the top element
        int num = stack.pop();
        // Recursively call reverseStack to reverse the remaining elements in the stack
        reverseStack(stack);
        // After reversing the remaining elements, insert the popped element at the end of the stack
        insertAtEnd(stack, num);
    }
}
