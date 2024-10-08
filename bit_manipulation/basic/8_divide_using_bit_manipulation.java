public class 8_divide_using_bit_manipulation {
    public int divide(int dividend, int divisor) {
        // Special case: when dividend is Integer.MIN_VALUE (-2^31) and divisor is -1,
        // the result will overflow, as the result is 2^31 which exceeds Integer.MAX_VALUE (2^31 - 1).
        // In such a case, return Integer.MAX_VALUE as per the problem constraints.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Determine the sign of the result (true if the result is negative).
        boolean sign = (dividend >= 0) != (divisor >= 0) ? true : false;
        
        // Take the absolute values of both dividend and divisor for easier calculation.
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);

        int res = 0; // This will hold the result.

        // Repeat while the current dividend 'a' is greater than or equal to divisor 'b'.
        while (a - b >= 0) {
            int x = 0;
            
            // Find the highest multiple of 'b' that fits into 'a' using left shifts.
            // b << 1 << x is equivalent to b * 2^(x+1), doubling 'b' repeatedly.
            // We are trying to find the largest 'b' multiple that still fits in 'a'.
            while (a - (b << 1 << x) >= 0) {
                x++;
            }
            
            // Add 2^x to the result, as we have found that 'b * 2^x' fits into 'a'.
            res += 1 << x;
            
            // Subtract 'b * 2^x' from 'a', reducing the dividend for the next iteration.
            a -= b << x;
        }

        // If the result should be negative, return the negative value of the result.
        // Otherwise, return the positive result.
        return sign == true ? -res : res;
    }
}
