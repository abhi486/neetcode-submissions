class Solution {
    public int maxArea(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int ans = 0;
        while (l < r) {
            if (nums[l] <= nums[r]) {
                // System.out.println(ans);
                ans = Math.max(ans, nums[l] * (r - l));
                l++;
            }
            else {
                ans = Math.max(ans, nums[r] * (r - l));
                r--;
            }
        }

        return ans;
    }
}
