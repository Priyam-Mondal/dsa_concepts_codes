/*You are given two integers L and R, your task is to find the XOR of elements of the range [L, R].

Example:

Input: 
L = 4, R = 8 
Output:
8 
Explanation:
4 ^ 5 ^ 6 ^ 7 ^ 8 = 8

----------------Solution-----------------
The pattern of XOR from 0 to n follows a repeating cycle every 4 numbers:

n % 4 == 0: XOR from 0 to n is n.
n % 4 == 1: XOR from 0 to n is 1.
n % 4 == 2: XOR from 0 to n is n + 1.
n % 4 == 3: XOR from 0 to n is 0.
This cycle repeats for any value of n, allowing efficient calculation of the XOR of a range by using XOR properties and this repeating pattern.

This approach takes O(1) time.

*/

package bit_manipulation.medium;

public class 4_XOR_in_range {
    // Function to find XOR from l to r
    public static int findXOR(int l, int r) {
        // XOR of numbers from 0 to (l-1) XORed with XOR of numbers from 0 to r
        return findXORUtil(l-1) ^ findXORUtil(r);
    }

    // Helper function to compute XOR of numbers from 0 to n
    static private int findXORUtil(int n) {
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n + 1;
        if (n % 4 == 3) return 0;
        else return n;  
    }
}
