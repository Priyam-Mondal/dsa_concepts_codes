/*You have N books, each with A[i] number of pages. M students need to be allocated contiguous books, 
with each student getting at least one book.
Out of all the permutations, the goal is to find the permutation where the sum of maximum 
number of pages in a book allotted to a student should be minimum, out of all possible permutations.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous 
order (see the explanation for better understanding).

 

Example 1:

Input:
N = 4
A[] = {12,34,67,90}
M = 2
Output:113
Explanation:Allocation can be done in 
following ways:
{12} and {34, 67, 90} Maximum Pages = 191
{12, 34} and {67, 90} Maximum Pages = 157
{12, 34, 67} and {90} Maximum Pages =113.
Therefore, the minimum of these cases is 113,
which is selected as the output.

Example 2:

Input:
N = 3
A[] = {15,17,20}
M = 2
Output:32
Explanation: Allocation is done as
{15,17} and {20} */







class Solution {
    // Function to find minimum number of pages.
    public static int findPages(int[] A, int N, int M) {
        if (M > N) {
            return -1;
        }

        //low would be max page in array
        int low = max(A);
        //high will be sum of all pages
        int high = sum(A);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            //mid acts as maxPage can be assigned
            int studCnt = cntStudents(A, N, M, mid);
            //if can assign more students, then increase maxPage
            if (studCnt > M) {
                low = mid + 1;
            }
            //if can assign less students, decrease maxPage
            else {
                high = mid-1;
            }
        }
        return low;
    }

    static int cntStudents(int[] arr, int n, int students, int maxPage) {
        int pageStud = 0;
        int cnt = 1;
    
        for (int i = 0; i < n; i++) {
            if(pageStud+arr[i] <= maxPage){
                //can assign more pages to current student
                pageStud+=arr[i];
            }else{
                //greater than maxPage
                //assing to new student
                cnt++;
                pageStud=arr[i];
            }
        }
        return cnt;
    }


    static int sum(int[] arr) {
        int s = 0;
        for (int e : arr) {
            s += e;
        }
        return s;
    }
    static int max(int[] arr){
        int maxi=-1;
        for(int e:arr){
            maxi=Math.max(maxi,e);
        }
        return maxi;
    }
}
