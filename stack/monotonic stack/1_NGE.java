/*The next greater element of some element x in an array is the first greater element 
that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that 
nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. 
If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1. */


/***************************************************************************************** */
//  1. traverse from right
//  2. stack store elements in decreasing order

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge=new int[nums1.length];
        Stack<Integer> st=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i], i);
        }

        for(int i=nums2.length-1; i>=0; i--){
            while(st.isEmpty()==false && st.peek()<=nums2[i]){
                st.pop();
            }
            if(map.containsKey(nums2[i])){
                if(st.isEmpty()){
                    nge[map.get(nums2[i])]=-1;
                }else{
                    nge[map.get(nums2[i])]=st.peek();
                }
            }
            st.push(nums2[i]);
        }
        return nge;
    }
}