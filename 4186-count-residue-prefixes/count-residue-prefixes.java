class Solution {
    public int residuePrefixes(String s) {
        HashSet<Character> h1 = new HashSet<>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            h1.add(s.charAt(i));
            if(h1.size() == (i + 1) % 3) {
                count++;
            }
        }
        return count;
    }
}