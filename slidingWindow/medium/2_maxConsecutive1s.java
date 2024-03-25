/*Given a binary array nums and an integer k, 
return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined. */


class Solution {
    public int longestOnes(int[] nums, int k) {
        // Initialize pointers and variables
        int l = 0, r = 0; // Left and right pointers for the sliding window
        int maxLen = 0; // Maximum length of consecutive ones
        int zeroCnt = 0; // Count of zeros encountered within the window

        // Traverse the array using the right pointer
        while (r < nums.length) {
            // If the current element is 0, increment the zero count
            if (nums[r] == 0) {
                zeroCnt++;
            }
            
            // Shrink the window until the count of zeros is less than or equal to k
            while (zeroCnt > k) {
                // If the left element is 0, decrement the zero count
                if (nums[l] == 0) {
                    zeroCnt--;
                }
                // Move the left pointer to the right
                l++;
            }

            // Update the maximum length of consecutive ones encountered so far
            maxLen = Math.max(maxLen, r - l + 1);

            // Move the right pointer to the right
            r++;
        }

        // Return the maximum length of consecutive ones encountered
        return maxLen;
    }
}
