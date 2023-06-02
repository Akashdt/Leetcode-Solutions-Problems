class Solution {
    private boolean inBlastRange(int x,int y,int radius,int[] a){
        double dist = Math.sqrt(Math.pow(x - a[0],2) + Math.pow(y - a[1],2));
        //System.out.println(dist);
        return radius >= dist;
    }
    private int solve(int[][] bombs){
        Queue<int[]> queue = new LinkedList<>();
        int n = bombs.length;
        boolean[] visited = new boolean[n];
        int res = 0;
        for(int i = 0;i < n;i++){
            visited = new boolean[n];
            queue.offer(bombs[i]);
            int ans = 1;
            visited[i] = true;
            while(!queue.isEmpty()){
                int[] top = queue.poll();
                // calculate blast range
                int x = top[0];
                int y = top[1];
                for(int j = 0;j < n;j++){
                    if(!visited[j] && inBlastRange(x,y,top[2],bombs[j])){
                        visited[j] = true;
                         queue.offer(bombs[j]);
                         ans++;
                    }
                }
            }
            
            res = Math.max(ans,res);
        }

        return res;
    }
    public int maximumDetonation(int[][] bombs) {
        return solve(bombs);
    }
}