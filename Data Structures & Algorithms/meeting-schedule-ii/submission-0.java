/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int ans = 0;
        int count = 0;
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        for (Interval interval : intervals) {
            start.add(interval.start);
            end.add(interval.end);
        }

        Collections.sort(start);
        Collections.sort(end);

        int s = 0;
        int e = 0;

        while (s < start.size() || e < end.size()) {
            while (s < start.size() && start.get(s) < end.get(e)) {
                count++;
                s++;
            }

            ans = Math.max(ans, count);
            count--;
            e++;
        }

        return ans;
    }
}
