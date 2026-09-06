class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            int size1 = a[1] - a[0] + 1;
            int size2 = b[1] - b[0] + 1;
            return size1 - size2;
        });

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            list.add(new int[] {queries[i], i});
        }

        Collections.sort(list, (a, b) -> {
            return a[0] - b[0];
        });

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int i = 0;
        int[] ans = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            int query = list.get(j)[0];
            int idx = list.get(j)[1];
            
            while (i < intervals.length && intervals[i][0] <= query) {
                q.add(intervals[i]);
                i++;
            }

            while (q.size() > 0 && q.peek()[1] < query) {
                q.poll();
            }

            if (q.size() == 0) {
                ans[idx] = -1;
            }
            else {
                // System.out.println(query + ", " + q.peek()[0] + ", " + q.peek()[1]);
                ans[idx] = q.peek()[1] - q.peek()[0] + 1;
            }
        }

        return ans;
    }
}
