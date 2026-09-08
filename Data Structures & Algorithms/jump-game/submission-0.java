class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            // System.out.println(max + ", " + i);
            if (i < nums.length - 1 && nums[i] == 0 && max == i) return false;
        }

        return true;
    }
}
