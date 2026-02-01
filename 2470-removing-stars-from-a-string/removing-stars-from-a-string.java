class Solution {
    public String removeStars(String s) {
        StringBuilder str = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c != '*') {
                st.push(c);
            } else {
                if(st.isEmpty() == false) {
                    st.pop();
                }
            }
        }
        while(!st.isEmpty()) {
            str.append(st.pop());
        }
        return str.reverse().toString();
    }
}