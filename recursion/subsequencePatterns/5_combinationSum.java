/*You are given an array 'ARR' of 'N' distinct positive integers. 
You are also given a non-negative integer 'B'.

Your task is to return all unique combinations in the array whose sum equals 'B'. 
A number can be chosen any number of times from the array 'ARR'.

Elements in each combination must be in non-decreasing order.

For example:
Let the array 'ARR' be [1, 2, 3] and 'B' = 5. Then all possible valid combinations are-

(1, 1, 1, 1, 1)
(1, 1, 1, 2)
(1, 1, 3)
(1, 2, 2)
(2, 3) 

Sample Input 1 :
3 8
2 3 5
Sample Output 1:
Yes
Explanation Of Sample Input 1 :
All possible valid combinations are:
2 2 2 2
2 3 3
3 5
*/


import java.util.*;

public class Solution {

    // Recursive function to find combinations that sum up to the target
    static void helper(int[] arr, int target, int index, List<Integer> temp, List<List<Integer>> ans) {
        // If index reaches the end of the array
        if (index == arr.length) {
            // If target becomes 0, add the current combination to the answer
            if (target == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        // Including the current element
        if (arr[index] <= target) { // Check if the current element can be included
            temp.add(arr[index]); // Add the current element to the combination
            // Recursively explore combinations with the updated target
            helper(arr, target - arr[index], index, temp, ans);
            temp.remove(temp.size() - 1); // Backtrack: Remove the last element to explore other possibilities
        }

        // Excluding the current element
        // Recursively explore combinations without including the current element
        helper(arr, target, index + 1, temp, ans);
    }

    // Function to find all combinations that sum up to the target
    public static List<List<Integer>> combSum(int[] arr, int target) {
        Arrays.sort(arr); // Sort the input array
        List<List<Integer>> ans = new ArrayList<>(); // List to store the result
        List<Integer> temp = new ArrayList<>(); // Temporary list to store combinations
        // Call the helper function to find combinations
        helper(arr, target, 0, temp, ans);
        return ans; // Return the result
    }
}
