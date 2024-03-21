/*You are given an array ‘arr’ of ‘n’ positive integers.
You are also given a positive integer ‘target’.

Your task is to find all unique combinations of elements of array ‘arr’ 
whose sum is equal to ‘target’. Each number in ‘arr’ may only be used once in the combination.

Elements in each combination must be in non-decreasing order and you need 
to print all unique combinations in lexicographical order.

Note:
In lexicographical order, combination/array  ‘a’  comes before array ‘b’ if 
at the first index 'i' where 'a[i]' differs from 'b[i]', 'a[i]' < 'b[i]  or length of 'a' is less than 'b'.

Example:
Input: ‘arr’ = [1, 2, 3, 1], ‘target’ = 5. 

Output: [[1,1,3], [2,3]]

Explanation:
All possible valid combinations with sum = 5 in lexicographical order are -:
(1, 1, 3)
(2, 3) 



Sample Input 1:
7 8
10 1 2 7 6 1 5

Sample Output 1:
1 1 6
1 2 5
1 7
2 6

Explanation For Sample Input 1:
Here ‘n’ = 7, 'arr' = [10, 1, 2, 7, 6, 1 , 5], and ‘target’ = 8
All unique combinations whose sum of elements is 8 are -:     

(1, 1, 6)  because, 1 + 1 + 6 = 8
(1, 2, 5)  because,  1 + 2 + 5 = 8
(1, 7)  because, 1 + 7 = 8                                                                                                               
(2, 6)  because,  2 + 6 = 8

*/


import java.util.*;

public class Solution 
{

    static void helper(ArrayList<Integer> arr, int target, int index, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans ){
        // If target is reached (target becomes 0), add the current combination to the answer
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        // Including elements for combination
        for(int i = index; i < arr.size(); i++){
            // Skip duplicates to avoid duplicate combinations
            if(i > index && arr.get(i) == arr.get(i-1)) continue;
            // If the current element is greater than the remaining target, no need to proceed further
            if(arr.get(i) > target) break;

            // Add the current element to the temporary combination
            temp.add(arr.get(i));
            // Recursive call to find combinations with the updated target and index
            // Increment index to avoid reusing the same element
            helper(arr, target - arr.get(i), i + 1, temp, ans);
            // Backtrack: Remove the last added element to explore other combinations
            temp.remove(temp.size() - 1);
        }

    }
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)
    {
        // Sort the input array to handle duplicates and make the process efficient
        Collections.sort(arr);
        
        // Initialize a list to store the combinations that sum up to the target
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // Initialize a temporary list to store each combination temporarily
        ArrayList<Integer> temp = new ArrayList<>();
        // Call the helper function to find combinations recursively
        helper(arr, target, 0, temp, ans);

        // Return the list of combinations
        return ans;

    }
}