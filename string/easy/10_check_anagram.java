/* An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false */


class Solution {
    
    public boolean isAnagram(String s, String t) {
        // Check if the lengths of the strings are different
        if (s.length() != t.length()) {
            return false; // If different, they cannot be anagrams
        }
        
        // Array to store the frequency of characters in the strings
        int[] freq = new int[26]; // Assuming ASCII lowercase characters (a-z)

        // Iterate over each character in both strings
        for (int i = 0; i < s.length(); i++) {
            // Increment frequency for character in s and decrement for character in t
            freq[s.charAt(i) - 'a']++; 
            freq[t.charAt(i) - 'a']--; 
        }
        
        // Check if all frequencies are zero
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false; // If any frequency is non-zero, return false (not anagrams)
            }
        }

        return true; 
    }
}
