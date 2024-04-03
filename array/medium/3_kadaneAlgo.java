/*Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23. */

import java.util.*; 
import java.io.*; 

public class Solution {
	
	
	public static long maxSubarraySum(int[] arr, int n) {
		long maxSum = -1; // Initializing maximum sum to -1
		long curSum = 0; // Initializing current sum to 0

		// Iterating through the array
		for (int i = 0; i < n; i++) {
			curSum += arr[i]; // Adding the current element to the current sum
			if (curSum < 0) { // If current sum becomes negative, reset it to 0
				curSum = 0;
			}
			maxSum = Math.max(maxSum, curSum); // Update the maximum sum encountered so far
		}

		return maxSum; // Return the maximum subarray sum
	}
}
