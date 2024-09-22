/* Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
  */

  /*----------------------------------------------------------------------- */
  /*
   appraoch 1:
        1. use two arrays leftMax, rightMax (which stores leftMax and rightMax element for every item in array)
        2. then loop through array and find total_water+= min(leftMax[i],rightMax[i])-height[i]
    
    SC: O(n)*2 for using two extra arrays
   */

   /*
    appraoch 2:
        1. use variable to track leftMax and rightMax
        2. we need only min of leftMax and rightMax, we dont need both
        3. so when traversing height array, do work on the min side
    */

  class Solution {
    public int trap(int[] height) {
        // Initialize variables to track the left and right maximum heights
        int lMax = 0; // Maximum height from the left
        int rMax = 0; // Maximum height from the right
        int total = 0; // Total trapped water
        int l = 0; // Left pointer
        int r = height.length - 1; // Right pointer

        // Loop until the two pointers meet
        while (l <= r) {
            // Compare left and right maximum heights
            if (lMax <= rMax) {
                // If current left height is less than lMax, calculate trapped water
                if (lMax > height[l]) {
                    total += lMax - height[l]; // Water trapped above the current bar
                } else {
                    // Update lMax if the current height is greater
                    lMax = height[l];
                }
                // Move the left pointer to the right
                l++;
            } else {
                // If current right height is less than rMax, calculate trapped water
                if (rMax > height[r]) {
                    total += rMax - height[r]; // Water trapped above the current bar
                } else {
                    // Update rMax if the current height is greater
                    rMax = height[r];
                }
                // Move the right pointer to the left
                r--;
            }
        }

        // Return the total amount of trapped water
        return total;
    }
}
