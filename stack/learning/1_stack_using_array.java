public class Solution{
    static class Stack {

        int size;
        int[] arr;
        int top;
        Stack(int capacity) {
            this.size=capacity;
            arr=new int[this.size];
            top=-1;
        }
        public void push(int num) {
            if(isFull()==0){
                arr[++top]=num;
            }
        }
        public int pop() {
            if(isEmpty()==0){
                int ele=arr[top--];
                return ele;
            }
            return -1;
        }
        public int top() {
            if(isEmpty()==1){
                return -1;
            }
            return arr[top];
        }
        public int isEmpty() {
            if(top==-1){
                return 1; 
            }
            return 0;
        }
        public int isFull() {
            if(top==this.size-1){
                return 1;
            }
            return 0;
        }
    }
}