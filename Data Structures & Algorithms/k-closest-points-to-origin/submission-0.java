class Solution {

    int getDist(int[] p1, int[] p2) {
        int x2 = Math.abs(p1[0] - p2[0]) * Math.abs(p1[0] - p2[0]);
        int y2 = Math.abs(p1[1] - p2[1]) * Math.abs(p1[1] - p2[1]);

        return x2 + y2;
    }
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            int dist1 = getDist(a, new int[] {0, 0});
            int dist2 = getDist(b, new int[] {0, 0});
            return dist2 - dist1;
        });

        for (int[] p : points) {
            q.add(p);
            if (q.size() > k) q.poll();
        }

        int[][] ans = new int[q.size()][2];
        int idx = 0;
        while (q.size() > 0) {
            ans[idx++] = q.poll();
        }

        return ans;
    }
}
