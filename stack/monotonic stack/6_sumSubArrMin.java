/*
 Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
 */

/*----------------------------------------------------------------------- */

/*
 1. Subarray Minimum Contribution:
        For each element in the array, we need to determine how many subarrays it is the minimum for. This can be achieved by finding the number of contiguous subarrays that extend to the left and right of each element.

 2. Next Smaller Element (NSE):
        2.1. The NSE for an element at index i is the index of the first smaller element to the right. This helps in determining how far we can extend the subarray starting from index i before encountering a smaller element.
        2.2. If there is no smaller element to the right, we can assume it extends to the end of the array (i.e., the index n).

 3. Previous Smaller Element (PSE):
        3.1. The PSE for an element at index i is the index of the first smaller element to the left. This helps in determining how far we can extend the subarray ending at index i before encountering a smaller element.
        3.2. If there is no smaller element to the left, it extends to the beginning of the array (i.e., the index -1).

 4. Counting Subarrays:
        4.1. For each element arr[i], the number of subarrays in which it is the minimum can be calculated as:
            left = i - psee[i]: The number of ways to choose the starting index of the subarray.
            right = nse[i] - i: The number of ways to choose the ending index of the subarray.
        4.2. The total contribution of arr[i] as the minimum to the overall sum is arr[i] * left * right.

 5. Final Calculation:
        5.1. Sum the contributions of all elements while applying a modulo operation to handle large numbers, preventing overflow.
 */


 import java.util.Stack;

 class Solution {
     public int sumSubarrayMins(int[] arr) {
         int n = arr.length;
         int[] nse = new int[n]; // Next Smaller Element
         int[] psee = new int[n]; // Previous Smaller Element
         long total = 0; // Use long to avoid overflow
         int MOD = (int)(1e9 + 7);
 
         // Fill NSE and PSE arrays
         nseFunc(arr, nse);
         pseeFunc(arr, psee);
 
         // Calculate the total sum of subarray minimums
         for (int i = 0; i < n; i++) {
             long left = i - psee[i];  // Count of subarrays ending at i where arr[i] is minimum
             long right = nse[i] - i;  // Count of subarrays starting at i where arr[i] is minimum
             total = (total + (left * right % MOD) * arr[i] % MOD) % MOD; // Use long to avoid overflow
         }
 
         return (int) total; // Return result as an integer
     }
 
     private void nseFunc(int[] arr, int[] nse) {
         Stack<Integer> st = new Stack<>();
         int n = arr.length;
         for (int i = n - 1; i >= 0; i--) {
             while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                 st.pop();
             }
             nse[i] = st.isEmpty() ? n : st.peek();
             st.push(i);
         }
     }
 
     private void pseeFunc(int[] arr, int[] psee) {
         Stack<Integer> st = new Stack<>();
         int n = arr.length;
         for (int i = 0; i < n; i++) {
             while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                 st.pop();
             }
             psee[i] = st.isEmpty() ? -1 : st.peek();
             st.push(i);
         }
     }
 }
 