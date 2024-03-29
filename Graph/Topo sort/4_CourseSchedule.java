/*There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that 
you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take 
course 0 you should also have finished course 1. So it is impossible.
  */



  import java.util.*;

  class Solution {
      // Function to check if it's possible to finish all courses.
      public boolean canFinish(int numCourses, int[][] prerequisites) {
          // Creating adjacency list to represent the graph.
          ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
  
          // Initializing adjacency list.
          for (int i = 0; i < numCourses; i++) {
              adj.add(new ArrayList<>());
          }
  
          // Populating adjacency list based on prerequisites.
          for (int i = 0; i < prerequisites.length; i++) {
              int sou = prerequisites[i][1]; // Prerequisite course.
              int dest = prerequisites[i][0]; // Course that depends on the prerequisite.
  
              adj.get(sou).add(dest); // Adding edge from prerequisite to dependent course.
          }
  
          // Array to store the indegree of each course.
          int[] inDeg = new int[numCourses];
  
          // Calculating indegrees for each course.
          for (int i = 0; i < prerequisites.length; i++) {
              inDeg[prerequisites[i][0]]++; // Incrementing indegree for the dependent course.
          }
  
          // Queue to store courses with indegree 0.
          Queue<Integer> q = new LinkedList<>();
  
          // Adding courses with indegree 0 to the queue.
          for (int i = 0; i < numCourses; i++) {
              if (inDeg[i] == 0) {
                  q.add(i);
              }
          }
  
          int cnt = 0; // Counter to track the number of courses that can be completed.
  
          // Performing BFS starting from courses with indegree 0.
          while (!q.isEmpty()) {
              int t = q.remove(); // Removing a course from the queue.
              cnt++; // Incrementing the counter.
  
              // Decrementing the indegree of dependent courses and adding them to the queue if their indegree becomes 0.
              for (int it : adj.get(t)) {
                  inDeg[it]--;
                  if (inDeg[it] == 0) {
                      q.add(it);
                  }
              }
          }
  
          // If the count of completed courses is equal to the total number of courses, return true, else return false.
          return (cnt == numCourses);
      }
  }
  