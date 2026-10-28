class Solution {
    class Node {
        String val;
        double wt;

        Node(String val, double wt) {
            this.val = val;
            this.wt = wt;
        }

        public String toString() {
            return "[" + val + ", " + wt + "]";
        }
    }

    Map<String, List<Node>> mp;

    double bfs(String u, String target) {
        if (!mp.containsKey(target) || !mp.containsKey(u)) return -1.0;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(u, 1.0));

        Set<String> vis = new HashSet<>();
        while (q.size() > 0) {
            Node node = q.poll();
            if (node.val.equals(target)) return node.wt;
            if (vis.contains(node.val)) continue;

            vis.add(node.val);
            for (Node V : mp.get(node.val)) {
                if (!vis.contains(V.val)) {
                    q.add(new Node(V.val, V.wt * node.wt));
                }
            }
        }

        return -1.0;
    }

    public double[] calcEquation(List<List<String>> edges, double[] values, List<List<String>> queries) {
        mp = new HashMap<>();
        int len = values.length;

        for (int i = 0; i < len; i++) {
            String u = edges.get(i).get(0);
            String v = edges.get(i).get(1);

            if (mp.get(u) == null) mp.put(u, new ArrayList<>());
            mp.get(u).add(new Node(v, values[i]));

            if (mp.get(v) == null) mp.put(v, new ArrayList<>());
            mp.get(v).add(new Node(u, 1 / values[i]));
        }

        int n = queries.size();
        double[] ans = new double[n];
        int idx = 0;

        for (List<String> query : queries) {
            String u = query.get(0);
            String target = query.get(1);

            ans[idx++] = bfs(u, target);
        }

        return ans;
    }
}