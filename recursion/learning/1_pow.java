class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            // Handling negative exponents
            return 1 / (x * myPow(x, -(n + 1)));
        } else {
            double temp = myPow(x, n / 2);
            temp *= temp;

            // If n is odd, multiply by x one more time
            if (n % 2 != 0) {
                temp *= x;
            }

            return temp;
        }
    }
}
