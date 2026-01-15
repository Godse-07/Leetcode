class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> st = new HashMap<>();
        HashMap<Character, Character> ts = new HashMap<>();
        int n = s.length();
        int m = t.length();
        if(n != m) {
            return false;
        }
        int i = 0;
        while(i < n) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(st.containsKey(c1)) {
                if(st.get(c1) != c2) return false;
            } else {
                st.put(c1, c2);
            }

            if(ts.containsKey(c2)) {
                if(ts.get(c2) != c1) return false;
            } else {
                ts.put(c2, c1);
            }
            i++;
        }
        return true;
    }
}