class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2]; // [max, min]
        dp[0][0] = 1;
        dp[0][1] = 1;

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];

            if (x == 0) {
                dp[i][0] = 0;
                dp[i][1] = 0;
                ans = Math.max(ans, 0);
                continue;
            }

            int max_prod, min_prod;
            if (x < 0) {
                max_prod = dp[i - 1][1];
                min_prod = dp[i - 1][0];
            } else {
                max_prod = dp[i - 1][0];
                min_prod = dp[i - 1][1];
            }

            max_prod = Math.max(x, max_prod * x);
            min_prod = Math.min(x, min_prod * x);

            dp[i][0] = max_prod;
            dp[i][1] = min_prod;

            ans = Math.max(ans, max_prod);
        }

        return ans;
    }
}
