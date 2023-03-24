class Solution {

    int count = 0;

    public int minReorder(int n, int[][] connections) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        Map<Integer,HashSet<Integer>> edges = new HashMap<>();
        boolean[] visited = new boolean[n];

        for(int i=0;i<connections.length;i++){
            graph.putIfAbsent(connections[i][0], new ArrayList<>());
            graph.putIfAbsent(connections[i][1], new ArrayList<>());
            edges.putIfAbsent(connections[i][0], new HashSet<>());
            edges.putIfAbsent(connections[i][1], new HashSet<>());
            edges.get(connections[i][0]).add(connections[i][1]);
            graph.get(connections[i][0]).add(connections[i][1]);
            graph.get(connections[i][1]).add(connections[i][0]);
        }

        dfs(graph, edges, visited, 0);
        return count;
    }

    private void dfs(Map<Integer,List<Integer>> graph,
                     Map<Integer,HashSet<Integer>> edges,
                      boolean[] visited,
                       int i){

         visited[i] = true;
         for(Integer edge: graph.get(i)){
             if(visited[edge]){
                 continue;
             }
             if(!edges.get(edge).contains(i)){
                 count++;
             }
             dfs(graph, edges, visited, edge);
         }                   

     }

    

    
}