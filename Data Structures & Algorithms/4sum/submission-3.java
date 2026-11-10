class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        // skip the same numbers now;
                        int x = nums[k];
                        int y = nums[l];

                        while (k < l && nums[k] == x) k++;
                        while (k < l && nums[l] == y) l--;
                    }
                    else if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
                        k++;
                    }
                    else {
                        l--;
                    }
                }
            }

        }

        return ans;
    }
}