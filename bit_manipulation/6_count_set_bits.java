public class 6_count_set_bits {
    public int hammingWeight(int n) {
        int cnt = 0; // This will store the count of '1' bits.
        
        // Loop runs until n becomes 0
        while (n > 0) {
            // Use bitwise AND to check if the least significant bit (LSB) is '1'.
            // If n & 1 equals 1, it means the LSB is 1, so we increment the count.
            cnt += n & 1;
            
            // Right shift 'n' by 1 bit to process the next bit on the left.
            // This essentially divides 'n' by 2, discarding the current LSB.
            n = n >> 1;
        }
        
        // Return the total count of '1' bits (Hamming Weight).
        return cnt;
    }
}
