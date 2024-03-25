/*There are several cards arranged in a row, and each card has an associated number of points.
 The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. 
You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.
Given the integer array cardPoints and the integer k, return the maximum score you can obtain.


Example 1:

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. 
However, choosing the rightmost card first will maximize your total score. 
The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
Example 2:

Input: cardPoints = [2,2,2], k = 2
Output: 4
Explanation: Regardless of which two cards you take, your score will always be 4.
Example 3:

Input: cardPoints = [9,7,7,9,7,7,9], k = 7
Output: 55
Explanation: You have to take all the cards. Your score is the sum of points of all cards. */



public class Solution {

    public static int maxPoints(int[] arr, int k) {
        int n = arr.length; // Length of the input array
        int l = 0, r = n - k; // Initialize left and right pointers for the sliding window
        int maxSum = 0; // Initialize the maximum sum
        int curSum = 0; // Initialize the current sum

        // Calculate the sum of the last 'k' elements in the array
        for (int i = r; i < n; i++) {
            curSum += arr[i];
        }
        maxSum = curSum; // Set the initial maximum sum

        // Slide the window and update the maximum sum
        while (r < n) {
            curSum = curSum + arr[r] - arr[l]; // Update the current sum
            maxSum = Math.max(maxSum, curSum); // Update the maximum sum

            l++; // Move the left pointer to the right
            r++; // Move the right pointer to the right
        }

        return maxSum; // Return the maximum sum
    }
}
