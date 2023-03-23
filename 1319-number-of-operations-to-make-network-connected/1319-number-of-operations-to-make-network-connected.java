class Solution {
    public int makeConnected(int n, int[][] connections) {
        var uf = new UF(n);

        var pool = 0;
        for (var c: connections) {
            if (!uf.union(c[0], c[1])) // if already connected add connection to pool
                ++pool;
        }

        // check pool has enough connections for all exiting components
        if (uf.count() - pool > 1)
            return -1;

        return uf.count() - 1; // return existing components to union
    }
}

class UF {

    private int N;
    private int[] id;
    private int[] rank;

    UF(int n) {
        this.N = n;
        this.id = new int[n];
        this.rank = new int[n];

        for (int i = 0; i < n; ++i)
            id[i] = i;
    }

    private int find(int p) {

        while(p != id[p])
            p = id[p];

        return p;
    }

    public boolean union(int p, int q) {
        var idP = find(p);
        var idQ = find(q);

        if (idP == idQ)
            return false;

        if (rank[idP] > rank[idQ])
            id[idQ] = idP;
        else if (rank[idP] < rank[idQ])
            id[idP] = idQ;
        else {
            id[idQ] = idP;
            ++rank[idP];
        }

        --N;

        return true;
    }

    public int count() {
        return N;
    }
}