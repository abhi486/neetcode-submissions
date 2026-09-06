class Solution {
    int[] parent;

    int find(int u) {
        if (u == parent[u]) return u;
        return parent[u] = find(parent[u]);
    }

    void union(int x, int y) {
        parent[x] = y;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = 0;
        for (int[] edge : edges) {
            n = Math.max(n, edge[0]);
            n = Math.max(n, edge[1]);
        }

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int x = find(u);
            int y = find(v);

            if (x == y) return edge;

            union(x, y);
        }

        return new int[] {};
    }
}
