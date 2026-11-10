class Solution {
    boolean isValid(int[] nums, int days, int wt) {
        int count = 1;
        int sum = 0;
        for (int x : nums) {
            if (sum + x > wt) {
                count++;
                sum = x;
            }
            else {
                sum += x;
            }
        }

        return count <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }

        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (isValid(weights, days, mid)) {
                ans = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return ans;
    }
}