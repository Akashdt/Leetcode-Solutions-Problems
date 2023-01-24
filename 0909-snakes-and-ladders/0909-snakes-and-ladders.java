class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        int steps=0;
//Queue to perform BFS 
        Queue<Integer> q=new LinkedList<Integer>();
//visited matrix to mark the visited cell
        boolean visited[][]=new boolean[n][n];
//Below is simple BFS Traversal
        q.add(1);
        visited[n-1][0]=true;
        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                int x=q.poll();
                if(x==n*n) return steps;
                for(int k=1;k<=6;k++){
                    if(k+x>n*n) break;
                    int pos[]=findCoordinates(k+x,n);
                    int r=pos[0];
                    int c=pos[1];
                    if(visited[r][c]==true) continue;
                    visited[r][c]=true;
                    if(board[r][c]==-1){
                        q.add(k+x);
                    }
                    else{
                        q.add(board[r][c]);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    public int[] findCoordinates(int curr,int n){
        int r=n-(curr-1)/n-1;
        int c=(curr-1)%n;
//since we are moving in zig zag so we will have different column for 
//odd and even value of curr
        if(r%2==n%2){
            return new int[]{r,n-1-c};
        }
            else{
                 return new int[]{r,c};
            }
    }
}
