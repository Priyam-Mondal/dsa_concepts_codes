
import java.util.*;

public class Fibbo {
    static int nthFibonacci(int n){
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        
        dp[n]=f(n,dp);

        System.out.println(dp[0]+" "+dp[1]);
        
        return dp[n];
    }
    static int f(int n, int[] dp){
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        
        // mod to handle overflow for large number
        dp[n]=(f(n-1,dp)%(int)(1e9+7)+f(n-2,dp)%(int)(1e9+7))%(int)(1e9+7);
        
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(nthFibonacci(145));
    }
}
