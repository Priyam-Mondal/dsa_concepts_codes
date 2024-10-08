/*Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]] */


/*------------------Intuition-----------------
 Array: arr = [1, 2, 3]
Number of subsets = 2^n = 8
Binary -> Subset
000    -> []
001    -> [1]
010    -> [2]
011    -> [1, 2]
100    -> [3]
101    -> [1, 3]
110    -> [2, 3]
111    -> [1, 2, 3]

 */


package bit_manipulation.medium;

public class 3_powerSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        // Number of subsets is 2^n where n is the length of nums.
        int numberOfSubsets = (int)Math.pow(2, nums.length);

        // Traverse from 0 to numberOfSubsets (inclusive of empty subset []).
        for (int i = 0; i < numberOfSubsets; i++) {
            List<Integer> currentSubset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                // Check if the j-th bit is set in the binary representation of i.
                if ((i & (1 << j)) != 0) {
                    currentSubset.add(nums[j]);
                }
            }
            ans.add(currentSubset);
        }

        return ans;
    }
}
