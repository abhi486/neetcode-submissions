class Solution {
    int[] parent;
    
    int find(int u) {
        if (u == parent[u]) return u;
        return parent[u] = find(parent[u]);
    }

    void union(int x, int y) {
        parent[x] = y;
    }

    public boolean validTree(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int x = find(u);
            int y = find(v);

            if (x == y) return false;

            union(x, y);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += parent[i] == i ? 1 : 0;
        }

        return count == 1;
    }
}
