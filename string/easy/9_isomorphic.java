/*All occurrences of every character in the first string ‘str1’ should map 
to the same character in the second string, ‘str2’.
For example :
If str1 = “aab” and str2 = “xxy” then the output will be 1. ‘a’ maps to ‘x’ and ‘b’ maps to ‘y’.

If str1 = “aab” and str2 = “xyz” then the output will be 0. 
There are two different characters in 'str1', while there are three different characters in 'str2'. 
So there won't be one to one mapping between 'str1' and 'str2'. */


import java.util.*;

public class Solution {
    
    public static boolean areIsomorphic(String str1, String str2) {
        
        // Check if the lengths of the strings are different
        if(str1.length() != str2.length()) {
            return false; // If different, they cannot be isomorphic
        }

        // Create a HashMap to store mappings from characters in str1 to characters in str2
        HashMap<Character, Character> originalToReplacement = new HashMap<>();

        // Iterate over each character in the strings
        for(int i = 0; i < str1.length(); i++) {
            char original = str1.charAt(i); // Get the current character in str1
            char replacement = str2.charAt(i); // Get the current character in str2

            // If the current character in str1 is not already mapped
            if(!originalToReplacement.containsKey(original)) {
                // Check if the current character in str2 is not already used as a replacement
                if(!originalToReplacement.containsValue(replacement)) {
                    // If not, add the mapping from original to replacement
                    originalToReplacement.put(original, replacement);
                } else {
                    return false; // If already used, return false (not isomorphic)
                }
            } else {
                // If the current character in str1 is already mapped
                char mapped = originalToReplacement.get(original); // Get its replacement from the map
                if(mapped != replacement) {
                    return false; // If the replacement does not match, return false (not isomorphic)
                }
            }
        }
        return true; 
    }
}
