/*
There are N meetings in the form of (S[i], F[i]) where S[i] is the start time 
of meeting i and F[i] is the finish time of meeting i. 
The task is to find the maximum number of meetings that can be accommodated in the meeting room. 
You can accommodate a meeting if the start time of the meeting is strictly greater 
than the finish time of the previous meeting. Print all meeting numbers.

Note: If two meetings can be chosen for the same slot then choose meeting that finishes earlier.

Example 1:

Input:
N = 6
S = {1,3,0,5,8,5}
F = {2,4,6,7,9,9} 
Output:
{1,2,4,5}
Explanation:
We can attend the 1st meeting from (1 to 2), then the 2nd meeting from (3 to 4), then the 4th meeting from (5 to 7), and the last meeting we can attend is the 5th from (8 to 9). It can be shown that this is the maximum number of meetings we can attend.
Example 2:

Input:
N = 1
S = {3}
F = {7}
Output:
{1}
Explanation:
Since there is only one meeting, we can attend the meeting. */





import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        // Creating a 2D array to store the end times and the indices of meetings
        int[][] meetings = new int[N][2];
        
        // Storing the end times and the corresponding indices of meetings in the 2D array
        for (int i = 0; i < N; i++) {
            meetings[i][0] = F[i]; // End time of the meeting
            meetings[i][1] = i;    // Index of the meeting
        }
        
        // Sorting the meetings based on their end times in ascending order
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        
        // Variable to track the end time of the last scheduled meeting
        int tym = meetings[0][0];
        
        // ArrayList to store the indices of the meetings that can be accommodated
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Adding the index of the first meeting since it's guaranteed to be included
        ans.add(meetings[0][1] + 1); // Adding 1 to the index since it is 0-based in arrays
        
        // Iterating through the sorted meetings
        for (int i = 1; i < N; i++) {
            // Checking if the start time of the current meeting is after the end time of the last scheduled meeting
            if (S[meetings[i][1]] > tym) {
                // If yes, adding the index of the current meeting to the list of accommodated meetings
                ans.add(meetings[i][1] + 1); // Adding 1 to the index since it is 0-based in arrays
                // Updating the end time of the last scheduled meeting
                tym = meetings[i][0];
            }
        }
        
        // Sorting the list of accommodated meetings in ascending order
        Collections.sort(ans);
        
        // Returning the list of accommodated meetings
        return ans;
    }
}
