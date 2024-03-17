/*Example 1:
Input Format: N = 5, arr[] = {1,2,3,4,5}, limit = 8
Result: 3
Explanation: We can get a sum of 15(1 + 2 + 3 + 4 + 5) if we choose 1 as a divisor. 
The sum is 9(1 + 1 + 2 + 2 + 3)  if we choose 2 as a divisor. 
Upon dividing all the elements of the array by 3, we get 1,1,1,2,2 respectively. 
Now, their sum is equal to 7 <= 8 i.e. the threshold value. So, 3 is the minimum possible answer.

Example 2:
Input Format: N = 4, arr[] = {8,4,2,3}, limit = 10
Result: 2
Explanation: If we choose 1, we get 17 as the sum. 
If we choose 2, we get 9(4+2+1+2) <= 10 as the answer. So, 2 is the answer.

Point to remember:
While dividing the array elements with a chosen number, we will always take the ceiling value. 
And then we will consider their summation. For example, 3 / 2 = 2. */



class Solution {

    //return sum of arr[i]/divisor
    static int findSum(int[] arr, int div){
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum += Math.ceil((double)arr[i] / (double)div);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            high=Math.max(nums[i],high);
        }

        while(low<=high){
            int mid=(low+high)/2;
            int sum=findSum(nums,mid);
            
            if(sum<=threshold){
                //we find a possible ans, but still move left to get the smallest ans
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return low;
    }
}