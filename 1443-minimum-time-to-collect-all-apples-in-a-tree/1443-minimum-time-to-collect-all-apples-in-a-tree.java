class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer,List<Integer>> adj = new HashMap<>();

      
        for(int i =0 ;i<edges.length;i++){
            List<Integer> list = adj.getOrDefault(edges[i][0],new ArrayList<>());
            list.add(edges[i][1]);
            adj.put(edges[i][0],list);

            list = adj.getOrDefault(edges[i][1],new ArrayList<>());
            list.add(edges[i][0]);
            adj.put(edges[i][1],list);

        }

        return DFS(adj,0,-1,hasApple);

    }

    private static int DFS(Map<Integer,List<Integer>> adj, int curr, int parent, List<Boolean> hasApple){
        int time = 0;
        for(int child : adj.getOrDefault(curr,new ArrayList<>())){
            if(child == parent)
                continue;
            int time_from_my_child = DFS(adj,child,curr,hasApple);

            if(time_from_my_child>0 || hasApple.get(child)==true)
                time  += time_from_my_child + 2;
        }
        return time;
    }
}