/*Input: m = 5
       n = 4
       array1 = [2,3,6,7,9]
       array2 = [1,4,8,10]
       k = 5

Output:
 6

Explanation: Merging both arrays and sorted. Final array will be -
 [1,2,3,4,6,7,8,9,10]
We can see at k = 5 in the final array has 6. 


Input:
 m = 1
       n = 4
       array1 = [0]
       array2 = [1,4,8,10]
       k = 2

Output:
 4

Explanation:
 Merging both arrays and sorted. Final array will be -
 [1,4,8,10]
We can see at k = 2 in the final array has 4 */




class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        // If the length of arr1 is greater than the length of arr2, swap arrays to ensure n is always less than or equal to m
        if(n>m){
            return kthElement(arr2,arr1,m,n,k);
        }
        
        // Initialize the search space boundaries
        int low=Math.max(0,k-m);
        int high=Math.min(k,n);
        
        // Binary search on the smaller array
        while(low<=high){
            // Calculate the midpoints for both arrays
            int mid1=(low+high)/2; // Number of items from arr1
            int mid2=k-mid1;       // Number of items from arr2
            
            // Calculate left and right elements for both arrays
            int l1 = mid1==0 ? Integer.MIN_VALUE : arr1[mid1-1];
            int l2 = mid2==0 ? Integer.MIN_VALUE : arr2[mid2-1];
            int r1 = mid1==n ? Integer.MAX_VALUE : arr1[mid1];
            int r2 = mid2==m ? Integer.MAX_VALUE : arr2[mid2];
            
            // Check if we have found the kth element
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2); // Return the maximum of left elements
            } else if(l1>r2){ // If arr1's partition is too big, move to the left side
                high=mid1-1;
            } else { // If arr1's partition is too small, move to the right side
                low=mid1+1;
            }
        }
        return 0; // This should never happen if inputs are valid
    }
}
