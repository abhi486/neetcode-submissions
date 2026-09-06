class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int j = 0;
        int[] map = new int[26];
        int maxf = 0;

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'A']++;
            maxf = Math.max(maxf, map[s.charAt(i) - 'A']);

            while (j <= i && i - j - maxf + 1 > k) {
                map[s.charAt(j) - 'A']--;
                maxf = Math.max(maxf, map[s.charAt(j) - 'A']);
                j++;
            }

            ans = Math.max(ans, i - j + 1);
        }

        return ans;
    }
}
