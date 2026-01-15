class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> h1 = new HashMap<>();
        for(char c: magazine.toCharArray()) {
            h1.put(c, h1.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        while(i < ransomNote.length()) {
            char c1 = ransomNote.charAt(i);
            if(!h1.containsKey(c1)) {
                return false;
            } else if(h1.get(c1) == 0) {
                return false;
            } else {
                h1.put(c1, h1.getOrDefault(c1, 0) - 1);
            }
            i++;
        }
        return true;
    }
}