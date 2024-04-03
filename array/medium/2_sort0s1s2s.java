public class Solution {
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            // Placing 0 at the front
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Keeping 1 in the middle
                mid++;
            } else {
                // Placing 2 at the end of the array
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                // Not incrementing mid, because we don't know what value
                // was swapped from high (if 1 or 0),
                // so we have to check for that again
                high--;
            }
        }
    }
}
