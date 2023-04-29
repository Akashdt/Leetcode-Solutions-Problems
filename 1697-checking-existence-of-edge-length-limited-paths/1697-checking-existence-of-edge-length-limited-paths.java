class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        UnionFind uf = new UnionFind(n);
        boolean[] answer = new boolean[queries.length];

        int[][] queriesWithIndex = new int[queries.length][4];

        for (int i = 0; i < queries.length; i++) {
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = queries[i][2];
            queriesWithIndex[i][3] = i;
        }

        // sort edge list
        Arrays.sort(edgeList, (int[] a, int[] b) -> a[2]- b[2]);
        // sort queriesWithIndex
        Arrays.sort(queriesWithIndex, (int[] a, int[] b) -> a[2]- b[2]);

        int edgeIndex = 0;

        for (int i = 0; i < queries.length; i++) {
            int p = queriesWithIndex[i][0];
            int q = queriesWithIndex[i][1];
            int limit = queriesWithIndex[i][2];
            int actualIndex = queriesWithIndex[i][3];

            while (edgeIndex < edgeList.length && edgeList[edgeIndex][2] < limit) {
                int x = edgeList[edgeIndex][0];
                int y = edgeList[edgeIndex][1];

                uf.join(x, y);
                edgeIndex++;
            }

            answer[actualIndex] = uf.isConnected(p, q);
        }

        return answer;
    }
}


class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    public int find (int x) {
        while (parent[x] != x) {
            x = parent[x];
        }

        return parent[x];
    }

    public void join(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;
        else if (rank[px] > rank[py])
            parent[py] = px;
        else if (rank[px] < rank[py])
            parent[px] = py;
        else {
            parent[px] = py;
            rank[py]++;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}