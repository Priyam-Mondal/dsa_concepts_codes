class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        int maxCnt=0;
        int index=-1;
        
        for(int i=0; i<n; i++){
            //cnt no of 1s by finding lowerbound of 1 in each row
            int cnt=m-lowerBound(arr[i],m,1);
            if(cnt>maxCnt){
                maxCnt=cnt;
                //update index
                index=i;
            }
        }
        return index;
    }
    static int lowerBound(int[] arr, int n, int k){
        int low=0;
        int high=n-1;
        
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=k){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}