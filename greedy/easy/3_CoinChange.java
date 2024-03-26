/*
Problem statement : 
Given an infinite supply of Indian currency 
i.e. [1, 2, 5, 10, 20, 50, 100, 500, 1000] valued coins and an amount 'N'.

Find the minimum coins needed to make the sum equal to 'N'. 
You have to return the list containing the value of coins required in decreasing order.

For Example
For Amount = 70, the minimum number of coins required is 2 i.e an Rs. 50 coin and a Rs. 20 coin. 


Sample Input 1
13
Sample Output 1
10 2 1
Explanation of Sample Input 1
The minimum number of coins to change is 3 {1, 2, 10}.
Sample Input 2
50
Sample Output 2
50

*/

import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List<Integer> MinimumCoins(int v) {
        
        List<Integer> ans=new ArrayList<>();

        int[] coins={1,2,5,10,20,50,100,500,1000};
        int n=coins.length;

        for(int i=n-1; i>=0; i--){
            //taking best available option in each iteration
            while(v>=coins[i]){
                v-=coins[i];
                ans.add(coins[i]);
            }
        }

        return ans;
    }
}
