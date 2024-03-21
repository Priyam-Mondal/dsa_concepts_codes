import java.util.*;

public class Solution {

	static void helper(int[] arr, int index, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans){
        if(index==arr.length){
            if(!ans.contains(temp)){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        //including
		temp.add(arr[index]);
        helper(arr,index+1,temp,ans);
		temp.remove(temp.size()-1);

        //excluding
        helper(arr,index+1,temp,ans);
    }
	public static void printSubsets(int input[]) {
		
        Arrays.sort(input);

		ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();

        helper(input, 0, temp, ans);

        // Sort the ans list based on the natural order of its elements (lists)
        Collections.sort(ans, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> list1, List<Integer> list2) {
                // Compare each element in the two lists until finding a difference
                for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
                    int cmp = Integer.compare(list1.get(i), list2.get(i));
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                // If one list is a prefix of the other, compare their sizes
                return Integer.compare(list1.size(), list2.size());
            }
        });


        // Print or use the sorted subsets
        for (List<Integer> subset : ans) {
            System.out.println(subset);
        }

	}
}