class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new int[] {position[i], speed[i]});
        }

        Collections.sort(list, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return b[0] - a[0];
        });

        int ans = 0;
        double lastTime = 0;

        for (int i = 0; i < n; i++) {
            int pos = list.get(i)[0];
            int sp = list.get(i)[1];

            double time = (double) (target - pos) / sp;

            if (time > lastTime) {
                ans++;
                lastTime = time;
            }
        }

        return ans;
    }
}
