class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (min < nums[i]) {
                ans = Math.max(ans, nums[i] - min);
            }
            min = Math.min(min, nums[i]);
        }

        return ans;
    }
}
