class Solution {
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // System.out.println(i + ", " + nums[i]);
            if (nums[i] >= 1 && nums[i] <= n && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                i--;
            }
            // System.out.println(i + ", " + nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (i + 1 != nums[i]) return i + 1;
        }

        return n + 1;
    }
}