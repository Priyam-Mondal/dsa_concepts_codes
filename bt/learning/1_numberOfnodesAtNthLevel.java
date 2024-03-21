public class Solution {
    public static int numberOfNodes(int N){
        
        //same as 1 * 2^(N-1)
        return 1<<N-1;
    }
}