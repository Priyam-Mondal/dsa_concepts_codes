/*Problem Statement: An image is represented by a 2-D array of integers, 
each integer representing the pixel value of the image. 
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, 
and a pixel value newColor, “flood fill” the image.

To perform a “flood fill”, consider the starting pixel, 
plus any pixels connected 4-directionally to the starting pixel of
 the same colour as the starting pixel, plus any pixels connected 
 4-directionally to those pixels (also with the same colour as the starting pixel), 
 and so on. Replace the colour of all of the aforementioned pixels with the newColor. 
 


For Example:
For  'N' = 5 , 'M' = 4 , 'X' = 2 , 'Y' = 2 and 'P' = 5
Given 'IMAGE' is shown below:

[7, 1, 1, 1]
[1, 7, 7, 7]
[7, 7, 7, 0]
[7, 7, 7, 4]
[4, 4, 4, 4]

After the flood fill operation, we will replace all neighbour's 7s with 5.

So our 'IMAGE' will become:

[7, 1, 1, 1]
[1, 5, 5, 5]
[5, 5, 5, 0]
[5, 5, 5, 4]
[4, 4, 4, 4]

*/


public class Solution {

    // DFS method to fill connected component with color 'p'
    static void dfs(int x, int y, int[][] image, int iniColor, int p, int[] dRow, int[] dCol){

        // Mark the current pixel with the new color 'p'
        image[x][y]=p;
        int n=image.length;
        int m=image[0].length;

        // Check neighboring pixels
        for(int i=0; i<4; i++){
            int nRow=x+dRow[i];
            int nCol=y+dCol[i];

            // Check if the neighboring pixel is within the bounds and has the initial color
            if(nRow>=0 && nCol>=0 && nRow<n && nCol<m &&
                image[nRow][nCol]==iniColor)
            {
                // Recursively fill the connected component with color 'p'
                dfs(nRow,nCol,image,iniColor,p,dRow,dCol);
            }
        }
    }

    // Flood fill method
    public static int[][] floodFill(int[][] image, int n, int m, int x, int y, int p) {
        
        // Get the initial color of the pixel
        int iniColor=image[x][y];

        // Define directions for neighboring pixels (up, down, left, right)
        int[] dRow={0,0,1,-1};
        int[] dCol={1,-1,0,0};

        // Call DFS to fill the connected component with the new color 'p'
        dfs(x,y,image,iniColor,p,dRow,dCol);

        // Return the updated image
        return image;
    }
}


/*Time Complexity: O(NxM + NxMx4) ~ O(N x M)

For the worst case, all of the pixels will have the same colour, 
so DFS function will be called for (N x M) nodes and for every node we are traversing 
for 4 neighbours, so it will take O(N x M x 4) time.

Space Complexity: O(N x M) + O(N x M)

O(N x M) for copied input array and recursive stack space takes up N x M locations at max.  */