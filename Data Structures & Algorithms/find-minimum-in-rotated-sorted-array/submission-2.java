class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.min(nums[0], nums[1]);
        if (nums[0] < nums[nums.length - 1]) return nums[0];

        int l = 1;
        int r = nums.length - 2;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            else if (nums[mid] > nums[0]) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        return Math.min(nums[l], nums[r]);
    }
}
