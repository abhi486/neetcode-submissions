class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> mp = new HashMap<>();
        
        for (int[] edge : flights) {
            int u = edge[0];
            int v = edge[1];
            int price = edge[2];

            mp.putIfAbsent(u, new ArrayList<>());
            mp.putIfAbsent(v, new ArrayList<>());
            
            mp.get(u).add(new int[] {v, price});
        }

        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        q.add(new int[] {src, 0, 0});
        boolean[][] vis = new boolean[n][k + 2];
        while (q.size() > 0) {
            int[] p = q.poll();
            int u = p[0];
            int cost = p[1];
            int stops = p[2];

            if (u == dst) return cost;

            if (vis[u][stops]) continue;
            vis[u][stops] = true;

            if (stops + 1 <= k + 1) {
                for (int[] node : mp.get(u)) {
                    if (!vis[node[0]][stops + 1]) {
                        q.add(new int[] {node[0], cost + node[1], stops + 1});
                    }
                }
            }
        }

        return -1;
    }
}
