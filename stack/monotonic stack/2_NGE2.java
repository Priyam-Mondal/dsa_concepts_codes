//if not found greater element on right then circle back
//from start. 
//  1. so looping double array size and using mod 

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        int[] nge=new int[n];

        for(int i=2*n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek()<=nums[i%n]){
                st.pop();
            }
            nge[i%n]=st.isEmpty()?-1:st.peek();
            st.push(nums[i%n]);
        }
        return nge;
    }
}