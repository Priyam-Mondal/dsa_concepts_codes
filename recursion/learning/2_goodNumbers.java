/*A digit string is good if the digits (0-indexed) at even indices are 
even and the digits at odd indices are prime (2, 3, 5, or 7).

For example, "2582" is good because the digits (2 and 8) at even positions are 
even and the digits (5 and 2) at odd positions are prime. However, 
"3245" is not good because 3 is at an even index but is not even. 

----------------

even digits: 0,2,4,6,8
odd digits: 1,3,5,7

suppose n=5
indices : 0 1 2 3 4

even pos=3, odd pos=2

number of good numbers=5*4*5*4*5

we simply just have to multiply 5 for even number pos and 4 for odd number pos
*/



class Solution {
    public static final int MOD = 1000000007;

    // Recursive function to calculate x^n % MOD
    public static long myPow(long x, long n) {
        // Base case: if n is 0, return 1
        if (n == 0) {
            return 1;
        }
        
        // Calculate x^(n/2)
        long temp = myPow(x, n / 2);
        // Square temp to get x^n
        temp *= temp;
        // Take modulo to prevent overflow
        temp %= MOD;
        
        // If n is odd, multiply by x one more time
        if (n % 2 == 1) {
            temp *= x;
            temp %= MOD;
        }
        
        return temp;
    }

    // Function to count the number of good numbers of length n
    public int countGoodNumbers(long n) {
        long ans = 0;
        // Number of odd positions
        long oddPos = n / 2;
        // Number of even positions
        long evenPos = (n + 1) / 2;

        // Calculate the total number of good numbers
        ans = (myPow(4, oddPos) * myPow(5, evenPos)) % MOD;

        return (int) ans; // Convert long to int for the result
    }
}
