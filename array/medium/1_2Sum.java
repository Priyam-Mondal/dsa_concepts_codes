class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> m = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int rem = target-nums[i];
            if(m.containsKey(rem)){
                return new int[]{m.get(rem),i};
            }
            m.put(nums[i],i);
        }

        return new int[0];
    }
}