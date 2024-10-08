/*Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.
You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
Example 2:

Input: nums = [-1,0]
Output: [-1,0] */


package bit_manipulation.medium;

public class 5_single_number_III {
    // Function to find two unique numbers in an array where every other number appears twice
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        
        // Step 1: XOR all numbers. The result will be the XOR of the two unique numbers
        // because all duplicate numbers cancel out.
        for(int e : nums) {
            xor ^= e;
        }

        // Step 2: Find the rightmost set bit in xor (i.e., where the two unique numbers differ).
        // (xor & (xor - 1)) clears the rightmost set bit, so XORing it with xor isolates the rightmost set bit.
        int rightMostSetBit = (xor & (xor - 1)) ^ xor;

        int bucket1 = 0; // Holds XOR of one group (numbers with the rightmost set bit)
        int bucket2 = 0; // Holds XOR of the other group (numbers without the rightmost set bit)

        // Step 3: Divide numbers into two groups based on the rightmost set bit and XOR them.
        // One unique number will be in each group, as all duplicates will cancel out.
        for(int e : nums) {
            if((e & rightMostSetBit) != 0) {
                bucket1 ^= e; // XOR numbers with the set bit
            } else {
                bucket2 ^= e; // XOR numbers without the set bit
            }
        }

        // Step 4: Return the two unique numbers
        return new int[]{bucket1, bucket2};
    }
}
