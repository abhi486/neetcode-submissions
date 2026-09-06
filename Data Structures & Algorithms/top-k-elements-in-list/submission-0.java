class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int x : nums) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }

        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        for (int key : mp.keySet()) {
            q.add(new int[] {key, mp.get(key)});
            if (q.size() > k) q.poll();
        }

        int[] ans = new int[q.size()];
        int idx = 0;
        while (q.size() > 0) {
            ans[idx++] = q.poll()[0];
        }

        return ans;
    }
}
