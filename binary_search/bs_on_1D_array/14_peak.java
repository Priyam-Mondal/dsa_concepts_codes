/*Peak element is defined as that element that is greater than both of its neighbors. 
If 'arr[i]' is the peak element, 'arr[i - 1]' < 'arr[i]' and 'arr[i + 1]' < 'arr[i]'.

Assume 'arr[-1]' and 'arr[n]' as negative infinity.

Note:
1.  There are no 2 adjacent elements having same value (as mentioned in the constraints).
2.  Do not print anything, just return the index of the peak element (0 - indexed).
3. 'True'/'False' will be printed depending on whether your answer is correct or not.

Example:

Input: 'arr' = [1, 8, 1, 5, 3]

Output: 3

Explanation: There are two possible answers. Both 8 and 5 are peak elements, 
so the correct answers are their positions, 1 and 3. */


import java.util.ArrayList;
public class Solution {
    public static int findPeakElement(ArrayList<Integer> arr) {
    // Get the size of the ArrayList
    int n = arr.size();

    // Check if the first element is greater than the second element, if so, it's a peak
    if (arr.get(0) > arr.get(1)) {
        return 0;
    }

    // Check if the last element is greater than the second to last element, if so, it's a peak
    if (arr.get(n - 1) > arr.get(n - 2)) {
        return n - 1;
    }

    // Binary search for the peak element within the array
    int start = 1; // Start index of the array
    int end = n - 2; // End index of the array

    while (start <= end) {
        int mid = start + (end - start) / 2; // Calculate the middle index

        // Check if the middle element is greater than its neighbors, indicating a peak
        if (arr.get(mid) > arr.get(mid - 1) && arr.get(mid) > arr.get(mid + 1)) {
            return mid;
        } else if (arr.get(mid) < arr.get(mid + 1)) {
            // If the middle element is less than its right neighbor, move towards the right
            start = mid + 1;
        } else {
            // If the middle element is less than its left neighbor, move towards the left
            end = mid - 1;
        }
    }

    // If no peak is found, return -1
    return -1;
}

};
