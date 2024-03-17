/*The upper bound in a sorted array is the index of the first value that is greater than a given value. 
If the greater value does not exist then the answer is 'n', Where 'n' is the size of the array.
We are using 0-based indexing.
Try to write a solution that runs in log(n) time complexity.


Example:

Input : ‘arr’ = {2,4,6,7} and ‘x’ = 5,

Output: 2

Explanation: The upper bound of 5 is 6 in the given array, which is at index 2 (0-indexed). */


public class Solution {
    public static int upperBound(int []arr, int x, int n){
        int index=n;
        int s=0;
        int e=n-1;

        while(s<=e){
            int mid = s+(e-s)/2;
            if(arr[mid]>x){
                index=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return index;
    }
}
