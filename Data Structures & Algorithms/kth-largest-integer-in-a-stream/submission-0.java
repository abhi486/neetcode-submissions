class KthLargest {
    Queue<Integer> q;
    int K;
    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>();
        this.K = k;
        for (int x : nums) {
            add(x);
        }
    }
    
    public int add(int val) {
        q.add(val);
        if (q.size() > K) {
            q.poll();
        }

        return q.peek();
    }
}
