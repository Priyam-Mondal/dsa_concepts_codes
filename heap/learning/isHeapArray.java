class Solution {
    
    public boolean countSub(long arr[], long n)
    {   
        
        
        // Traverse through all internal nodes (non-leaves)
        for (int i = 0; i <= (n - 2) / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // Check if the left child index is within bounds and if the parent is less than the left child
            if (left < n && arr[i] < arr[left]) {
                return false;
            }
            // Check if the right child index is within bounds and if the parent is less than the right child
            if (right < n && arr[i] < arr[right]) {
                return false;
            }
        }
        return true;
    }
}