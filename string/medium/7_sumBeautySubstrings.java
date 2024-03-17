/*The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

For example, the beauty of "abaacc" is 3 - 1 = 2.
Given a string s, return the sum of beauty of all of its substrings.

Example 1:

    Input: s = "aabcb"
    Output: 5
    Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], 
    each with beauty equal to 1.

Example 2:

    Input: s = "aabcbaa"
    Output: 17

 TC : O(n^2)

  */


class Solution {

    static int getMin(int[] freq){
        int min=Integer.MAX_VALUE;
        for(int i=0; i<freq.length; i++){
            if(freq[i]!=0){
                min=Math.min(freq[i],min);
            }
        }
        return min;
    }
    static int getMax(int[] freq){
        int max=Integer.MIN_VALUE;
        for(int i=0; i<freq.length; i++){
            if(freq[i]!=0){
                max=Math.max(freq[i],max);
            }
        }
        return max;
    }
    public int beautySum(String s) {
        
        int ans=0;
        int n=s.length();

        for(int i=0; i<n; i++){
            // for each substring storing freq of its character
            int[] freq=new int[26];
            for(int j=i; j<n; j++){
                freq[s.charAt(j)-'a']++;
                int min=getMin(freq);
                int max=getMax(freq);

                int beauty=max-min;
                ans+=beauty;
            }
        }

        return ans;
    }
}