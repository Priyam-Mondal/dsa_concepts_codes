/*A monkey is given ‘n’ piles of bananas, where the 'ith' pile has ‘a[i]’ bananas.
An integer ‘h’ is also given, which denotes the time (in hours) in which all the bananas should be eaten.

Each hour, the monkey chooses a non-empty pile of bananas and eats ‘m’ bananas. 
If the pile contains less than ‘m’ bananas, then the monkey consumes all the bananas and 
won’t eat any more bananas in that hour.

Find the minimum number of bananas ‘m’ to eat per hour so that the monkey can eat all the bananas within ‘h’ hours.

Example:

Input: ‘n’ = 4, ‘a’ =  [3, 6, 2, 8] , ‘h’ = 7
Output: 3

Explanation: If ‘m’ = 3, then 
The time taken to empty the 1st pile is 1 hour.
The time taken to empty the 2nd pile is 2 hour.
The time taken to empty the 3rd pile is 1 hour.
The time taken to empty the 4th pile is 3 hour.
Therefore a total of 7 hours is taken. 
It can be shown that if the rate of eating bananas is reduced, they can’t be eaten in 7 hours.

Explanation Of Sample Input 2:
Input: ‘n’ = 5, ‘a’ = [25,12,8,14,19], ‘h’ = 5
Output: 25

Explanation: If ‘m’ = 25, 
The time taken to empty the 1st pile is 1 hour.
The time taken to empty the 2nd pile is 1 hour.
The time taken to empty the 3rd pile is 1 hour.
The time taken to empty the 4th pile is 1 hour.
The time taken to empty the 5th pile is 1 hour.
Therefore a total of 5 hours is taken. 
It can be shown that if the rate of eating bananas is reduced, they can’t be eaten in 5 hours.

*/

public class Solution {

    static int findMax(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
    static int findHours(int[] arr, int hourly) {
        int totalH=0;
        for(int i=0; i<arr.length; i++){
            totalH += Math.ceil((double)(arr[i]) / (double)(hourly));
        }
        return totalH;

    }
    public static int minimumRateToEatBananas(int []v, int h) {
        
        int low=1;
        //upperbound would be max element in array
        int high=findMax(v);
        int ans=Integer.MAX_VALUE;

        while(low<=high){
            int mid=(low+high)/2;

            //total hrs needed to eat all bananas with mid no of bananas/hr
            int totalH=findHours(v,mid);
            
            //we need min banana/hr, so we will go in left half
            if(totalH<=h){
                ans=Math.min(ans, mid);
                high=mid-1;
            }else{
                //search in right half
                low=mid+1;
            }
        }

        return ans;
    }
}



