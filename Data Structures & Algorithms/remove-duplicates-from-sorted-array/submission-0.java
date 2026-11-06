class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        int n = nums.length;
        for (int i = 0; i < n;) {
            int x = nums[i];
            nums[j++] = x;
            while (i < n && nums[i] == x) i++;
        }

        return j;
    }
}