class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] edges, int[][] queries) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        Map<Integer, Set<Integer>> reachable = new HashMap<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            mp.put(i, new ArrayList<>());
            reachable.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            indegree[v]++;

            mp.get(u).add(v);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        while (q.size() > 0) {
            int node = q.poll();
            for (int v : mp.get(node)) {
                reachable.get(v).add(node);
                reachable.get(v).addAll(reachable.get(node));
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        System.out.println(reachable);
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            ans.add(reachable.get(v).contains(u));
        }

        return ans;
    }
}