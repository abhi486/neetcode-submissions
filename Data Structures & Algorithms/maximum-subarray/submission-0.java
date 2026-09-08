class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for (int x : nums) {
            sum += x;
            if (ans < sum) {
                ans = sum;
            }

            if (sum < 0) {
                sum = 0;
            } 
        }

        return ans;
    }
}
