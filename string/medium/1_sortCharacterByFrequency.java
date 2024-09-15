/*Given a string s, sort it in decreasing order based on the frequency of the characters. 
The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters. */

class Solution {
    public String frequencySort(String s) {
        //map to store char freq
        HashMap<Character,Integer> hm=new HashMap<>();

        for(char c:s.toCharArray()){
            hm.put(c, hm.getOrDefault(c,0)+1);
        }

        //priority queue to sort based on freq in decreasing order
        PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>((a,b)->{
            return b.getValue()-a.getValue();
        });
        //adding all entries in map
        pq.addAll(hm.entrySet());

        StringBuilder ans=new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> e=pq.poll();
            for(int i=0; i<e.getValue(); i++){
                ans.append(e.getKey());
            }
        }
        return ans.toString();

    }
}