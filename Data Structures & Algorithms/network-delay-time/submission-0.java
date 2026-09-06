class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> mp = new HashMap<>();

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];

            mp.putIfAbsent(u, new ArrayList<>());
            mp.putIfAbsent(v, new ArrayList<>());

            mp.get(u).add(new int[] {v, time});
        } 

        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        q.add(new int[] {k, 0});
        boolean[] vis = new boolean[n + 1];
        int ans = 0;
        while (q.size() > 0) {
            int[] current = q.poll();
            int u = current[0];
            int time = current[1];
            if (vis[u]) continue;

            vis[u] = true;
            // System.out.println(u + ", " + time);

            ans = Math.max(ans, time);
            for (int[] node : mp.get(u)) {
                if (!vis[node[0]]) {
                    q.add(new int[] {node[0], node[1] + time});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) return -1;
        }

        return ans;
    }
}
