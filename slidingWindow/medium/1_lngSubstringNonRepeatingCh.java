/*Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring. */


import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Length of the input string
        int n = s.length();

        // HashMap to store characters and their last seen index
        HashMap<Character, Integer> mpp = new HashMap<>();

        // Pointers to track the left and right boundaries of the substring
        int l = 0, r = 0;

        // Variable to store the length of the longest substring
        int len = 0;

        // Sliding window approach to find the longest substring without repeating characters
        while (r < n) {
            // If the character at index 'r' is already present in the map
            if (mpp.containsKey(s.charAt(r))) {
                // Move the left pointer 'l' to the right of the last occurrence of the character
                l = Math.max(l, mpp.get(s.charAt(r)) + 1);
            }

            // Update the index of the current character in the map
            mpp.put(s.charAt(r), r);

            // Update the length of the longest substring found so far
            len = Math.max(len, r - l + 1);

            // Move the right pointer 'r' to the next character
            r++;
        }

        // Return the length of the longest substring without repeating characters
        return len;
    }
}
