import java.util.* ;
import java.io.*; 
import java.util.ArrayList;


class Pair{
	int data;
	int row;
	int col;
	Pair(int data, int row, int col){
		this.data=data;
		this.row=row;
		this.col=col;
	}
}
//custom comprator
class MyComparator implements Comparator<Pair>{
	public int compare(Pair a, Pair b){
		if(a.data>b.data){
			return 1;
		}else if(a.data==b.data){
			return 0;
		}else{
			return -1;
		}
	}
}
public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
        //create a min heap to store array elements with its index(row,col)
		PriorityQueue<Pair> minHeap=new PriorityQueue<Pair>(new MyComparator());

        //add first element of every array in heap
		for(int i=0; i<kArrays.size(); i++){
			minHeap.add(new Pair(kArrays.get(i).get(0), i, 0));
		}

		ArrayList<Integer> ans=new ArrayList<>();
		while(!minHeap.isEmpty()){
			Pair t=minHeap.poll();
			int data=t.data;
			int row=t.row;
			int col=t.col;

            //remove from heap and add in ans
			ans.add(data);

            //add next element of current array into heap
			if(col+1 < kArrays.get(row).size()){
				minHeap.add(new Pair(kArrays.get(row).get(col+1), row, col+1));
			}
		}

		return ans;
	}
}
