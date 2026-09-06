class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l <= r) {
            char ch1 = s.charAt(l);
            char ch2 = s.charAt(r);
            if (!Character.isLetterOrDigit(ch1)) {
                l++;
            }
            else if (!Character.isLetterOrDigit(ch2)) {
                r--;
            }
            else {
                if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) return false;
                
                l++;
                r--;
            }
        }

        return true;
    }
}
