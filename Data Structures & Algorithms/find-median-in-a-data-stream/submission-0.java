class MedianFinder {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int size;

    public MedianFinder() {
        q1 = new PriorityQueue<>(Collections.reverseOrder());
        q2 = new PriorityQueue<>();
        size = 0;    
    }
    
    public void addNum(int num) {
        if (size == 0) {
            q1.add(num);
            size++;
            return;
        }

        q1.add(num);
        size++;

        while (q1.size() > 0 && q2.size() > 0 && q1.peek() > q2.peek()) {
            q2.add(q1.poll());
        }

        if (q1.size() > q2.size()) {
            if (q1.size() - q2.size() > 1) {
                while (q1.size() - q2.size() > 1) {
                    q2.add(q1.poll());
                }
            }
        }
        else if (q2.size() > q1.size()) {
            if (q2.size() - q1.size() > 1) {
                while (q2.size() - q1.size() > 1) {
                    q1.add(q2.poll());
                }
            }
        }
    }
    
    public double findMedian() {
        // System.out.println("Q1: " + q1);
        // System.out.println("Q2: " + q2);
        // System.out.println();

        if ((size & 1) == 1) {
            return q1.size() > q2.size() ? q1.peek() : q2.peek();
        }
        else {
            // if (q1.size() > 0) {
            //     System.out.println(q1.peek());
            // }
            // if (q2.size() > 0) {
            //     System.out.println(q2.peek());
            // }
            double sum = (q1.size() > 0 ? q1.peek() : 0) + (q2.size() > 0 ? q2.peek() : 0);
            return sum / 2;
        }
    }
}
