/*Example 1:
Input Format: N = 5, weights[] = {5,4,5,2,3,4,5,6}, d = 5
Result: 9
Explanation: If the ship capacity is 9, the shipment will be done in the following manner:
Day         Weights            Total
1        -       5, 4          -        9
2        -       5, 2          -        7
3        -       3, 4          -        7
4        -       5              -        5
5        -       6              -        6
So, the least capacity should be 9.

Example 2:

Input Format: N = 10, weights[] = {1,2,3,4,5,6,7,8,9,10}, d = 1
Result: 55
Explanation: We have to ship all the goods in a single day. 
So, the weight capacity should be the summation of all the weights i.e. 55.

Observation:

From the observations, it is clear that our answer lies in the range
[max(weights[]), sum(weights[])].

 */


 class Solution {

    static int findDays(int[] arr, int cap){
        int day=1;
        int load=0;
        for(int i=0; i<arr.length; i++){
            if(load+arr[i]>cap){
                day++;
                load=arr[i];
            }else{
                load+=arr[i];
            }
        }
        return day;
    }
    public int shipWithinDays(int[] weights, int days) {
        
        //Find the maximum and the summation:
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }

        while(low<=high){

            int mid=(low+high)/2;
            int totalDays=findDays(weights,mid);
            
            if(totalDays<=days){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return low;
    }
}