//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution

{

    public int closedIslands(int[][] grid, int N, int M)

    {

        

        for(int i=0;i<N;i++)

        {

            find(i,0,grid);

            find(i,M-1,grid);

        }

        

        for(int i=0;i<M;i++)

        {

            find(0,i,grid);

            find(N-1,i,grid);

        }

        

        

        

        

        int visited[][]=new int[N][M];

        int cnt=0;

        for(int i=0;i<N;i++)

        {

            for(int j=0;j<M;j++)

            {

                if(grid[i][j]==1)

                {

                    find(i,j,grid);

                cnt++;

                }

            }

        }

        return cnt;

    }

    public static void find(int i,int j,int grid[][])

    {

        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0)

        {

            return;

        }

        

        grid[i][j]=0;

        find(i+1,j,grid);

        find(i-1,j,grid);

        find(i,j+1,grid);

        find(i,j-1,grid);

    }

}