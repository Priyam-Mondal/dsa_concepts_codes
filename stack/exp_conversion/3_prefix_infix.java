// Algorithm for Prefix to Infix: 

// 1.Read the Prefix expression in reverse order (from right to left)
// 2.If the symbol is an operand, then push it onto the Stack
// 3.If the symbol is an operator, then pop two operands from the Stack 
// 4.Create a string by concatenating the two operands and the operator between them. 
//      5.string = (operand1 + operator + operand2) 
// 6.And push the resultant string back to Stack
// 7.Repeat the above steps until the end of Prefix expression.
// 8.At the end stack will have only 1 string i.e resultant string


public class Solution {

    public static boolean isOperator(char ch){
        switch(ch){
            case '^':
            case '*':
            case '/':
            case '+':
            case '-':
                return true;
        }
        return false;
    }
    public static String prefixToInfixConversion(String exp) {
        Stack<String> st=new Stack<>();

        for(int i=exp.length()-1; i>=0; i--){
            char ch=exp.charAt(i);

            if(isOperator(ch)){
                String op1=st.pop();
                String op2=st.pop();
                String temp="("+op1+ch+op2+")";

                st.push(temp);
            }else{
                // appending "" to make char a String
                st.push(ch+"");
            }
        }
            
        return st.peek();
    }
}