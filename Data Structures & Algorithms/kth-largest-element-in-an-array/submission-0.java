class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int x : nums) {
            q.add(x);
            if (q.size() > k) q.poll();
        }

        return q.size() > 0 ? q.peek() : 0;
    }
}
