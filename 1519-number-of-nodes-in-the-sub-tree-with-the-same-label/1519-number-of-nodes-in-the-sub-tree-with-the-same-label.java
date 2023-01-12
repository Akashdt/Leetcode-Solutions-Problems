class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ArrayList<Integer>[] adjList = getAdjList(n, edges);

        int[] result = new int[n];
        int[] freq = new int[26];
        boolean[] visited = new boolean[n];
        exploreTree(0, adjList, labels, freq, result, visited);
        return result;
    }

    public void exploreTree(int node, ArrayList<Integer>[] adjList, String labels, int[] freq, int[] result, boolean[] visited) {
        if (visited[node]) return;

        visited[node] = true;
        int currentCharIdx = labels.charAt(node) - 'a';
        int temp = freq[currentCharIdx];

        freq[currentCharIdx] = 1;
        for (Integer nb: adjList[node]) {
            exploreTree(nb, adjList, labels, freq, result, visited);
        }

        result[node] = freq[currentCharIdx];
        freq[currentCharIdx] += temp;
    }


    public ArrayList<Integer>[] getAdjList(int n, int[][] edges) {
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<Integer>();

        for (int[] edge: edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        return adjList;
    }
}
