class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            StringBuilder key = new StringBuilder();

            for (char ch : arr) key.append(ch);
            
            mp.putIfAbsent(key.toString(), new ArrayList<>());
            mp.get(key.toString()).add(s);
        }

        return new ArrayList<>(mp.values());
    }
}
