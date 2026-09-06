class Solution {
    boolean contains(int[] map1, int[] map2) {
        for (int i = 0; i < 150; i++) {
            if (map1[i] < map2[i]) return false;
        }

        return true;
    }
    public String minWindow(String s, String t) {
        int len = Integer.MAX_VALUE;
        int start = -1, end = -1;
        int j = 0;

        int n = s.length();
        int m = t.length();

        int[] map1 = new int[150];
        for (char ch : t.toCharArray()) {
            map1[ch]++;
        }

        int[] map2 = new int[150];
        for (int i = 0; i < n; i++) {
            map2[s.charAt(i)]++;
            while (j <= i && contains(map2, map1)) {
                if (i - j + 1 < len) {
                    len = i - j + 1;
                    start = j;
                    end = i;
                }
                map2[s.charAt(j)]--;
                j++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, end + 1);
    }
}
