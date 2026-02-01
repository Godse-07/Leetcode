 /*
     * Problem: Remove Duplicate Letters
     *
     * Goal:
     * 1. Each character should appear exactly once.
     * 2. The resulting string must be the smallest possible in lexicographical order.
     * 3. The relative order of characters must be preserved (subsequence).
     *
     * Approach (Greedy + Stack):
     * - We use a stack to build the result while maintaining order.
     * - If a smaller character appears and the previous larger character
     *   can appear again later, we remove the larger one to get a smaller result.
     *
     * Data Structures Used:
     * - freq[26]: Tracks remaining occurrences of each character.
     * - inStack[26]: Marks whether a character is already used in the stack.
     * - Stack<Character>: Helps undo previous choices when a better option appears.
     *
     * Key Idea:
     * - While the stack top is lexicographically larger than the current character
     *   and it appears again later, pop it from the stack.
     */


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
