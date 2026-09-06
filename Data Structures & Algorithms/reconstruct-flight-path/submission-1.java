class Solution {
    Map<String, TreeMap<String, Integer>> mp;
    void dfs(String node, List<String> list) {

        TreeMap<String, Integer> childs = mp.get(node);

        if (childs != null) {
            List<String> keys = new ArrayList<>(childs.keySet());
            for (String key : keys) {
                while (childs.containsKey(key) && childs.get(key) > 0) {
                    childs.replace(key, childs.get(key) - 1);
                    if (childs.get(key) == 0) childs.remove(key);
                    dfs(key, list);
                }
            }

        }
        list.add(0, node);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        mp = new HashMap<>();
        for (List<String> list : tickets) {
            String u = list.get(0);
            String v = list.get(1);

            mp.putIfAbsent(u, new TreeMap<>());

            TreeMap<String, Integer> childs = mp.get(u);
            childs.put(v, childs.getOrDefault(v, 0) + 1);
        }
        List<String> ans = new LinkedList<>();
        dfs("JFK", ans);

        return ans;
    }
}
