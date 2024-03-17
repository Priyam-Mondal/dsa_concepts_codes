/*
1.Keep a stack of characters.
2.Now iterate over the string 
    a)If the current character is a starting bracket that is "(" or "{" or "[" then push it to the stack
    b)If the current character is a closing bracket then check if the stack is empty or not 
        i.If the stack is empty return false
        ii.If the stack is not empty pop the top character from the stack 
        iii.Check it with the current closing parenthesis if it is of different nature return false
3.If the stack is empty return true 
 */



import java.util.Stack;

public class Solution {
    public static boolean isValidParenthesis(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }
            if(st.isEmpty()){
                return false;
            }
            char t=st.peek();
            if(ch==')'&&t=='(' || ch=='}'&&t=='{' || ch==']'&&t=='['){
                st.pop();
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}