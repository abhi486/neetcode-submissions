class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int x : stones) {
            q.add(x);
        }

        while (q.size() > 1) {
            int y = q.poll();
            int x = q.poll();

            if (x < y) q.add(y - x);
        }

        return q.size() == 1 ? q.poll() : 0;
    }
}
