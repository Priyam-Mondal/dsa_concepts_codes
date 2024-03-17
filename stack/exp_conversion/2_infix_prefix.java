// 1. reverse infix(dont reverse paranthesis, just chnage alternate - if '(' do ')')
// 2. convert to postfix
// 3. reverse postfix to get prefix



class Convert2 {

    String solve(String exp) {
        exp = reverse(exp); // Reverse the infix string
        exp = infixToPostfix(exp); //Convert to postfix
        exp = reverse(exp); // Reverse the postfix to get prefix
        return exp;
    }

    boolean isOperator(char token) {
        return token == '+' || token == '-' || token == '*' || token == '/' || token == '^' || token == '(' || token == ')';
    }

    int precedence(char ch) {
        switch(ch) {
            case '^' :
                return 3;
            case '*' :
            case '/' :
                return 2;
            case '+' :
            case '-' :
                return 1;
        }
        return -1;
    }

    String reverse(String s) {
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') {
                c = ')';
            } else if (c == ')') {
                c = '(';
            }
            reversed.append(c);
        }
        return reversed.toString();
    }

    String infixToPostfix(String exp) {
        MyStack<Character> st = new MyStack<>(exp.length());
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char t = exp.charAt(i);

            // if symbol is an operand, appending to output string
            if (!isOperator(t)) {
                ans.append(t);
            }
            // if opening parenthesis, push to stack
            else if (t == '(') {
                try {
                    st.push(t);
                } catch (overflowException e) {
                    e.printStackTrace();
                }
            }
            // if closing parenthesis
            else if (t == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    try {
                        ans.append(st.pop());
                    } catch (underflowException e) {
                        e.printStackTrace();
                    }
                }
                if (!st.isEmpty()) {
                    try {
                        st.pop(); // remove '(' from stack
                    } catch (underflowException e) {
                        e.printStackTrace();
                    }
                }
            }
            // if symbol is an operator
            else {
                while (!st.isEmpty() && precedence(t) <= precedence(st.peek())) {
                    try {
                        ans.append(st.pop());
                    } catch (underflowException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    st.push(t);
                } catch (overflowException e) {
                    e.printStackTrace();
                }
            }
        }

        // Append remaining operators in the stack to output string
        while (!st.isEmpty()) {
            try {
                ans.append(st.pop());
            } catch (underflowException e) {
                e.printStackTrace();
            }
        }

        return ans.toString();
    }
}

public class In2Pre {

    public static void main(String[] args) {
        Convert2 obj = new Convert2();

        // Test cases
        String infix1 = "(a+b*c-d)+f-g";
        System.out.println("Infix: " + infix1);
        System.out.println("Prefix: " + obj.solve(infix1));

        String infix2 = "(a-b/c)*(a/k-l)";
        System.out.println("Infix: " + infix2);
        System.out.println("Prefix: " + obj.solve(infix2));

        String infix3 = "A+B*C-D/E";
        System.out.println("Infix: " + infix3);
        System.out.println("Prefix: " + obj.solve(infix3));

        String infix4 = "(A+B)*C-D/E";
        System.out.println("Infix: " + infix4);
        System.out.println("Prefix: " + obj.solve(infix4));
    }

}