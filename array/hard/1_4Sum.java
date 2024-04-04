/*Given an array of N integers, your task is to find unique quads that add up to 
give a target value. In short, you need to return an array of all the
unique quadruplets [arr[a], arr[b], arr[c], arr[d]] such that their sum is equal to a given target. 



Example 1:
Input Format:
 arr[] = [1,0,-1,0,-2,2], target = 0
Result:
 [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Explanation:
 We have to find unique quadruplets from the array such that the sum of those elements 
 is equal to the target sum given that is 0. The result obtained is such that the sum of the quadruplets yields 0.

Example 2:
Input Format:
 arr[] = [4,3,3,4,4,2,1,2,1,1], target = 9
Result:
 [[1,1,3,4],[1,2,2,4],[1,2,3,3]]
Explanation:
 The sum of all the quadruplets is equal to the target i.e. 9.
*/


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); // Sort the input array to easily handle duplicates and traverse it in an orderly fashion.
        int n = nums.length; // Length of the input array.
        List<List<Integer>> ans = new ArrayList<>(); // Initialize the list to store quadruplets.

        // Iterate through the array to find quadruplets.
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates for the first number in quadruplets.
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicates for the second number in quadruplets.

                // Initialize two pointers for the remaining two numbers.
                int k = j + 1;
                int l = n - 1;

                // Use two pointers technique to find the remaining two numbers that sum up to the target.
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l]; // Use long type to handle potential overflow.

                    if (sum == target) {
                        // Found a quadruplet that sums up to the target, add it to the result list.
                        List<Integer> t = new ArrayList<>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[k]);
                        t.add(nums[l]);
                        ans.add(t);

                        // Move pointers and skip duplicates.
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;

                    } else if (sum > target) {
                        // Adjust pointers if the sum is greater than the target.
                        l--;
                    } else {
                        // Adjust pointers if the sum is less than the target.
                        k++;
                    }
                }
            }
        }

        return ans; // Return the list of quadruplets.
    }
}
