class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        boolean added = false;

        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }

        if (i < n) {
            if (newInterval[1] < intervals[i][0]) {
                added = true;
                list.add(newInterval);
            }
            else {
                int start = Math.min(newInterval[0], intervals[i][0]);
                int end = Math.max(newInterval[1], intervals[i][1]);

                while (i < n && end >= intervals[i][0]) {
                    end = Math.max(end, intervals[i][1]);
                    i++;
                }

                list.add(new int[] {start, end});
                added = true;
            }
        }

        while (i < n) {
            list.add(intervals[i++]);
        }

        if (!added) {
            list.add(newInterval);
        }

        int[][] ans = new int[list.size()][2];
        for (i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
