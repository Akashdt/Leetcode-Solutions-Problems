class Solution {
  int ans=-1;
  public int longestCycle(int[] edges) {
      int n=edges.length;
      int[] dist_node=new int[n];
      boolean[] visited=new boolean[n];
      boolean[] extra=new boolean[n];
      for(int i=0; i<n; i++){
        if(!visited[i]){
          dfs(edges, i, 0, dist_node, visited, extra);
        }
      }
      return ans;
  }
  void dfs(int[] edges, int node, int distance, int[] dist_node, boolean[] visited, boolean[] extra){
    if(node!=-1){
      if(!visited[node]){
        visited[node]=true;
        extra[node]=true;
        dist_node[node]=distance;
        dfs(edges, edges[node], distance+1, dist_node, visited, extra);
      } else if(extra[node]){
        ans=Math.max(ans, distance-dist_node[node]);
      }
      extra[node]=false;
    }
  }
}