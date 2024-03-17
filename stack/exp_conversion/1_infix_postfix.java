import java.util.*;

public class Solution {

    // method to calculate precedence of operator
    static int prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
    public static String infixToPostfix(String exp) {
        
        StringBuffer ans=new StringBuffer();
        Stack < Character > st = new Stack < > ();

        for(char ch:exp.toCharArray()){

            // if operand, append to output
            if(Character.isLetterOrDigit(ch)){
                ans.append(ch);
            }

            //if openning paranthesis, push in stack
            else if(ch=='('){
                st.push(ch);
            }
            // if closing paranthesis, pop from stack and append to output
            // until an opening paranthesis not encountered
            // discard that openning paranthesis
            else if(ch==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    ans.append(st.pop());
                }
                st.pop();
            }
            // if operator, pop from stack until st.peek() precedence is higher or equal of current operator
            // push current operator to stack
            else{
                while(!st.isEmpty() && prec(ch)<=prec(st.peek())){
                    ans.append(st.pop());
                }
                st.push(ch);
            }
        }
        // pop from stack and append to output until stack not empty
        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        return ans.toString();
    }
}