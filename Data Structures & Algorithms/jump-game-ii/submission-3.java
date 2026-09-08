class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int ans = 0;
        int max = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr = Math.max(curr, i + nums[i]);

            if (i == max) {
                ans++;
                max = curr;
            }

            if (max >= n - 1) break;
        }

        return ans;
    }
}
