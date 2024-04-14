class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int N=mat.length;
        int M=mat[0].length;

        int low=0;
        int high=N*M-1;
        
        while(low<=high){
            //mid is 1D coordinate of flattened 2D matrix
            int mid=(low+high)/2;
            
            //converting 1D coordinate into 2D coordinate
            //row=index/M
            int row=mid/M;
            //col=index%M
            int col=mid%M;
            
            if(mat[row][col] == target){
                return true;
            }else if(mat[row][col] < target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
}