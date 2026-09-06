class Solution {
    public String foreignDictionary(String[] words) {
        if (words.length == 1) return words[0];
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int[] indegree = new int[26];
        boolean[] map = new boolean[26];

        for (int i = 1; i < words.length; i++) {
            String s = words[i - 1];
            String t = words[i];

            if (s.length() > t.length() && s.startsWith(t)) return "";

            for (int j = 0; j < Math.min(s.length(), t.length()); j++) {
                if (s.charAt(j) != t.charAt(j)) {
                    mp.putIfAbsent(s.charAt(j) - 'a', new ArrayList<>());
                    mp.get(s.charAt(j) - 'a').add(t.charAt(j) - 'a');
                    indegree[t.charAt(j) - 'a']++;
                    break;
                }
            }

            for (char ch : s.toCharArray()) {
                map[ch - 'a'] = true;
            }

            for (char ch : t.toCharArray()) {
                map[ch - 'a'] = true;
            }
        }

        StringBuilder ans = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        int all = 0;
        for (int i = 0; i < 26; i++) {
            if (map[i] && indegree[i] == 0) {
                q.add(i);        
            }

            if (map[i]) all++;
        }

        while (q.size() > 0) {
            int curr = q.poll();
            ans.append((char) ('a' + curr));

            if (mp.get(curr) == null) continue;

            for (int v : mp.get(curr)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        return ans.length() == all ? ans.toString() : "";
    }
}
