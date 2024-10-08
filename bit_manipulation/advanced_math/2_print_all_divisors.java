package bit_manipulation.advanced_math;

public class 2_print_all_divisors {
    public static void print_divisors(int n) {
        Set<Integer> ts = new TreeSet<>(); // Create a TreeSet to store divisors in sorted order

        // Loop from 1 to the square root of n
        for (int i = 1; i * i <= n; i++) {
            // Check if i is a divisor of n
            if (n % i == 0) {
                ts.add(i); // Add the divisor i
                if (n / i != i) {
                    ts.add(n / i); // Add the corresponding divisor n/i
                }
            }
        }

        // Iterate over the TreeSet and print the divisors
        for (int divisor : ts) {
            System.out.print(divisor + " ");
        }
    }
}
