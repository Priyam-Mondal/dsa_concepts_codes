/*
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

special case:
    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.
 
Example 1:

Input: num = 3
Output: "III"
Explanation: 3 is represented as 3 ones.
Example 2:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 3:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4. */


class Solution {
    public String intToRoman(int num) {
        TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int value = entry.getKey();
            String roman = entry.getValue();
            while (num >= value) {
                ans.append(roman);
                num -= value;
            }
        }

        return ans.toString();
    }
}