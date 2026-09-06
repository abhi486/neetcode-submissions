class MinStack {

    Stack<Integer> st, min;
    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if (min.size() == 0 || min.peek() >= val) min.push(val);
    }
    
    public void pop() {
        int val = st.pop();
        if (min.size() > 0 && min.peek() == val) min.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();        
    }
}
