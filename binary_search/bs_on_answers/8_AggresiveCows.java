/*You are given an array consisting of n integers which denote the position of a stall. 
You are also given an integer k which denotes the number of aggressive cows.
 You are given the task of assigning stalls to k cows such that the minimum distance between any two of them is the maximum possible.
The first line of input contains two space-separated integers n and k.
The second line contains n space-separated integers denoting the position of the stalls.

Example 1:

Input:
n=5 
k=3
stalls = [1 2 4 8 9]
Output:
3
Explanation:
The first cow can be placed at stalls[0], 
the second cow can be placed at stalls[2] and 
the third cow can be placed at stalls[3]. 
The minimum distance between cows, in this case, is 3, 
which also is the largest among all possible ways. */







class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        
        //mid dist always be 1
        int low=1;
        //max will be max-min of that array
        int high=stalls[n-1] - low;
        int ans=-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            //can we place k cows with min dist of mid
            if(canWePlace(stalls,n,k,mid)){
                ans=Math.max(mid,ans);
                //go to right half, cause we want max
                low=mid+1;
            }else{
                //go left half
                high=mid-1;
            }
        }
        
        return ans;
    }
    static boolean canWePlace(int[] stalls,int n, int cows,int dist){
        int cnt=1;
        int lastCow=stalls[0];
        
        for(int i=1; i<n; i++){
            if(stalls[i]-lastCow >= dist){
                cnt++;
                //track dist at the last cow placed
                lastCow=stalls[i];
                
                //can place all cows
                if(cnt==cows){
                    return true;
                }
            }
        }
        return false;
        
    }
}