class Solution {
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);

        int n = nums.length;
        int count = 0;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (val == nums[i]) {
                idx = i;
                while (i < n && val == nums[i++]) count++; 
                
                break;
            }
        }
        
        int ans = n - count;
        int end = n - 1;
        while (count-- > 0) {
            swap(nums, idx, end);
            idx++;
            end--;
        }

        System.out.println(n + ", " + count);
        return ans;
    }
}