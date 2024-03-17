/*Floor of 'x' is the largest element in the array which is smaller than or equal to 'x'.
Ceiling of 'x' is the smallest element in the array greater than or equal to 'x'.


Example:
Input: 
n=6, x=5, a=[3, 4, 7, 8, 8, 10]   

Output:
4

Explanation:
The floor and ceiling of 'x' = 5 are 4 and 7, respectively.

Sample Input 1 :
6 8
3 4 4 7 8 10

Sample Output 1 :
8 8

Explanation of sample input 1 :
Since x = 8 is present in the array, it will be both floor and ceiling.
*/

import java.util.* ;
import java.io.*; 

public class Solution {

    static int getFloor(int[] a, int n, int x){
      int s=0,e=n-1;
      int ans=-1;

      while(s<=e){
        int mid=s+(e-s)/2;
        if(a[mid]<=x){
          ans=a[mid];
          s=mid+1;
        }else{
          e=mid-1;
        }
      }
      return ans;
    }
    static int getCeli(int[] a, int n, int x){
      int s=0,e=n-1;
      int ans=-1;

      while(s<=e){
        int mid=s+(e-s)/2;
        if(a[mid]>=x){
          ans=a[mid];
          e=mid-1;
        }else{
          s=mid+1;
        }
      }
      return ans;
    }
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
      int floor=getFloor(a,n,x);
      int celi=getCeli(a,n,x);

      return new int[]{floor,celi};
    }
    
}