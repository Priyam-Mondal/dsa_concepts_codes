/* Given an array of integers A and an integer B. 
Find the total number of subarrays having bitwise XOR of all elements equal to k. 


Example 1:
Input Format:
 A = [4, 2, 2, 6, 4] , k = 6
Result:
 4
Explanation:
 The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]

Example 2:
Input Format:
 A = [5, 6, 7, 8, 9], k = 5
Result:
 2
Explanation:
 The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]
*/



import java.util.HashMap;

public class Solution {
    public static int subarraysWithSumK(int []a, int b) {
        
        // (xor,count)
        HashMap<Integer,Integer> mp=new HashMap<>();
        int cnt=0;
        int xr=0;

        //setting for xor value 0
        mp.put(xr,1);

        for(int i=0; i<a.length; i++){
            xr^=a[i];

            //find remaining part
            // x = xr^k
            int x=xr^b;

            //add count of x to  cnt 
            if(mp.containsKey(x)){
                cnt+=mp.get(x);
            }

            //insert prefix xor till index i
            mp.put(xr, mp.getOrDefault(xr,0)+1);

        }

        return cnt;
    }
}