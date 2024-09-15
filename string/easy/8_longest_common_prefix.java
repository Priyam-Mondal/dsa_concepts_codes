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


class Solution {
    public String longestCommonPrefix(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}