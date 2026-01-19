class Solution {
    public int numMatchingSubseq(String s, String[] words) {

        ArrayList<StringBuilder>[] buckets = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (String word : words) {
            buckets[word.charAt(0) - 'a'].add(new StringBuilder(word));
        }

        int count = 0;

        for (char c : s.toCharArray()) {
            ArrayList<StringBuilder> waiting = buckets[c - 'a'];
            buckets[c - 'a'] = new ArrayList<>();

            for (StringBuilder sb : waiting) {
                sb.deleteCharAt(0);
                if (sb.length() == 0) {
                    count++;
                } else {
                    buckets[sb.charAt(0) - 'a'].add(sb);
                }
            }
        }

        return count;
    }
}
