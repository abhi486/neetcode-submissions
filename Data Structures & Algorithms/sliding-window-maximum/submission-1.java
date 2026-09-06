class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        int n = nums.length;
        if (n - k + 1 <= 0) return new int[] {};

        int[] ans = new int[n - k + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            if (i < k - 1) continue;

            if (i - k >= 0) {
                mp.replace(nums[i - k], mp.get(nums[i - k]) - 1);
                if (mp.get(nums[i - k]) == 0) mp.remove(nums[i - k]);
            }

            // System.out.println(mp);
            ans[idx++] = mp.lastKey();
        }

        return ans;
    }
}
