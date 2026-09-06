class Solution {
    public boolean canFinish(int n, int[][] edges) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) mp.put(i, new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            mp.get(v).add(u);
            indegree[u]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int vis = 0;
        while (q.size() > 0) {
            int node = q.poll();
            vis++;

            for (int v : mp.get(node)) {
                indegree[v]--;
                if (indegree[v] == 0) q.add(v);
            }
        }

        return vis == n;
    }
}
