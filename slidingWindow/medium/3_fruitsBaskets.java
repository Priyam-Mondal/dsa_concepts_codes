/*Sample Input 1:
4
1 1 2 3
Sample Output 1:
3 
Explanation of Sample Input 1:
There are four trees and the type of fruits in them are 1, 1, 2, 3 respectively.

One way is that Ninja can start picking fruits from tree 0. 
He picks one fruit from tree 0 and put it in the first basket, then he picks one fruit from tree 1 and put it in the first basket, then he picks one fruit from tree 2 and put it in the second basket, he cannot pick fruit from tree 3 because the first basket has the fruit of type 1 and second has the fruit of type 2 and type of fruit in tree-3 is 3. 

Thus he has to stop there. The number of fruits he picks in this way is 3.
 We can show that this is the maximum possible number of fruits ninjas can pick.
Sample Input 2:
4
1 2 3 4
Sample Output 2:
2
Explanation of Sample Input 2:
There are four trees, and each of them has different types of fruit. 
No matter from which tree Ninja starts picking fruits he can only collect 2 fruits. */



import java.util.HashMap;

public class Solution {
    public static int findMaxFruits(int[] arr, int n) {
        int l = 0, r = 0;
        int total = 0;
        int maxTotal = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        while (r < n) {
            // Increment the count of the current fruit in the HashMap
            mpp.put(arr[r], mpp.getOrDefault(arr[r], 0) + 1);
            total++;

            // If the number of different fruits exceeds 2, shrink the window
            while (mpp.size() > 2) {
                // Decrement the count of the fruit at the left pointer
                mpp.put(arr[l], mpp.get(arr[l]) - 1);
                total--;

                // If the count becomes 0, remove the fruit from the HashMap
                if (mpp.get(arr[l]) == 0) {
                    mpp.remove(arr[l]);
                }

                // Move the left pointer to the right
                l++;
            }

            // Move the right pointer to the right
            r++;

            // Update the maximum total if necessary
            maxTotal = Math.max(maxTotal, total);
        }

        return maxTotal;
    }
}
