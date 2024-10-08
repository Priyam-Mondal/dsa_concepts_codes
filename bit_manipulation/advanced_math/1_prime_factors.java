package bit_manipulation.advanced_math;

public class 1_prime_factors {
    // Function to find all unique prime factors of a given number N
    public int[] AllPrimeFactors(int N) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Loop from 2 to sqrt(N) to find prime factors
        // If i divides N, then i is a prime factor
        for (int i = 2; i <= Math.sqrt(N); i++) {
            // Check if i divides N
            if (N % i == 0) {
                ans.add(i);  // Add i to the list of prime factors
                
                // Divide N by i repeatedly to remove all occurrences of the prime factor
                while (N % i == 0) {
                    N /= i;
                }
            }
        }

        // If N is greater than 1 after the loop, it means N itself is a prime number
        // So, add it to the list of prime factors
        if (N != 1) {
            ans.add(N);
        }

        // Convert the ArrayList to an int[] array
        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);  
        }

        return arr;
    }
}
