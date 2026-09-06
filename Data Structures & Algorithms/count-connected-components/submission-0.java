class Solution {
    int[] parent;

    int find(int u) {
        if (u == parent[u]) return u;
        return parent[u] = find(parent[u]);
    }

    void union(int u, int v) {
        int x = find(u);
        int y = find(v);
        if (x != y) {
            parent[x] = y;
        }
    }

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            union(u, v);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) count++;
        }

        return count;
    }
}
