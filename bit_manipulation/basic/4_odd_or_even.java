//just check the LSB 1 or not.
//if 1 then odd otherwise even

public class 4_odd_or_even {
    static String oddEven(int n) {
        int t=n&1;
        if(t != 0)    return "odd";
        else            return "even";
    }
}
