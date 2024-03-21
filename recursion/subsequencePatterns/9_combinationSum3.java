/*You are given ‘k’ and ‘n’ and you have to do the following:-

Return all possible combinations of arrays whose elements sum is equal to ‘n’, 
and you can use only elements in the range '1' to '9' inclusive, 
and you can use each element at most once, and the size of the combination should be exactly ‘k’.

If there is no combination, return an empty array.

It should be noted that the 2-D array should be returned in sorted order, 
meaning the lexicographically smaller array should come first.

Also, at each index of the 2-D array, the elements present in the array present at 
that index should be in sorted order.

Note:
Two combinations are called different if an element is in one combination and not in another. 

Also, in the output, you will see the 2-D array returned by you.


Example:
Input: ‘k’ = 2, ‘n’ = ‘5’

Output: [[1, 4], [2, 3]]

Sample Explanation: 1 + 4 = 5 and 2 + 3 = 5. 
Only these two combinations are there, which sum up to n, so the answer is [[1, 4], [2, 3]]. 

-----------------
Sample Input 1 :
2
5
Sample Output 1 :
1 4
2 3
Explanation Of Sample Input 1 :
1 + 4 = 5 and 2 + 3 = 5. 
Only these two combinations are there which sum upto n so answer is [[1, 4], [2, 3]].
Sample Input 2 :
3
8
Sample Output 2 :
1 2 5
1 3 4
Explanation Of Sample Input 2 :
1 + 2 + 5 = 8 and 1 + 3 + 4 = 8. 
Only these two combinations are there which sum upto n so answer is [[1, 2, 5], [1, 3, 4]].
*/


import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

    static void helper(int start, int k, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans){
        if(temp.size()==k){
            if(target==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(temp.size()>k || target<=0){
            return;
        }

        for(int i=start; i<=9; i++){
            temp.add(i);
            helper(i+1, k, target-i, temp, ans);
            temp.remove(temp.size()-1);
        }


    }
    static ArrayList<ArrayList<Integer>> combinationSum3(int k, int n) {
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();

        helper(1,k,n,temp,ans);

        return ans;

    }
}