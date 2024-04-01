public class Solution {

    static int sLargest(int n, int[] a){
        int fMax=a[0];
        int sMax=-1;

        for(int i=0; i<n; i++){
            if(a[i]>fMax){
                sMax=fMax;
                fMax=a[i];
            }else if(a[i]<fMax && a[i]>sMax){
                sMax=a[i];
            }
        }
        return sMax;
    }
    static int sSmallest(int n, int[] a){
        int fMin=a[0];
        int sMin=Integer.MAX_VALUE;

        for(int i=1; i<n; i++){
            if(a[i]<fMin){
                sMin=fMin;
                fMin=a[i];
            }else if(a[i]>fMin && a[i]<sMin){
                sMin=a[i];
            }
        }
        return sMin;
    }
    public static int[] getSecondOrderElements(int n, int []a) {
        int sMax=sLargest(n, a);
        int sMin=sSmallest(n, a);
        
        return new int[]{sMax,sMin};
        
    }
}