class Solution {
    int[][] dp;

    int solve(String s, int i, String t, int j) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int ans = solve(s, i + 1, t, j);
        if (s.charAt(i) == t.charAt(j)) {
            ans += solve(s, i + 1, t, j + 1);
        }
        
        return dp[i][j] = ans;
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        dp = new int[n][m];

        for (int[] arr : dp) Arrays.fill(arr, -1);

        return solve(s, 0, t, 0);
    }
}
