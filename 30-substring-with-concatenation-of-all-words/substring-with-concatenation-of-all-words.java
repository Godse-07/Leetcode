class Solution {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        if (words.length == 0 || s.length() == 0)
            return ans;

        int wordSize = words[0].length();
        int wordCount = words.length;
        int k = wordSize * wordCount;   // total window size
        int N = s.length();

        // Store required frequency of each word
        HashMap<String, Integer> required = new HashMap<>();
        for (String word : words) {
            required.put(word, required.getOrDefault(word, 0) + 1);
        }

        // Try every possible offset (important)
        for (int offset = 0; offset < wordSize; offset++) {

            int i = offset;   // window start
            int j = offset;   // window end
            int count = 0;

            HashMap<String, Integer> seen = new HashMap<>();

            // Traditional sliding window
            while (j + wordSize <= N) {

                // 1️⃣ Add current word
                String currWord = s.substring(j, j + wordSize);

                if (required.containsKey(currWord)) {

                    seen.put(currWord,
                            seen.getOrDefault(currWord, 0) + 1);
                    count++;

                    // If frequency exceeds → shrink window
                    while (seen.get(currWord) > required.get(currWord)) {

                        String leftWord =
                                s.substring(i, i + wordSize);

                        seen.put(leftWord,
                                seen.get(leftWord) - 1);

                        count--;
                        i += wordSize;
                    }

                } else {
                    // Invalid word → reset window
                    seen.clear();
                    count = 0;
                    i = j + wordSize;
                }

                // 2️⃣ Expand window
                if (j - i + wordSize < k) {
                    j += wordSize;
                }

                // 3️⃣ Window size == k
                else if (j - i + wordSize == k) {

                    if (count == wordCount) {
                        ans.add(i);
                    }

                    // Remove leftmost word
                    String leftWord =
                            s.substring(i, i + wordSize);

                    seen.put(leftWord,
                            seen.get(leftWord) - 1);

                    count--;
                    i += wordSize;
                    j += wordSize;
                }
            }
        }

        return ans;
    }
}
