/*You have been given a binary matrix 'MAT' containing only 0’s and 1’s of size N x M. 
You need to find the distance of the nearest cell having 1 in the matrix for each cell.

The distance is calculated as |i1 – i2| + |j1 – j2|, where i1, j1 are the coordinates 
of the current cell and i2, j2 are the coordinates of the nearest cell having value 1.
Note :
You can only move in four directions which are : Up, Down, Left and Right.
For example :
If N = 3, M = 4

and mat[ ][ ] = { 0, 0, 0, 1,
                  0, 0, 1, 1,
                  0, 1, 1, 0 }

then the output matrix will be

3  2  1  0
2  1  0  0
1  0  0  1 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Tuple {
    int row, col, steps;
    Tuple(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

public class Solution {
    public static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        Queue<Tuple> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> dist = new ArrayList<>();
        ArrayList<ArrayList<Integer>> vis = new ArrayList<>();

        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};

        // Initialize dist and vis ArrayLists with all zeros
        for (int i = 0; i < n; i++) {
            dist.add(new ArrayList<>());
            vis.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                dist.get(i).add(-1); // Initialize distances to -1
                vis.get(i).add(mat.get(i).get(j)); // Initialize vis with mat
                if (mat.get(i).get(j) == 1) {
                    //add to queue and Set distance to 0 for cells with value 1
                    q.add(new Tuple(i, j, 0));
                    dist.get(i).set(j, 0);
                }
            }
        }

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            int row = t.row;
            int col = t.col;
            int steps = t.steps;

            for (int i = 0; i < 4; i++) {
                int nRow = row + delrow[i];
                int nCol = col + delcol[i];

                //if possible, valid range
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m 
                    && vis.get(nRow).get(nCol) == 0) {
                    q.add(new Tuple(nRow, nCol, steps + 1));
                    vis.get(nRow).set(nCol, 1); // Mark cell as visited
                    dist.get(nRow).set(nCol, steps + 1); // Update distance
                }
            }
        }

        return dist;
    }
}
