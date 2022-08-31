class Pair{
    int row;
    int col;
    public Pair(int i, int j){
        row=i;
        col=j;
    }
}
class Solution {
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int m=heights.length;
        int n=heights[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(bfs(heights, i, j, m, n)){
                    ArrayList<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                    temp=new ArrayList<>();
                }     
            }
        }
        return list;
    }
    public boolean bfs(int[][] grid, int i, int j, int m, int n){
        int[][] vis=new int[m][n];
        vis[i][j]=1;
        boolean p=false;
        boolean a=false;
        
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        while(!q.isEmpty()){
            int r= q.peek().row;
            int c= q.peek().col;
            int val=grid[r][c];
            q.remove();
            
            if(r==0 || c==0)
                p=true;
            if(r==m-1 || c==n-1)
                a=true;
            if(r!=0 && grid[r-1][c]<=val && vis[r-1][c]==0){
                q.add(new Pair(r-1,c));
                vis[r-1][c]=1;
            }
            if(r!=m-1 && grid[r+1][c]<=val && vis[r+1][c]==0){
                q.add(new Pair(r+1,c));
                vis[r+1][c]=1;
            }
            if(c!=0 && grid[r][c-1]<=val && vis[r][c-1]==0){
                q.add(new Pair(r,c-1));
                vis[r][c-1]=1;
            }
            if(c!=n-1 && grid[r][c+1]<=val && vis[r][c+1]==0){
                q.add(new Pair(r,c+1));
                vis[r][c+1]=1;
            }
    
        }
        if(p && a)
            return true;
        return false;
        
    }
}