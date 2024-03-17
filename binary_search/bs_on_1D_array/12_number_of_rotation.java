/*Right rotating an array means shifting the element at 'ith' index to (‘i+1') mod 'n' index, 
for all 'i' from 0 to ‘n-1'.

Example:
Input: 'n' = 5 , ‘arr’ = [3, 4, 5, 1, 2]

Output: 3 

Explanation:
If we rotate the array [1 ,2, 3, 4, 5] right '3' times then we will get the 'arr'. Thus 'r' = 3. */


public class Solution {
    public static int findKRotation(int []arr){
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index=-1;

        while (low <= high) {
            int mid = (low + high) / 2;

            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if (arr[low] <= arr[high]) {
                if(arr[low]<ans){
                    ans=arr[low];
                    index=low;
                }
                break;
            }

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                if(arr[low]<ans){
                    ans=arr[low];
                    index=low;
                }

                // Eliminate left half:
                low = mid + 1;

            } else { //if right part is sorted:

                // keep the minimum:
                if(arr[high]<ans){
                    ans=arr[mid];
                    index=mid;
                }

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return index;
    }
}