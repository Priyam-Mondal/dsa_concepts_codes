/*Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15 */



class Solution {

    // Helper function to count the number of subarrays with sum less than or equal to the goal
    static int helper(int[] nums, int goal){
        int l=0, r=0; // Two pointers for the sliding window
        int n=nums.length;
        int ans=0; // Count of subarrays
        int sum=0; // Sum of elements in the current subarray

        // If goal is negative, there can't be any subarray with sum less than that
        if(goal<0)  
            return 0;
        
        // Sliding window approach
        while(r<n){
            sum+=nums[r]; // Expand the window by including nums[r] in the sum
            while(sum>goal && l<=r){ // Shrink the window if sum exceeds the goal
                sum-=nums[l];
                l++;
            }
            r++; // Move the right pointer to the next element
            ans+=(r-l); // Increment ans by the number of subarrays ending at index r
        }
        return ans; // Return the total count of subarrays
    }
    
    // Main function to count the number of subarrays with sum equal to the goal
    public int numSubarraysWithSum(int[] nums, int goal) {
        // The difference between the count of subarrays with sum equal to goal 
        // and the count of subarrays with sum less than goal is the count of 
        // subarrays with sum equal to goal.
        return helper(nums, goal) - helper(nums, goal - 1);
    }
}
