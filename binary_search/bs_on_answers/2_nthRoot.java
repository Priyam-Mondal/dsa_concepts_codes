public class Solution {

    // Function to check the relationship between mid^N and M
    // Return 1 if mid == m
    // Return 0 if mid < m
    // Return 2 if mid > m
    public static int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m) return 2; // Mid is greater than m
        }
        if (ans == m) return 1; // Mid is equal to m
        return 0; // Mid is smaller than m
    }

    // Function to find the nth root of m
    public static int NthRoot(int n, int m) {
        int low = 1;
        int high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midN = func(mid, n, m);
            if (midN == 1) {
                return mid; // Mid is the nth root of m
            } else if (midN == 0) {
                low = mid + 1; // Mid is smaller than the nth root of m, search in the right half
            } else {
                high = mid - 1; // Mid is greater than the nth root of m, search in the left half
            }
        }

        return -1; // No nth root found within the range
    }
}
