/*Given an array containing both positive and negative integers, 
we have to find the length of the longest subarray with the sum of all elements equal to zero. 



Example 1:
Input Format
: N = 6, array[] = {9, -3, 3, -1, 6, -5}
Result
: 5
Explanation
: The following subarrays sum to zero:
{-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
Since we require the length of the longest subarray, our answer is 5!

Example 2:
Input Format:
 N = 8, array[] = {6, -2, 2, -8, 1, 7, 4, -10}
Result
: 8
Subarrays with sum 0 : {-2, 2}, {-8, 1, 7}, {-2, 2, -8, 1, 7}, {6, -2, 2, -8, 1, 7, 4, -10}
Length of longest subarray = 8

Example 3:
Input Format:
 N = 3, array[] = {1, 0, -5}
Result
: 1
Subarray : {0}
Length of longest subarray = 1

Example 4:
Input Format:
 N = 5, array[] = {1, 3, -5, 6, -2}
Result
: 0
Subarray: There is no subarray that sums to zero

*/


int maxLen(int A[], int n) {
    HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>(); // Create a HashMap to store prefix sums and their indices.

    int maxi = 0; // Initialize the maximum length of subarray with sum 0.
    int sum = 0; // Initialize the prefix sum.

    for (int i = 0; i < n; i++) {
        sum += A[i]; // Calculate the prefix sum by adding the current element.

        if (sum == 0) {
            maxi = i + 1; // If the prefix sum is 0, update the maximum length to include the current element.
        } else {
            if (mpp.get(sum) != null) {
                maxi = Math.max(maxi, i - mpp.get(sum)); // If the prefix sum is not 0, check if there is a previous occurrence of the same prefix sum and update the maximum length accordingly.
            } else {
                mpp.put(sum, i); // Store the current prefix sum along with its index if it is encountered for the first time.
            }
        }
    }
    return maxi; // Return the maximum length of subarray with sum 0.
}
