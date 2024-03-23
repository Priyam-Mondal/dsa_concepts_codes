class Solution {
    public int findKthLargest(int[] nums, int k) {

        //create a min heap
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        //step 1: add first k elements
        for(int i=0; i<k; i++){
            pq.offer(nums[i]);
        }

        //step 2: add element from remaining elements
        //          if it is greater than pq head
        for(int i=k; i<nums.length; i++){
            if(nums[i]>pq.peek()){
                pq.remove();
                pq.offer(nums[i]);
            }
        }

        return pq.remove();


    }
}