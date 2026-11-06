class Solution {
    boolean solve(String s,int l,int r,boolean isDeleted) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (isDeleted) {
                    return false;
                }
                return solve(s,l+1,r,true) || solve(s,l,r-1,true);
            }
            l++; r--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int n = s.length();
        return solve(s,0,n-1,false);
    }
}