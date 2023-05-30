//{ Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends

class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (word.charAt(0) == board[row][col] && isWordFound(board, word, row, col, visited))
                    return true;
            }
        }
        return false;
    }
    boolean isWordFound(char[][] board, String word, int row, int col, boolean[][] visited) {
        if (word.length() == 0)return true;
        if (row < 0 || col < 0 || row == visited.length || col == visited[0].length || visited[row][col]
                || word.charAt(0) != board[row][col])
            return false;
        visited[row][col] = true;
        word = word.substring(1);
        boolean up = isWordFound(board, word, row, col + 1, visited);
        boolean down = isWordFound(board, word, row, col - 1, visited);
        boolean right = isWordFound(board, word, row + 1, col, visited);
        boolean left = isWordFound(board, word, row - 1, col, visited);
        visited[row][col] = false;
        return (up || down || right || left);
    }
}