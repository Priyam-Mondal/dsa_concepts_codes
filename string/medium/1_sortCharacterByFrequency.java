/*Given a string s, sort it in decreasing order based on the frequency of the characters. 
The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters. */


import java.util.*;

class Solution {
    public String frequencySort(String s) {
        if(s.length() == 0) return ""; // Return an empty string instead of null when the input is empty

        // Add char and freq in hashmap
        Map<Character, Integer> hm1 = new HashMap<>();
        for (char ch : s.toCharArray()) {
            hm1.put(ch, hm1.getOrDefault(ch, 0) + 1);
        }

        // Mapping freq to char in another map and tracking max freq
        int max = 0;
        Map<Integer, List<Character>> hm2 = new HashMap<>();
        for (char ch : hm1.keySet()) {
            int freq = hm1.get(ch);
            max = Math.max(freq, max);
            List<Character> charList = hm2.getOrDefault(freq, new LinkedList<>()); // Initialize list if it doesn't exist
            charList.add(ch); // Add character to the list
            hm2.put(freq, charList); // Put the updated list back in the map
        }

        // Creating ans by traversing from max freq
        StringBuilder ans = new StringBuilder();
        for (int i = max; i > 0; i--) {
            if (hm2.containsKey(i)) {
                List<Character> temp = hm2.get(i);
                Collections.sort(temp); // Sort characters alphabetically
                for (char cur : temp) {
                    for (int j = 0; j < i; j++) { // Iterate up to the frequency of the character
                        ans.append(cur);
                    }
                }
            }
        }

        return ans.toString(); // Return the constructed string after the loop completes
    }
}
