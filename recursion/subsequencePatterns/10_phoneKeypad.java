class Solution {
    // Recursive function to generate letter combinations
    public void letterCombinationsSolve(String digits, int index, StringBuffer output, String[] map, List<String> ans){
        // Base case: If the index is equal to or exceeds the length of the digits string,
        // it means we have formed a complete combination, so add it to the answer list and return.
        if(index >= digits.length()){
            ans.add(new String(output)); // Add the current combination to the answer list
            return;
        }
        
        // Get the numeric value of the current digit
        int digit = digits.charAt(index) - '0';
        
        // Get the corresponding string mapping for the current digit
        String mapping = map[digit];
        
        // Iterate through each character in the mapping
        for(int i = 0; i < mapping.length(); i++){
            // Append the current character to the output buffer
            output.append(mapping.charAt(i));
            
            // Recur to explore combinations with the next digit
            letterCombinationsSolve(digits, index + 1, output, map, ans);
            
            // Backtrack: Delete the last added character to explore other combinations
            output.deleteCharAt(output.length() - 1);
        }
    }
    
    // Main function to generate letter combinations for a given digit string
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>(); // Initialize the list to store combinations
        
        // If the input string is empty, return an empty list
        if(digits.length() == 0){
            return ans;
        }
        
        // Mapping of digits to corresponding letters
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        int index = 0; // Start index for generating combinations
        StringBuffer output = new StringBuffer(); // Buffer to store the current combination
        
        // Call the recursive function to generate combinations
        letterCombinationsSolve(digits, index, output, map, ans);
        
        return ans; // Return the list of combinations
    }
}
