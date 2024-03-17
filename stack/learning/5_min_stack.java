/*
Ap 1 : 
    Push a pair in stack
    Pair=element,min so far
    But SC would be O(2n) 

Ap2 : 
    Push:
        Now if there is a push operation just check whether that number is less than the min number. 
        If it is smaller than min we will push a modified value which is a push(2 * Val – min) into the stack and 
        will update min to the value of the original number. If it’s not then we will just push it as it is.
    Pop :
        While making pop we will check if the top value is lesser than min, 
        If it is then we must update our min to its previous value. 
        In order to do that min = (2 * min) – (modified value) and we will pop the element.
 */


 import java.util.* ;
import java.io.*; 

public class Solution {

    static class MinStack {

        Stack<Integer> st;
        int min;

        // Constructor
        MinStack() {
            st=new Stack<>();
            this.min=Integer.MAX_VALUE;
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            if(st.isEmpty()){
                st.push(num);
                min=num;
            }else{
                if(num<min){
                    st.push(2*num-min);
                    min=num;
                }else{
                    st.push(num);
                }
            }
        }

        // Function to remove the top element of the stack.
        int pop() {
            if(st.isEmpty()){
                return -1;
            }
            int ele=st.pop();
            if(ele<min){
                int ans=min;
                min=2*min-ele;
                return ans;
            }else{
                return ele;
            }
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            if(st.isEmpty()){
                return -1;
            }
            if(st.peek()<min){
                return min;
            }
            return st.peek();
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            if(st.isEmpty()){
                return -1;
            }
            return min;
        }
    }
}