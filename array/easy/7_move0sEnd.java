public class Solution {
    public static int[] moveZeros(int n, int []a) {
        int firstZeroIndex=-1;

        // finding first index of 0
        for(int i=0; i<n; i++){
            if(a[i]==0){
                firstZeroIndex=i;
                break;
            }
        }
        // no zero elements in array
        if(firstZeroIndex==-1){
            return a;
        }

        // swap a[i] with a[firstZeroIndex] if a[i]!=0
        for(int i=firstZeroIndex+1; i<n; i++){
            if(a[i]!=0){
                int t=a[i];
                a[i]=a[firstZeroIndex];
                a[firstZeroIndex]=t;

                firstZeroIndex++;
            }
        }

        return a;
    }
}