class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n;) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    
                    ans.add(temp);

                    int x1 = nums[l];
                    int x2 = nums[r];

                    while (l < r && nums[l] == x1) l++;
                    while (l < r && nums[r] == x2) r--;
                }
                else if (sum < 0) {
                    l++;
                }
                else {
                    r--;
                }
            }

            int x = nums[i];
            while (i < n && nums[i] == x) i++;
        }

        return ans;
    }
}
