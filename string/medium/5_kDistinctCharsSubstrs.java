/*
 Given a string of lowercase alphabets, count all possible substrings (not necessarily distinct) 
 that have exactly k distinct characters. 

Example 1:

Input: S = "aba", K = 2
Output:3
Explanation:The substrings are: "ab", "ba" and "aba".
Input: S = "abaaca", K = 1
Output: 7
Explanation: The substrings are: "a", "b", "a", "aa", "a", "c", "a". 
 */


class 5_kDistinctCharsSubstrs
{
    long substrCount (String S, int K) {
        // (substr with atmost k unique chars) - ((substr with atmost k-2 unique chars))
        return solve(S,K) - solve(S,K-1);
    }
    private long solve(String s, int k){
        int[] freq=new int[26];
        int uc=0;
        int subCount=0;
        int left=0;
        
        for(int right=0; right<s.length(); right++){
            char ch=s.charAt(right);
            //char first appeared
            if(freq[ch-'a']==0){
                uc++;
            }
            //repeated char,increment freq
            freq[ch-'a']++;
            
            //we are finding substr with atmost k distinct chars
            //if uc becomes > k then increment left pointer
            while(uc>k){
                char c=s.charAt(left);
                freq[c-'a']--;
                if(freq[c-'a']==0){
                    uc--;
                }
                left++;
            }
            //add number of substr in current window
            //having atmost k distinct chars
            subCount+=right-left+1;
            
        }
        return subCount;
    }
    
}