/*A ninja needs to complete ‘n’ tasks. 
Each task is represented by an uppercase letter of the English alphabet. 
Different letters are assigned to different tasks. A ninja can complete tasks in any order.
 He takes one unit of time to complete one task. 
 For each unit of time, he could complete either one task or just be idle.

Ninja easily gets bored by doing the same task again.
 So he decided to keep at least ‘t’ units of time between any two same tasks.

You are given a string ‘tasks’ consisting of ‘n’ uppercase letters of the English alphabet, 
representing the tasks ninja need to complete, 
and an integer ‘t’ representing the least units of time between any two same tasks. 
Find out the minimum total units of time ninja will take to complete all ‘n’ tasks. 

-----------------------------------------------------------------
this algorithm prioritizes tasks based on their frequencies, allowing more frequent tasks to be scheduled first. 
The cooldown period k ensures that tasks are spaced out appropriately to meet the requirements. 


*/



import java.util.* ;
import java.io.*; 
// Comparator for priority queue tasks priority
class Compare implements Comparator<ArrayList<Integer>> {

        public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {

                int n = a.size();

                for (int i = 0; i < n; i++) {
                        // task with higher frequency is maintained at top of priority queue
                        if (a.get(i) < b.get(i)) {
                                return 1;
                        }
                        else if (a.get(i) > b.get(i)){
                                return -1;
                        }
                }

                return 0;
        }
};

class Solution {

        public static int taskScheduler(String s, int n, int k) {

                // create a frequency array of size 26 initialised with 0
                int[] freq = new int[26];
                Arrays.fill(freq, 0);

                for (int i = 0; i < n; i++) {
                        freq[s.charAt(i) - 'A']++;
                }

                //initialise priority queue which keeps most frequent tasks at top
                PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(new Compare());

                int leastTime = 0;

                // Adding all task with their frequency in priority_queue.
                for (int i = 0; i < 26; i++) {
                        if (freq[i] != 0) {
                                ArrayList<Integer> temp = new ArrayList<>();
                                temp.add(freq[i]);
                                temp.add(i);
                                pq.add(temp);
                        }
                }

                while (!pq.isEmpty()) {

                        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();

                        // get k most frequent tasks to assign
                        for (int i = 0; i <= k; i++) {

                                if (pq.isEmpty()) {
                                        // cpu need to become idle.
                                        break;
                                }

                                // Decrease frequency of task by 1 and add it in vector 'temp'.
                                ArrayList<Integer> tempTask = pq.poll();
                                tempTask.set(0, tempTask.get(0) - 1);
                                temp.add(tempTask);
                        }

                        // Adding remaining task in priority_queue.
                        for (int i = 0; i < temp.size(); i++) {
                                if (temp.get(i).get(0) != 0) {
                                        pq.add(temp.get(i));
                                }
                        }

                        // Update 'leastTime'.
                        if (pq.isEmpty()) {
                                leastTime += temp.size();
                        } else {
                                leastTime += k + 1;
                        }
                }

                return leastTime;
        }
}