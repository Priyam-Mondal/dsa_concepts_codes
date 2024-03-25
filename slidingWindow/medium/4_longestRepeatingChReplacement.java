/*Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too. 


------------------------------------------

1.Use two pointers (left and right) to define a window in the string.
2.Maintain a character count array to track the frequency of characters within the window.
3.Move the right pointer to expand the window and update character counts.
4.Track the maximum count of any character within the window.
5.Shrink the window by moving the left pointer if the number of non-repeating characters exceeds k.
6.Update the maximum length of the valid substring seen so far.
7.Return the maximum length of the valid substring as the result.

*/


public class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26]; // Array to store the count of each character
        
        int left = 0; // Left pointer of the sliding window
        int right = 0; // Right pointer of the sliding window
        
        int result = 0; // Result variable to store the maximum length of substring with replacements
        int maxRepeat = 0; // Variable to track the maximum count of repeating characters within the window

        // Iterate through the string using the right pointer
        while (right < s.length()) {
            char c = s.charAt(right);
            map[c - 'A']++; // Increment the count of the current character
            maxRepeat = Math.max(maxRepeat, map[c - 'A']); // Update the maximum count
            
            // If the number of non-repeating characters within the window exceeds k
            while (right - left + 1 - maxRepeat > k) {
                map[s.charAt(left) - 'A']--; // Decrement the count of the leftmost character
                left++; // Move the left pointer to the right
            }
            result = Math.max(result, right - left + 1); // Update the maximum length of the substring
            right++; // Move the right pointer to the right
        }

        return result; // Return the maximum length of the substring with replacements
    }
}
