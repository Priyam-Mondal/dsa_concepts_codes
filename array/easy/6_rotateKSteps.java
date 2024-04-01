import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        for(int i=0; i<k; i++){
            int lastEle = arr.remove(0);
            arr.add(lastEle);
        }
        return arr;
    }
}