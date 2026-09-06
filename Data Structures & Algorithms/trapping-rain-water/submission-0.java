class Solution {
    public int trap(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i - 1], nums[i]);
        }

        int[] suff = new int[n];
        suff[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = Math.max(suff[i + 1], nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(nums[i] - Math.min(pre[i], suff[i]));
        }

        return ans;
    }
}
