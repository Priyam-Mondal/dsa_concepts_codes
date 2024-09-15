/*Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character 
while preserving the order of characters. 
No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "foo", t = "bar"

Output: false*/

import java.util.Arrays;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        // Using a larger array size to accommodate all ASCII characters
        int[] mpS = new int[128];  // Mapping for string 's' to 't'
        int[] mpT = new int[128];  // Mapping for string 't' to 's'

        Arrays.fill(mpS, -1);
        Arrays.fill(mpT, -1);

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            // Check if the mapping for s->t and t->s is consistent
            if (mpS[cs] == -1 && mpT[ct] == -1) {
                mpS[cs] = ct;  // Map 's' character to 't' character
                mpT[ct] = cs;  // Map 't' character to 's' character
            } else if (mpS[cs] != ct || mpT[ct] != cs) {
                return false;  // Mappings are inconsistent
            }
        }
        return true;
    }
}
