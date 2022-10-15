//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

         int row = grid.length;

        int col = grid[0].length;

        ArrayList<int[]> arrlist = new ArrayList<>(row * col);

        

        int step = 0;

        boolean[][] visited = new boolean[row][col];

        for(int i=0; i<row; i++){

            for(int j=0; j<col; j++){

                if(grid[i][j] == 0){

                    visited[i][j] = true;

                }

            }

        }

        

        arrlist.add(source);

        while(arrlist.size() > 0){

            int size = arrlist.size();

            for(int k = 0; k<size; k++){

                int[] curr = arrlist.get(0);

                int currow = curr[0];

                int currcolumn = curr[1];

                arrlist.remove(0);

                if(currow == destination[0] && currcolumn == destination[1]){

                    return step;

                }

                if(currow-1>=0 && !visited[currow-1][currcolumn]){

                    arrlist.add(new int[]{currow-1, currcolumn});

                    visited[currow-1][currcolumn] = true;

                }

                

                if(currow+1 < row && !visited[currow+1][currcolumn]){

                    arrlist.add(new int[]{currow+1, currcolumn});

                    visited[currow+1][currcolumn] = true;

                }

                

                if(currcolumn-1 >= 0 && !visited[currow][currcolumn-1]){

                    arrlist.add(new int[]{currow, currcolumn-1});

                    visited[currow][currcolumn-1] = true;

                }

                

                if(currcolumn+1 < col && !visited[currow][currcolumn+1]){

                    arrlist.add(new int[]{currow, currcolumn+1});

                    visited[currow][currcolumn+1] = true;

                }

            }

            step++;

        }

        return -1;
    }
}
