/*You are given an array 'nums' of ‘n’ integers.
Return all subset sums of 'nums' in a non-decreasing order.

Note:
Here subset sum means sum of all elements of a subset of 'nums'. 
A subset of 'nums' is an array formed by removing some (possibly zero or all) elements of 'nums'.

For example
Input: 'nums' = [1,2]

Output: 0 1 2 3

Explanation:
Following are the subset sums:
0 (by considering empty subset)
1 
2
1+2 = 3
So, subset sum are [0,1,2,3]. 



Sample Input 1 :
3
1 2 3
Sample output 1 :
0 1 2 3 3 4 5 6
Explanation For Sample Output 1:
For the first test case,
Following are the subset sums:
0 (by considering empty subset)
1
2
1+2 = 3
3
1+3 = 4
2+3 = 5
1+2+3 = 6
So, subset-sums are [0,1,2,3,3,4,5,6]
*/




import java.util.* ;
import java.io.*; 
public class Solution {

    static void helper(int[] arr, int index, int sum, ArrayList<Integer> temp, ArrayList<Integer> ans){
        if(index==arr.length){
            ans.add(sum);
            return;
        }

        //including
        helper(arr,index+1,sum+arr[index],temp,ans);

        //excluding
        helper(arr,index+1,sum,temp,ans);
    }
    public static ArrayList<Integer> subsetSum(int num[]) {
        
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();

        helper(num, 0, 0, temp, ans);

        Collections.sort(ans);

        return ans;
    }

}