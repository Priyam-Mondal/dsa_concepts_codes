// Read the Postfix expression from left to right
// If the symbol is an operand, then push it onto the Stack
// If the symbol is an operator, then pop two operands from the Stack 
// Create a string by concatenating the two operands and the operator before them. 
// string = operator + operand2 + operand1 
// And push the resultant string back to Stack
// Repeat the above steps until end of Postfix expression.




public class Solution {

    public static String postfixToPrefix(String exp) {

        Stack<String> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            if (Character.isLetterOrDigit(exp.charAt(i))) {

                st.push(exp.charAt(i) + "");

            } else {

                String A = st.peek();
                st.pop();
                String B = st.peek();
                st.pop();

                st.push(exp.charAt(i) + B + A);
            }
        }

        return st.peek();
    }
}