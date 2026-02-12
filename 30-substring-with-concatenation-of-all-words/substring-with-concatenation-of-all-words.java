class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || words.length == 0)
            return ans;
        int wordSize = words[0].length();
        int wordCount = words.length;
        int k = wordSize * wordCount;
        int N = s.length();
        HashMap<String, Integer> required = new HashMap<>();
        for (String w : words) {
            required.put(w, required.getOrDefault(w, 0) + 1);
        }
        for (int offset = 0; offset < wordSize; offset++) {
            int i = offset;
            int j = offset;
            int count = 0;
            HashMap<String, Integer> seen = new HashMap<>();
            while (j + wordSize <= N) {
                String curr = s.substring(j, j + wordSize);
                if (required.containsKey(curr)) {
                    seen.put(curr, seen.getOrDefault(curr, 0) + 1);
                    count++;
                } else {
                    seen.clear();
                    count = 0;
                    i = j + wordSize;
                }
                if (j - i + wordSize < k) {
                    j += wordSize;
                }
                else if (j - i + wordSize == k) {
                    if (count == wordCount && seen.equals(required)) {
                        ans.add(i);
                    }
                    String leftWord = s.substring(i, i + wordSize);
                    seen.put(leftWord, seen.get(leftWord) - 1);
                    if (seen.get(leftWord) == 0) {
                        seen.remove(leftWord);
                    }
                    count--;
                    i += wordSize;
                    j += wordSize;
                }
            }
        }
        return ans;
    }
}