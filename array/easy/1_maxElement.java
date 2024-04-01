import java.util.* ;
import java.io.*; 

public class Solution {

    static int largestElement(int[] arr, int n) {
        int maxEle=-1;
        for(int i=0; i<n; i++){
            maxEle=Math.max(maxEle,arr[i]);
        }
        return maxEle;

    }
}