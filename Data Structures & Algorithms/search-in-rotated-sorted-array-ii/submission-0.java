class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int n = nums.length;

        while (l <= r) {
            while (l <= r && l + 1 < n && nums[l] == nums[l + 1]) l++;
            while (r >= l && r - 1 >= 0 && nums[r] == nums[r - 1]) r--;

            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return true;
            }
            else if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
        }

        return false;
    }
}