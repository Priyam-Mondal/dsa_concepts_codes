/*Given an array of integers nums and an integer k. 
A continuous subarray is called nice if there are k odd numbers on it.

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There is no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
  */



class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int i = 0; // Left pointer
        int j = 0; // Right pointer
        int oddCount = 0; // Counter for odd numbers encountered
        int count = 0; // Total count of nice subarrays
        int temp = 0; // Temporary count of nice subarrays within current window
        
        while (j < nums.length) { // Loop until right pointer reaches end of array
            if (nums[j] % 2 == 1) { // If current element is odd
                oddCount++; // Increment odd count
                temp = 0; // Reset temporary count
            }
            
            while (oddCount == k) { // While the number of odd elements in current window is k
                temp++; // Increment temporary count
                if (nums[i] % 2 == 1) { // If left pointer element is odd
                    oddCount--; // Decrement odd count
                }
                i++; // Move left pointer to the right
            }
            
            count += temp; // Add temporary count to total count of nice subarrays
            j++; // Move right pointer to the right
        }
        
        return count; // Return total count of nice subarrays
    }
}
