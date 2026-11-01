class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min = 300;

        for (String s : strs) {
            min = Math.min(min, s.length());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min; i++) {
            char ch = strs[0].charAt(i);
            // System.out.println(ch);
            boolean isValid = true;
            for (String str : strs) {
                if (ch != str.charAt(i)) {
                    isValid = false;
                    break;
                }
            }

            if (!isValid) break;

            sb.append(ch);
        }

        return sb.toString();
    }
}