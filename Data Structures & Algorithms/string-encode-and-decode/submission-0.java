class Solution {

    public String encode(List<String> strs) {
        StringBuilder st = new StringBuilder();
        // st.append('\n');
        for (String s : strs) {
            st.append(s).append('\n');
        }

        // System.out.println(st);
        return st.toString();
    }

    public List<String> decode(String str) {
        StringBuilder st = new StringBuilder();
        List<String> ans = new ArrayList<>();

        for (char ch : str.toCharArray()) {
            if (ch == '\n') {
                ans.add(st.toString());
                st = new StringBuilder();
            }
            else {
                st.append(ch);
            }
        }
        return ans;
    }
}
