/*Sample Input 1:
15
(3*(4*(5*(6))))
Sample Output 1:
4
Explanation Of Sample Input 1:
Input:
S = '(3*(4*(5*(6))))', N = 15
Output: 4

Explanation: The digit 6 is inside of 4 nested parentheses. Hence we return 4. */

public class Solution {
    public static int maxDepth(String s) {
        int cnt=0;
        int maxCnt=Integer.MIN_VALUE;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                cnt++;
            }else if(ch==')'){
                cnt--;
            }
            maxCnt=Math.max(cnt,maxCnt);
        }
        return maxCnt;
    }
}