class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] inStack = new boolean[26];
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            freq[idx]--;

            if (inStack[idx]) continue;

            while (!st.isEmpty()
                    && st.peek() > c
                    && freq[st.peek() - 'a'] > 0) {
                inStack[st.pop() - 'a'] = false;
            }

            st.push(c);
            inStack[idx] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : st) sb.append(c);

        return sb.toString();
    }
}
