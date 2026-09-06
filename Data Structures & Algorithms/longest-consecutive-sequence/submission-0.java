class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        int ans = 0;
        for (int x : nums) {
            if (!set.contains(x)) continue;

            int len = 1;
            int target = x - 1;
            while (set.size() > 0 && set.contains(target)) {
                len++;
                set.remove(target);
                target--;
            } 

            target = x + 1;
            while (set.size() > 0 && set.contains(target)) {
                len++;
                set.remove(target);
                target++;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}
