import java.util.List;
public class Solution {
    public static int pop(List<Integer> heap) {
        
        if(heap.isEmpty()){
            return -1;
        }

        //get first element
        int val=heap.get(0);

        //remove last element
        int lastEle=heap.remove(heap.size()-1);

        if(!heap.isEmpty()){
            //replace first element with last element
            heap.set(0, lastEle);

            //place root at its right position
            heapifyDown(heap,0);
        }

        return val;
    }

    public static void heapifyDown(List<Integer> heap, int i){

        int n=heap.size();

        int max=i;
        int left=2*i+1;
        int right=2*i+2;

        if(left<n && heap.get(left)>heap.get(max)){
            max=left;
        }
        if(right<n && heap.get(right)>heap.get(max)){
            max=right;
        }

        if(max!=i){

            //step 1: swap current with max
            int t=heap.get(i);
            heap.set(i,heap.get(max));
            heap.set(max, t);

            //step 2: recursive calls
            heapifyDown(heap, max);
        }
    }

    // Code Snippet of the push function:
    public static void push(List<Integer> heap, int x) {
            heap.add(x);
    
            // Position of the current inserted element.
            int pos = heap.size() - 1;
    
            // Shifting the element up until it reaches the topmost node if it is larger than its parent.
            while (pos > 0) {
                int parent = (pos - 1) / 2;
                if (heap.get(pos) > heap.get(parent)) {
                    // Swapping the elements.
                    int temp = heap.get(parent);
                    heap.set(parent, heap.get(pos));
                    heap.set(pos, temp);
                    pos = parent;
                } else {
                    // As parent is larger, the element is now in its correct position.
                    break;
                }
            }
        }
}
