/*Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4. */



// if cur>next: subtract cur from ans
// else add to ans


class Solution {
    
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);

        int ans=0;
        for(int i=0; i<s.length()-1; i++){
            int cur=map.get(s.charAt(i));
            int next=map.get(s.charAt(i+1));
            if(cur<next){
                ans-=cur;
            }else{
                ans+=cur;
            }
        }
        ans+=map.get(s.charAt(s.length()-1));
        return ans;
    }
} 