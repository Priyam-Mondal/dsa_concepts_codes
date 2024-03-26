/*Given a set of N jobs where each jobi has a deadline and profit associated with it.

Each job takes 1 unit of time to complete and only one job can be scheduled at a time. 
We earn the profit associated with job if and only if the job is completed by its deadline.

Find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job. 
Deadline of the job is the time before which job needs to be completed to earn the profit.


Example 1:

Input:
N = 4
Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
Output:
2 60
Explanation:
Job1 and Job3 can be done with
maximum profit of 60 (20+40).
Example 2:

Input:
N = 5
Jobs = {(1,2,100),(2,1,19),(3,2,27),
        (4,1,25),(5,1,15)}
Output:
2 127
Explanation:
2 jobs can be done with
maximum profit of 127 (100+27). */


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {   
        
        //sort according of profit
        Arrays.sort(arr, new Comparator<Job>(){
            public int compare(Job a, Job b){
                return Integer.compare(b.profit, a.profit);
            }
        });
        
        //get job with max deadline
        int maxDead=Integer.MIN_VALUE;
        for(Job e:arr){
            maxDead=Math.max(maxDead, e.deadline);
        }
        
        //scheduling array with size of maxDeadline
        //doing maxDead+1 : using timeline from 1 index
        int[] schedule=new int[maxDead+1];
        Arrays.fill(schedule, -1);
        int jobCnt=0;
        int totalProfit=0;
        
        for(int i=0; i<n; i++){
            int curProfit=arr[i].profit;
            int curId=arr[i].id;
            int curDead=arr[i].deadline;
            
            //putting job as far as close to their deadline
            for(int k=curDead; k>0; k--){
                if(schedule[k]==-1){
                    jobCnt++;
                    totalProfit+=curProfit;
                    schedule[k]=curId;
                    break;
                }
            }
        }
        
        return new int[]{jobCnt, totalProfit};
        
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/