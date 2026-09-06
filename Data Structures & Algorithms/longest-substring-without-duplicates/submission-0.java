class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int ans = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map[ch]++;

            while (j <= i && map[ch] > 1) {
                map[s.charAt(j)]--;
                j++;
            }

            ans = Math.max(ans, i - j + 1);
        }
        
        return ans;
    }
}
