// 1.Push
//     a)Add the element at the end of queue
//     b)Run a loop til q.size()-1
//         i.Remove from front and add to end
// 2.Pop, peek is same


import java.util.Queue;
import java.util.*;
public class Solution{
    static class Stack {
        Queue<Integer> q=new LinkedList<>();

        public Stack() {
            // Implement the Constructor.
        }

        /*----------------- Public Functions of Stack -----------------*/

        public int getSize() {
            return q.size();
        }

        public boolean isEmpty() {
            return q.size()==0;
        }

        public void push(int element) {
            q.add(element);
            for(int i=0; i<q.size()-1; i++){
                q.add(q.remove());
            }
        }

        public int pop() {
            if(getSize()==0){
                return -1;
            }
            return q.remove();
        }

        public int top() {
            if(getSize()==0){
                return -1;
            }
            return q.peek();
        }
    }
}