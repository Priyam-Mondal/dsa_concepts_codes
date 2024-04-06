/*Example 1:
Input:

 Nums = [1,2,3,4,5,0]
Output:

 120
Explanation:

 In the given array, we can see 1×2×3×4×5 gives maximum product value.


Example 2:
Input:
 Nums = [1,2,-3,0,-4,-5]
Output:

 20
Explanation:

 In the given array, we can see (-4)×(-5) gives maximum product value. */


/*If the given array only contains positive numbers: If this is the case,
 we can confidently say that the maximum product subarray will be the entire array itself.
If the given also array contains an even number of negative numbers: As we know, 
an even number of negative numbers always results in a positive number.
 So, also, in this case, the answer will be the entire array itself.
If the given array also contains an odd number of negative numbers: Now, 
an odd number of negative numbers when multiplied result in a negative number.
 Removal of 1 negative number out of the odd number of negative numbers will leave us with
  an even number of negatives. Hence the idea is to remove 1 negative number from the result. Now we need to decide which 1 negative number to remove such that the remaining subarray yields the maximum product.
If the array contains 0’s as well: We should never consider 0’s in 
our answer(as considering 0 will always result in 0) and we want to obtain
 the maximum possible product. So, we will divide the given array based on 
 the location of the 0’s and apply the logic of case 3 for each subarray. */



class Solution {
    public int maxProduct(int[] nums) {
        // Initialize variables to keep track of the maximum product, prefix product, and suffix product
        int maxi = Integer.MIN_VALUE; // Initialize maxi with the minimum integer value to handle negative numbers
        int suf = 1; // Initialize suffix product as 1
        int pre = 1; // Initialize prefix product as 1

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If suffix product becomes 0, reset it to 1 to start a new subarray
            if (suf == 0) {
                suf = 1;
            }
            // If prefix product becomes 0, reset it to 1 to start a new subarray
            if (pre == 0) {
                pre = 1;
            }

            // Update prefix product by multiplying with the current element
            pre *= nums[i];
            // Update suffix product by multiplying with the element from the end of the array
            suf *= nums[nums.length - i - 1];

            // Update maxi with the maximum of maxi, prefix product, and suffix product
            maxi = Math.max(maxi, Math.max(pre, suf));
        }

        // Return the maximum product
        return maxi;
    }
}
