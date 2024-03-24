/*Alice has some number of cards and she wants to rearrange 
the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and 
an integer groupSize, return true if she can rearrange the cards, or false otherwise.


Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
Example 2:

Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4. */


import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // Check if the hand size is divisible evenly by groupSize
        if (hand.length % groupSize != 0) return false;
        
        // Use a min-heap to track the smallest card of each potential group
        Queue<Integer> heap = new PriorityQueue<>();
        // Use a map to store the count of each card in the hand
        Map<Integer, Integer> map = new HashMap<>();

        // Count the occurrences of each card and store them in the map
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Add all unique cards to the min-heap
        for (int i : map.keySet()) {
            heap.offer(i);
        }

        // Iterate through the heap to check each potential group
        while (!heap.isEmpty()) {
            // Peek the smallest card in the heap
            int start = heap.peek();
            // Check if consecutive cards starting from 'start' can form a group
            for (int i = start; i < start + groupSize; i++) {
                // If the current card isn't present in the map, return false
                if (!map.containsKey(i)) return false;
                // Reduce the count of the current card in the map
                map.put(i, map.get(i) - 1);
                // If the count becomes 0, remove the card from the map and the heap
                if (map.get(i) == 0) {
                    // Check if the current card is indeed the smallest in the heap
                    if (i != heap.peek()) return false;
                    // Remove the current card from the heap
                    heap.poll();
                }
            }
        }
        // If all potential groups pass the checks, return true
        return true;
    }
}
