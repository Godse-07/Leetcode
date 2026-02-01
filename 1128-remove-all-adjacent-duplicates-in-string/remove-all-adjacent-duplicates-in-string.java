class Solution {
    public String removeDuplicates(String s) {
        StringBuilder str = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()) {
            if(st.isEmpty()) {
                st.push(c);
            } else {
                char top = st.peek();
                if(top == c) {
                    st.pop();
                } else{
                    st.push(c);
                }
            }
        }
        while(!st.isEmpty()) {
            str.append(st.pop());
        }
        return str.reverse().toString();
    }
}