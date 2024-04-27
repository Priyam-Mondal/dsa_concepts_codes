/*There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.

For Example
If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20. 


Sample Input 1:
2
4
10 20 30 10
3
10 50 10
Sample Output 1:
20
0
Explanation of sample input 1:
For the first test case,
The frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost).
Then a jump from the 2nd stair to the last stair (|10-20| = 10 energy lost).
So, the total energy lost is 20 which is the minimum. 
Hence, the answer is 20.

For the second test case:
The frog can jump from 1st stair to 3rd stair (|10-10| = 0 energy lost).
So, the total energy lost is 0 which is the minimum. 
Hence, the answer is 0.
*/




//**********************Recursion***********************

import java.util.* ;
import java.io.*; 
class Solution {
    public static int frogJump(int n, int heights[]) {
        
        return solve(n-1, heights);
        
    }
    static int solve(int n, int[] heights){
        if(n==0){
            return 0;
        }

        int jump1=solve(n-1, heights) + Math.abs(heights[n]-heights[n-1]);
        int jump2=Integer.MAX_VALUE;
        if(n>1){
            jump2=solve(n-2, heights) + Math.abs(heights[n]-heights[n-2]);
        }

        return Math.min(jump1,jump2);
    }

}



//***********************memoization**************** */

import java.util.* ;
import java.io.*; 
class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp=new int[n];
        Arrays.fill(dp, -1);

        solve(n-1, heights, dp);
        
        return dp[n-1];
        
    }
    static int solve(int n, int[] heights, int[] dp){
        if(n==0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        
        int jump1=solve(n-1, heights, dp) + Math.abs(heights[n]-heights[n-1]);
        int jump2=Integer.MAX_VALUE;
        if(n>1){
            jump2=solve(n-2, heights, dp) + Math.abs(heights[n]-heights[n-2]);
        }

        dp[n]=Math.min(jump1, jump2);
        return dp[n];
    }

}

