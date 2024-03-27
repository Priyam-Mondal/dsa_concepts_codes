public class Solution {
    public static int countingGraphs(int N) {
        int ans,E;

        // Calculating the total number of edges possible in the graph.
        E = (N * (N-1)) / 2;

        // Calculating the total number of graphs.
        ans = 1 << E;

        // Returning 'ans'.
        return ans;
    }
}