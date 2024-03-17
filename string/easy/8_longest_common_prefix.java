/* Sample Input 1:
4
Codingninjas
Coding
Coders
Codezen


Sample Output 1:
Cod   

Explanation of sample output 1:
In the given testcase, the longest prefix that is present in all the strings is “Cod”. Hence the answer is “Cod”.  */



// ap 1 : 
//     1. nested loop
//     2. check for every character of every string in other string
// TC : O(n^2)


// ap 2: sorting
//     1. sort the array
//     2. this will group all strings lexicographically
//     3. run a loop and check only for first and last string
// TC : O(nlog(n))


import java.util.Arrays;
public class Solution {
    public static String commonPrefix(String []arr,int n){
        StringBuffer ans = new StringBuffer();

        Arrays.sort(arr);

        for(int i=0; i<arr[0].length(); i++){
            if(arr[0].charAt(i)==arr[n-1].charAt(i)){
                ans.append(arr[0].charAt(i));
            }else{
                break;
            }
        }
        if(ans.length()==0){
            return "-1";
        }
        return ans.toString();
    }
}