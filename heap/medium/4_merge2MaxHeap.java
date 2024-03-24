class Solution{
    
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
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        //step 1: merge two arrays into one
        int[] ans=new int[n+m];
        
        int i=0,j=0,k=0;
        
        while(i<n)  ans[k++]=a[i++];
        while(j<m)  ans[k++]=b[j++];
        
        
        //step 2: heapify merged array
        int s=ans.length;
        
        for(j=s/2-1; j>=0; j--){
            heapify(ans,s,j);
        }
        
        return ans;
    }
}