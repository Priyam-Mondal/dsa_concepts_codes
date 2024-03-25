/*
Count the number of substrings which contains at least one occurrence of all these characters: a, b, and c.

Example:
For 'n' = 5, 's’ = “abbac”.
Answer is 3.
These are the only 3 valid substrings { “abbac”, ”bbac”, ”bac” } satisfying all the constraints.

Sample Input 1:
4
baac
Sample Output 1:
1
Explanation of sample output 1:
‘n’ = 4,'s’ = “baac”.
Answer is 1. The only possible substring is “baac”.
Sample Input 2:
8
bababcc
Sample Output 2:
8

*/


public class Solution {
    /*
        Function to count number of strings having atleast
        one occurence of each character 'a', 'b' and 'c'.

    */
    public static int countSubstring(String s){
        // Initialising 'ans' to 0.
        int ans = 0;
        int n = s.length();

        // Initialising index of last occurrence of each character to '-1'.
        int aIdx = -1, bIdx = -1, cIdx = -1;
        for (int i = 0; i < n; i++)
        {

            // Updating the index of last occurrence of each character.
            if (s.charAt(i) == 'a')
            {
                aIdx = i;
            }
            else if (s.charAt(i) == 'b')
            {
                bIdx = i;
            }
            else if (s.charAt(i) == 'c')
            {
                cIdx = i;
            }

            int minIdx = Math.min(aIdx, Math.min(bIdx, cIdx));

            // Adding count of all valid substrings.
            ans = ans + (minIdx + 1);
        }
        return ans;
    }
}