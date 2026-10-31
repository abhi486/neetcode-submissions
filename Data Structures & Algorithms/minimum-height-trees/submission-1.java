class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(0);

            return list;
        }
        
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(i, new ArrayList<>());
        }

        int[] degree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            mp.get(u).add(v);
            mp.get(v).add(u);

            degree[u]++;
            degree[v]++;        
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) q.add(i);
        }

        int rem = n;
        while (rem > 2) {
            int leaves = q.size();
            rem -= leaves;

            for (int i = 0; i < leaves; i++) {
                int node = q.poll();

                for (int v : mp.get(node)) {
                    degree[v]--;
                    if (degree[v] == 1) {
                        q.add(v);
                    }
                }
            }
        }

        return new ArrayList<>(q);
    }
}