// 1. traverse from left of exp
//     a. if operand push to stack
//     b. if operator, 
//         pop two element from stack and make  temp_exp = "("+op2+symb+op1+")"
//         push temp_exp to stack
// 2. return stack top




static boolean isOperand(char x)
{
    return (x >= 'a' && x <= 'z') ||
            (x >= 'A' && x <= 'Z');
}
 
// Get Infix for a given postfix
// expression
static String getInfix(String exp)
{
    Stack<String> s = new Stack<String>();
 
    for (int i = 0; i < exp.length(); i++)
    {
        // Push operands
        if (isOperand(exp.charAt(i)))
        {
        s.push(exp.charAt(i) + "");
        }
 
        // We assume that input is
        // a valid postfix and expect
        // an operator.
        else
        {
            String op1 = s.peek();
            s.pop();
            String op2 = s.peek();
            s.pop();
            s.push("(" + op2 + exp.charAt(i) +
                    op1 + ")");
        }
    }
 
    // There must be a single element
    // in stack now which is the required
    // infix.
    return s.peek();
}