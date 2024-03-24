/*Input:
n = 5
arr[] = {4, 2, 7, 6, 9}
Output: 
62 
Explanation:
First, connect ropes 4 and 2, which makes
the array {6,7,6,9}. Cost of
this operation 4+2 = 6. Next, add ropes 
6 and 6, which results in {12,7,9}. 
Cost of this operation 6+6 = 12.
Then, add 7 and 9, which makes the array {12,16}. 
Cost of this operation 7+9 = 16. And
finally, add these two which gives {28}.
Hence, the total cost is 6 + 12 + 16 + 
28 = 62. */


class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        
        //create a min heap
        PriorityQueue<Long> pq=new PriorityQueue<>();
        
        //step 1: add all elements into queue
        for(int i=0; i<n; i++){
            pq.add(arr[i]);
        }
        
        //step 2: pop two min elements from queue and put their sum back into heap
                //do this until heap contains a single element
        long totalCost=0;
        
        while(pq.size() > 1){
            long a=pq.poll();
            long b=pq.poll();
            long sum=a+b;
            totalCost+=sum;
            
            pq.add(sum);
        }
        
        return totalCost;
    }
}