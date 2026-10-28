class Solution {
    Map<String, List<String>> mp;

    void dfs(String node, Set<String> vis, List<String> list) {
        list.add(node);
        vis.add(node);

        if (mp.containsKey(node)) {
            for (String V : mp.get(node)) {
                if (vis.contains(V)) continue;
                dfs(V, vis, list);
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        mp = new HashMap<>();
        Set<String> emails = new HashSet<>();

        for (List<String> entry : accounts) {
            String name = entry.get(0);
            for (int i = 1; i < entry.size(); i++) {
                String email = entry.get(i);
                emailToName.putIfAbsent(email, name);

                if (i + 1 < entry.size()) {
                    String nextEmail = entry.get(i + 1);
                    if (mp.get(email) == null) {
                        mp.put(email, new ArrayList<>());
                    }
                    mp.get(email).add(nextEmail);

                    if (mp.get(nextEmail) == null) {
                        mp.put(nextEmail, new ArrayList<>());
                    }
                    mp.get(nextEmail).add(email);
                }

                emails.add(email);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        Set<String> vis = new HashSet<>();
        for (String email : emails) {
            if (vis.contains(email)) continue;

            List<String> connected = new ArrayList<>();
            dfs(email, vis, connected);

            Collections.sort(connected, Collections.reverseOrder());
            connected.add(emailToName.get(connected.get(0)));
            Collections.reverse(connected);

            ans.add(connected);
        }

        return ans;
    }
}