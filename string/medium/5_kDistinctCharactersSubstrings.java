/*
Sample Input 1 :
aacfssa    
3
Sample Output 1 :
5    
Explanation of The Sample Input 1:
Given 'str' = “aacfssa”. We can see that the substrings with only 3 distinct characters are {aacf, acf, cfs, cfss, fssa}. 

Therefore, the answer will be 5.
Sample Input 2 :
qffds
4
Sample Output 2 :
1
 */


 /*----------------------
  ap 1: 
    1.generate all possible substring
    2. for each substring check if it contains k distinct characters
    3. if yes, increment res count

    but to generate all possible substring will take n*(n+1)/2
    and for check each substring will take O(n)

    TC : O(n^3)

ap 2: 
    1. use a arr[26]  to track freq of each substring

    TC: O(n^2)
  */


import java.util.Arrays;

public class Solution {
    // Method to count the number of substrings with exactly 'k' distinct characters
    public static int countSubStrings(String str, int k) {
        int ans = 0; // Initialize the answer count
        int[] freq = new int[26]; // Frequency array to count occurrences of characters
        int n = str.length(); // Length of the input string

        // Loop through each character as the starting point of the substring
        for (int i = 0; i < n; i++) {
            int distCount = 0; // Initialize the count of distinct characters
            Arrays.fill(freq, 0); // Reset the frequency array for each starting character

            // Loop through each character starting from the current position
            for (int j = i; j < n; j++) {
                char ch = str.charAt(j); // Get the current character

                // If the frequency of the current character is 0, it means it's a new distinct character
                if (freq[ch - 'a'] == 0) {
                    distCount++; // Increment the count of distinct characters
                    freq[ch - 'a']++; // Update the frequency of the current character
                }

                // If the count of distinct characters reaches 'k', increment the answer count
                if (distCount == k) {
                    ans++; // Increment the answer count
                }
            }
        }

        return ans; // Return the final answer count
    }
}