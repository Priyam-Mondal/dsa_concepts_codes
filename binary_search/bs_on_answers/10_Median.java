/*Given two sorted arrays array1 and array2 of size m and n respectively. Find the median of the two sorted arrays.

Example 1:

Input:
m = 3, n = 4
array1[] = {1,5,9}
array2[] = {2,3,6,7}
Output: 5
Explanation: The middle element for
{1,2,3,5,6,7,9} is 5
Example 2:

Input:
m = 2, n = 4
array1[] = {4,6}
array2[] = {1,2,3,5}
Output: 3.5 */


class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        
        if(n>m){
            return medianOfArrays(m,n,b,a);
        }
        
        int low=0;
        int high=n;
        int totalLength=n+m;
        
        //items to be from left half
        int left=(totalLength+1)/2;
        
        while(low<=high){
            //items from 1st array
            int mid1=(low+high)/2;
            //items from 2nd array
            int mid2=(left-mid1);
            
            int l1=mid1>0 ? a[mid1-1] : Integer.MIN_VALUE;
            int l2=mid2>0 ? b[mid2-1] : Integer.MIN_VALUE;
            int r1=mid1<n ? a[mid1] : Integer.MAX_VALUE;
            int r2=mid2<m ? b[mid2] : Integer.MAX_VALUE;
            
            //valid symmetry
            if(l1<=r2 && l2<=r1){
                if(totalLength % 2==1){
                    return Math.max(l1, l2);
                }else{
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
                }
            }else if(l1 > r2){
                high = mid1 - 1;
            }
            else{
                low = mid1 + 1;
            }
        }
        return 0;
    }
}