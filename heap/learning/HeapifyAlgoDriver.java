public class HeapifyAlgoDriver {

    static void swap(int[] arr, int a, int b){
        int t=arr[a];
        arr[a]=arr[b];
        arr[b]=t;
    }

    //main code for heapify algo
    static void heapify(int[] arr, int n, int i) {
        while (i < n) {
            int left = 2*i+1;
            int right = 2*i+2;
            int max = i;
            //comparing with left and right child
            if (left < n && arr[left] > arr[max]) {
                max = left;
            }
    
            if (right < n && arr[right] > arr[max]) {
                max = right;
            }
            
            //swap current node with left or right child
            //max!=i means cur node not in its right position
            if (max != i) {
                swap(arr, i, max);
                i = max;
            } else {
                return;
            }
        }
    } 
    public static void main(String[] args){
        int[] arr={54,53,55,52,50};
        int n=arr.length;

        for(int i=n/2-1; i>=0; i--){
            heapify(arr,n,i);
        }

        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
