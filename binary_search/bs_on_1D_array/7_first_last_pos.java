/*1. If ‘k’ is not present in the array, then the first and the last occurrence will be -1. 
2. 'arr' may contain duplicate elements.


Example:
Input: 'arr' = [0,1,1,5] , 'k' = 1

Output: 1 2

Explanation:
If 'arr' = [0, 1, 1, 5] and 'k' = 1, then the first and last occurrence of 1 will be 1(0 - indexed) and 2. */



import java.util.ArrayList;

public class Solution {

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        int first = -1;
        int last = -1;

        int si = 0;
        int ei = n - 1;

        // To find first position
        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (arr.get(mid) == k) {
                first = mid;
                ei = mid - 1;
            } else if (arr.get(mid) < k) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        si = 0;
        ei = n - 1;

        // To find last position
        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (arr.get(mid) == k) {
                last = mid;
                si = mid + 1;
            } else if (arr.get(mid) < k) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return new int[]{first,last};
    }
}
