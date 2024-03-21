/*You are given an array 'A' of size 'N' and an integer'K'’. 
You need to generate and return all subarrays of array ‘A’ whose sum = ‘K’.

Note: In the output, you will see the 2D array lexicographically sorted.

Example:
Input: ‘N’ = 6 ‘K’ = 3
‘A’ = [1, 2, 3, 1, 1, 1]
Output: 3
Explanation: Subarrays whose sum = ‘3’ are:
[1, 2], [3], and [1, 1, 1] */


import java.util.*;

public class Solution {

    static void helper(int[] a, long target, int index, long sum, List<Integer> temp, List<List<Integer>> ans) {
        
        // If the index reaches the end of the array, return
        if (index == a.length) {
            // If the current sum equals the target, add the subarray to the answer
            if (sum == target && !ans.contains(temp)) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        // Include the current element in the sum
        temp.add(a[index]);
        sum += a[index];

        // Explore subarrays starting from the next index
        helper(a, target, index + 1, sum, temp, ans);

        // Backtrack: Remove the last element to explore other possibilities
        sum -= a[index];
        temp.remove(temp.size() - 1);

        // Explore subarrays without including the current element
        helper(a, target, index + 1, sum, temp, ans);
    }

    public static List<List<Integer>> subarraysWithSumK(int[] a, long k) {

        Arrays.sort(a);
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        // Call the helper function to generate subarrays with sum = K
        helper(a, k, 0, 0, temp, ans);



        return ans;
    }
}
