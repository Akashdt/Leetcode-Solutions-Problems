class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // Initialize union find data structures for Alice, Bob and common edges
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        UnionFind common = new UnionFind(n);
        
        int ans = 0; // Count of removed edges
        
        // Add type 3 edges
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (!alice.union(edge[1] - 1, edge[2] - 1)) {
                    ans++;
                } else if (!bob.union(edge[1] - 1, edge[2] - 1)) {
                    ans++;
                } else {
                    common.union(edge[1] - 1, edge[2] - 1);
                }
            }
        }
        
        // Add type 1 edges
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (!alice.union(edge[1] - 1, edge[2] - 1)) {
                    ans++;
                }
            }
        }
        
        // Add type 2 edges
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (!bob.union(edge[1] - 1, edge[2] - 1)) {
                    ans++;
                }
            }
        }
        
        // Check if Alice and Bob can fully traverse the graph
        if (alice.count != 1 || bob.count != 1) {
            return -1;
        }
        
        // Remove common edges to maximize the number of edges that can be removed
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (common.connected(edge[1] - 1, edge[2] - 1)) {
                    if (alice.union(edge[1] - 1, edge[2] - 1) || bob.union(edge[1] - 1, edge[2] - 1)) {
                        ans++;
                    }
                }
            }
        }
        
        return ans;
    }
}

class UnionFind {
    int[] parent;
    int[] size;
    int count;
    
    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return false;
        }
        if (size[rootX] < size[rootY]) {
            int temp = rootX;
            rootX = rootY;
            rootY = temp;
        }
        parent[rootY] = rootX;
        size[rootX] += size[rootY];
        count--;
        return true;
    }
    
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}