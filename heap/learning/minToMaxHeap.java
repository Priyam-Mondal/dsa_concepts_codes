public class Solution {

    static void swap(int[] arr, int a, int b){
        int t=arr[a];
        arr[a]=arr[b];
        arr[b]=t;
    }

    static void heapify(int[] arr, int n, int i){

        int left=2*i+1;
        int right=2*i+2;
        int max=i;

        if(left<n && arr[max]<arr[left]){
            max=left;
        }
        if(right<n && arr[max]<arr[right]){
            max=right;
        }

        //not satisfied max heap property
        if(max!=i){
            swap(arr,max,i);
            heapify(arr, n, max);
        }
    }
    static void convertToMaxHeap(int[] arr, int n){
        //run loop for nonleave nodes only
        for(int i=(n/2)-1; i>=0; i--){
            heapify(arr,n,i);
        }
    }
    public static int[] MinToMaxHeap(int n, int[] arr){
        
        convertToMaxHeap(arr,n);

        return arr;
    }
}