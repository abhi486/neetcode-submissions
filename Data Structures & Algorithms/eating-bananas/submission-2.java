class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int x : piles) r = Math.max(r, x);

        int ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            int count = 0;
            for (int pile : piles) {
                count += pile / mid;
                count += pile % mid == 0 ? 0 : 1;
            }
            
            if (count <= h) {
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
