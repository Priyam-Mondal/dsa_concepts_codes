/*Sample Input 1 :
Welcome to Coding Ninjas
Sample Output 1:
Ninjas Coding to Welcome */


class Solution {
    // Method to reverse the order of words in a string
    public String reverseWords(String str) {
        // Split the input string into an array of words based on spaces
        String[] arr = str.split(" ");
        // StringBuilder to store the reversed string
        StringBuilder ans = new StringBuilder();

        // Iterate over the array of words in reverse order
        for (int i = arr.length - 1; i >= 0; i--) {
            // Check if the current word is not empty
            if (!arr[i].isEmpty()) {
                // Append the current word to the StringBuilder followed by a space
                ans.append(arr[i]).append(" ");
            }
        }

        // Remove trailing space if any
        if (ans.length() > 0) {
            ans.setLength(ans.length() - 1);
        }

        // Convert StringBuilder to String and return the reversed string
        return ans.toString();
    }
}
