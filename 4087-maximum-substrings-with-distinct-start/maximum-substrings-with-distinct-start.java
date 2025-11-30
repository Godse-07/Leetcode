class Solution {
    public int maxDistinct(String s) {
        HashSet<Character> h1 = new HashSet<>();
        for(char a: s.toCharArray()){
            h1.add(a);
        }
        return h1.size();
    }
}