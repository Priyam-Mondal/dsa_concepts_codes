//count number of greater element on right
//brute force solution


class Solution {
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
      
          int[] ans = new int[queries];
  
          // For each query, count the number of elements greater than arr[indices[i]]
          for (int i = 0; i < queries; i++) {
              int ind = indices[i];
              int count = 0;
              // Traverse to the right of the current index and count the strictly greater elements
              for (int j = ind + 1; j < N; j++) {
                  if (arr[j] > arr[ind]) {
                      count++;
                  }
              }
              ans[i] = count;
          }
          
          return ans;
       
    }
  }