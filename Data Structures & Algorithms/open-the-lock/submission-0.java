class Solution {

    String getString(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            sb.append(ch);
        }
        return sb.toString();
    }
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for (String deadend : deadends) {
            set.add(deadend);
        }

        Queue<String> q = new LinkedList<>();
        Map<String, Integer> mp = new HashMap<>();
        q.add("0000");
        mp.put("0000", 0);

        while (q.size() > 0) {
            String curr = q.poll();
            if (set.contains(curr)) continue;

            if (curr.equals(target)) return mp.getOrDefault(curr, -1);
            set.add(curr);

            int wt = mp.getOrDefault(curr, 0);
            for (int i = 0; i < 4; i++) {
                char[] arr = curr.toCharArray();

                // clockwise
                char ch = arr[i];
                int d = arr[i] - '0';
                d = (d + 1) % 10;
                arr[i] = (char) (d + '0');
                String s = getString(arr);
                if (!set.contains(s)) {
                    q.add(s);
                    mp.put(s, wt + 1);
                }
                arr[i] = ch;

                // anti-clockwise
                d = arr[i] - '0';
                d = (d - 1 + 10) % 10;
                arr[i] = (char) (d + '0');
                s = getString(arr);
                if (!set.contains(s))
                if (!set.contains(s)) {
                    q.add(s);
                    mp.put(s, wt + 1);
                }
                arr[i] = ch;
            }
        }

        return -1;
    }
}