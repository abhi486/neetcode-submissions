class Solution {
    int[][] dp;
    int solve(int[] prices, int i, int buy) {
        if (i == prices.length) return 0;

        if (dp[i][buy] != -1) return dp[i][buy];

        int ans = solve(prices, i + 1, buy);

        if (buy == 0) {
            ans = Math.max(ans, solve(prices, i + 1, 1) - prices[i]);
        }
        else {
            ans = Math.max(ans, solve(prices, i + 1, 0) + prices[i]);
        }

        return dp[i][buy] = ans;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];
        for (int[] arr : dp) {
            arr[0] = arr[1] = -1;
        }

        return solve(prices, 0, 0);
    }
}