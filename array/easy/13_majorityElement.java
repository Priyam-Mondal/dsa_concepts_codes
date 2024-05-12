class Solution {
    public int majorityElement(int[] nums) {
        // Initialize the count of the current majority element candidate
        int cnt = 1;
        // Initialize the current majority element candidate with the first element of the array
        int posElement = nums[0];
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is the same as the current majority element candidate, increment the count
            if (nums[i] == posElement) {
                cnt++;
            } 
            // If the current element is different from the current majority element candidate, decrement the count
            else if (nums[i] != posElement) {
                cnt--;
                // If the count reaches 0, update the current majority element candidate to the current element and reset the count to 1
                if (cnt <= 0) {
                    posElement = nums[i];
                    cnt = 1;
                }
            }
        }

        cnt=0;
        for(int i=0; i<a.length;i++){
            if(posEle==a[i]){
                cnt++;
            }
        }
        if(cnt>size/2){
            return posEle;
        }
        return -1;
    }
}
