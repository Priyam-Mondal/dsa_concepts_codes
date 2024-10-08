public class 3_check_kth_bit_set {
    static boolean checkKthBit(int n, int k) {
        int mask=1<<k;
        int t=n&mask;
        
        return t!=0;
        
    }
}
