/*
1.Build a max heap from the input array.
2. Repeatedly swap the root element (the maximum element) with the last element of the heap 
    and reduce the size of the heap by one.
3. Heapify the heap to maintain the max heap property after each swap. */



public class HeapSort {

    static void swap(int[] arr, int a, int b){
        int t=arr[a];
        arr[a]=arr[b];
        arr[b]=t;
    }

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

    static void heapSort(int[] arr){
        int size=arr.length-1;

        while(size>1){
            //step 1: swap first and last element
            swap(arr, 0, size);

            //step 2: decrement size by 1
            size--;

            //step 3: heapify subpart from 0 to size
            heapify(arr, size, 0);
        }
    }
    public static void main(String[] args) {
        int[] arr={54,53,55,52,50};
        int n=arr.length;

        //heap creation
        for(int i=n/2-1; i>=0; i--){
            heapify(arr,n,i);
        }

        System.out.println("Before sorting: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }

        heapSort(arr);

        System.out.println("\nAfter sorting: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
    
}
