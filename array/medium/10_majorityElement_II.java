/*Given an array of N integers. 
Find the elements that appear more than N/3 times in the array.
 If no such element exists, return an empty vector. 



Example 1:
Input Format
: N = 5, array[] = {1,2,2,3,2}
Result
: 2
Explanation:
 Here we can see that the Count(1) = 1, Count(2) = 3 and Count(3) = 1.Therefore, 
 the count of 2 is greater than N/3 times. Hence, 2 is the answer.

Example 2:
Input Format
:  N = 6, array[] = {11,33,33,11,33,11}
Result:
 11 33
Explanation:
 Here we can see that the Count(11) = 3 and Count(33) = 3. Therefore,
  the count of both 11 and 33 is greater than N/3 times. Hence, 11 and 33 is the answer.

 */


//an array can not has more than 2 majority (n/3) elements


 class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Initialize counters and potential majority elements
        int cnt1 = 0, cnt2 = 0; // Counts of potential majority elements
        int ele1 = Integer.MAX_VALUE, ele2 = Integer.MAX_VALUE; // Potential majority elements

        // Find potential majority elements
        for (int i = 0; i < nums.length; i++) {
            // If count of first element is zero and current element is not second potential majority element
            if (cnt1 == 0 && nums[i] != ele2) {
                cnt1 = 1; // Initialize count of first potential majority element
                ele1 = nums[i]; // Assign first potential majority element
            }
            // If count of second element is zero and current element is not first potential majority element
            else if (cnt2 == 0 && nums[i] != ele1) {
                cnt2 = 1; // Initialize count of second potential majority element
                ele2 = nums[i]; // Assign second potential majority element
            }
            // If current element is equal to first potential majority element
            else if (nums[i] == ele1) {
                cnt1++; // Increment count of first potential majority element
            }
            // If current element is equal to second potential majority element
            else if (nums[i] == ele2) {
                cnt2++; // Increment count of second potential majority element
            }
            // If current element is different from both potential majority elements
            else {
                cnt1--; // Decrement count of first potential majority element
                cnt2--; // Decrement count of second potential majority element
            }
        }

        // Reset counters
        cnt1 = 0;
        cnt2 = 0;

        // Count occurrences of potential majority elements in the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele1) {
                cnt1++; // Increment count of first potential majority element
            } else if (nums[i] == ele2) {
                cnt2++; // Increment count of second potential majority element
            }
        }

        // Determine minimum count required for an element to be considered as majority
        int mini = (int) nums.length / 3 + 1;

        // Initialize list to store majority elements
        List<Integer> ans = new ArrayList<>();

        // If count of first potential majority element is greater than or equal to minimum count, add it to the list
        if (cnt1 >= mini) {
            ans.add(ele1);
        }
        // If count of second potential majority element is greater than or equal to minimum count, add it to the list
        if (cnt2 >= mini) {
            ans.add(ele2);
        }

        // Return list of majority elements
        return ans;
    }
}
