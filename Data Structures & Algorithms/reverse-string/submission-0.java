class Solution {
    void swap(char[] s, int i, int j) {
        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
    }

    void reverse(char[] s, int i, int j) {
        while (i < j) {
            swap(s, i++, j--);
        }
    }
    public void reverseString(char[] s) {
        reverse(s, 0, s.length - 1);
    }
}