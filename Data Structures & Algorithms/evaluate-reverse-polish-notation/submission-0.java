class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());

                if (str.equals("+")) {
                    a += b;
                }
                else if (str.equals("-")) {
                    a -= b;
                }
                else if (str.equals("*")) {
                    a *= b;
                }
                else {
                    a /= b;
                }

                stack.push(a + "");
            }
            else {
                stack.push(str);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
