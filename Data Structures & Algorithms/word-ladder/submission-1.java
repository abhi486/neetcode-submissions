class Solution {
    boolean isDifferByOne(String s, String t) {
        if (s.length() != t.length()) return false;

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }

    public class Pair {
        String node;
        int dist;

        Pair(String node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        public String toString() {
            return "[" + node + ", " + dist + "]";
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> mp = new HashMap<>();
        
        for (int i = 0; i < wordList.size(); i++) {
            String u = wordList.get(i);
            mp.putIfAbsent(u, new ArrayList<>());

            for (int j = 0; j < wordList.size(); j++) {
                String v = wordList.get(j);
                if (isDifferByOne(u, v)) {
                    mp.get(u).add(v);
                }
            }
        }

        Queue<Pair> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        for (String word : wordList) {
            if (isDifferByOne(beginWord, word)) {
                q.add(new Pair(word, 1));
            }
        }

        while (q.size() > 0) {
            Pair p = q.poll();
            if (endWord.equals(p.node)) return p.dist + 1;

            if (vis.contains(p.node)) continue;

            vis.add(p.node);

            for (String word : mp.get(p.node)) {
                if (!vis.contains(word)) {
                    q.add(new Pair(word, p.dist + 1));
                }
            }
        }

        return 0;
    }
}
