/*Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer 
(similar to C/C++'s atoi function).

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. 
Read this character in if it is either. This determines if the final result is negative or positive respectively. 
Assume the result is positive if neither is present.
Read in next the characters until the next non-digit character or the end of the input is reached. 
The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). 
If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], 
then clamp the integer so that it remains in the range. Specifically, 
integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
Note:

Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.

Example 2:

    Input: s = "   -42"
    Output: -42

Example 3:

    Input: s = "4193 with words"
    Output: 4193
    Explanation:
    Step 1: "4193 with words" (no characters read because there is no leading whitespace)
             ^
    Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
             ^
    Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
             ^
    The parsed integer is 4193.
    Since 4193 is in the range [-231, 231 - 1], the final result is 4193. */



class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        int sign = 1;
        while(i<n && s.charAt(i)==' ') {
            i++;
        }
        if (i>=n) {
            return 0;
        }
        if (s.charAt(i)=='-') {
            sign = -1;
        }
        if (s.charAt(i)=='+' || s.charAt(i)=='-') {
            i++;
        }

        if (i>=n) {
            return 0;
        }
        int num = 0;
        while (i<n && s.charAt(i)>='0' && s.charAt(i)<='9') {
            int x = s.charAt(i)-'0';
            
            /*num > Integer.MAX_VALUE/10: 
                This part checks if num is already greater than Integer.
                MAX_VALUE/10. If this condition is true, multiplying num by 10 would cause an overflow.

            Integer.MAX_VALUE/10 && x > Integer.MAX_VALUE % 10): 
                This part checks if num is equal to Integer.MAX_VALUE/10, 
                and the next digit x is greater than the last digit of Integer.MAX_VALUE. 
                This is necessary because if num reaches Integer.MAX_VALUE/10, and 
                the next digit is greater than the last digit of Integer.MAX_VALUE,
                 then multiplying num by 10 and adding that digit will cause an overflow. */
                 
            if (num>Integer.MAX_VALUE/10 || (num==Integer.MAX_VALUE/10 && x>Integer.MAX_VALUE%10)) {
                if (sign==1) {
                    return Integer.MAX_VALUE;
                }
                else {
                    return Integer.MIN_VALUE;
                }
            }
            num = num*10 + x;
            i++;
        }
        return num*sign;
    }
}
