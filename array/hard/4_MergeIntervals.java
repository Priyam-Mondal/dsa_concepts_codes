/*Given an array of intervals, merge all the overlapping 
intervals and return an array of non-overlapping intervals. 




Example 1:
Input:
 intervals=[[1,3],[2,6],[8,10],[15,18]]

Output:
 [[1,6],[8,10],[15,18]]

Explanation:
 Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6]
 intervals.

Example 2:
Input:
 [[1,4],[4,5]]

Output:
 [[1,5]]

Explanation:
 Since intervals [1,4] and [4,5] are overlapping we can merge them to form [1,5].

*/


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] merge(int[][] intervals) {
        // If there are one or fewer intervals, no merging is needed
        if(intervals.length <= 1) {
            return intervals;
        }
        
        // Create a list to store merged intervals
        List<int[]> mergedIntervals = new ArrayList<>();

        // Sort intervals based on the start value of each interval
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0]; // Sort by the start value
            }
        });

        // Merge intervals
        for(int i = 0; i < intervals.length; i++) {
            // If the list of merged intervals is empty or if the current interval does not overlap with the previous merged interval
            if(mergedIntervals.size() == 0 || mergedIntervals.get(mergedIntervals.size() - 1)[1] < intervals[i][0]) {
                mergedIntervals.add(new int[]{intervals[i][0], intervals[i][1]}); // Add the current interval to the list
            } else {
                // If the current interval overlaps with the previous merged interval, update the end value of the previous merged interval
                mergedIntervals.get(mergedIntervals.size() - 1)[1] = Math.max(mergedIntervals.get(mergedIntervals.size() - 1)[1], intervals[i][1]);
            }
        }

        // Convert the list of merged intervals to a 2D array
        int[][] result = new int[mergedIntervals.size()][];
        result = mergedIntervals.toArray(result);
        return result;
    }
}
