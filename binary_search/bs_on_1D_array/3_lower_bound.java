/*For a sorted array 'arr', 'lower_bound' of a number 'x' is defined as 
the smallest index 'idx' such that the value 'arr[idx]' is not less than 'x'

If all numbers are smaller than 'x', then 'n' should be the 'lower_bound' of 'x', where 'n' is the size of array.

Consider 0-based indexing.


Example:
Input: ‘arr’ = [1, 2, 2, 3] and 'x' = 0

Output: 0

Explanation: Index '0' is the smallest index such that 'arr[0]' is not less than 'x'. */



public class Solution {
    
    public static int lowerBound(int[] arr, int n, int x) {
        int s = 0, e = n - 1; 
        int index = n; // Initialize the index of the lower bound

        
        while (s <= e) {
            int mid = s + (e - s) / 2;

            // If the element at the middle index is less than the target value
            if (arr[mid] < x) {
                s = mid + 1; // Update start index to search in the right half
            }
            // If the element at the middle index is greater than or equal to the target value
            else if (arr[mid] >= x) {
                index = mid; // Update the potential lower bound index
                e = mid - 1; // Update end index to search in the left half
            }
        }
        
        return index;
    }
}
