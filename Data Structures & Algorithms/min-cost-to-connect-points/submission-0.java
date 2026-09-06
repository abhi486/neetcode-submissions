class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Queue<int[]> q = new PriorityQueue<>((a, b)-> {
            return a[1] - b[1];
        });

        q.add(new int[] {0, 0});
        boolean[] vis = new boolean[n];

        int cost = 0;
        while (q.size() > 0) {
            int[] p = q.poll();
            int u = p[0];
            if (vis[u]) continue;

            cost += p[1];
            vis[u] = true;

            for (int i = 0; i < n; i++) {
                if (!vis[i]) {
                    int wt = Math.abs(points[u][0] - points[i][0]) + Math.abs(points[u][1] - points[i][1]);
                    q.add(new int[] {i, wt});
                }
            }
        }

        return cost;
    }
}
