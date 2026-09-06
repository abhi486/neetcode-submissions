class Solution {
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        int[] nsl = new int[n];
        int[] nsr = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            nsr[i] = n;
            while (stack.size() > 0 && nums[stack.peek()] > nums[i]) {
                nsr[stack.pop()] = i;
            }
            stack.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            nsl[i] = -1;
            while (stack.size() > 0 && nums[stack.peek()] > nums[i]) {
                nsl[stack.pop()] = i;
            }
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int curr = nums[i] * (nsr[i] - nsl[i] - 1);
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}
