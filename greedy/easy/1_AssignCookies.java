/*Example 1:

Input: g = [1,2,3], s = [1,1]
Output: 1
Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, 
you could only make the child whose greed factor is 1 content.
You need to output 1.
Example 2:

Input: g = [1,2], s = [1,2,3]
Output: 2
Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
You have 3 cookies and their sizes are big enough to gratify all of the children, 
You need to output 2. */



class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Sort both arrays to make the greed factor and size of the cookies in ascending order
        Arrays.sort(g); 
        Arrays.sort(s);

        // Initialize pointers for child's greed factor and cookie size
        int i=0, j=0;

        // Iterate through the children's greed factors
        while(i<g.length){
            // Iterate through the cookie sizes
            while(j<s.length && g[i]>s[j]){
                // If the current cookie size is less than the child's greed factor, move to the next cookie
                j++;
            }
            // If all cookies are used or the current child cannot be satisfied by any remaining cookies, exit the loop
            if(j==s.length) break;

            // Move to the next child and the next available cookie
            i++;
            j++;
        }

        // Return the number of children that can be satisfied with the available cookies
        return i;
    }
}
