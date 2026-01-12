class Solution {

    private int matchCount(String a, String b) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (a.charAt(i) == b.charAt(i))
                count++;
        }
        return count;
    }

    public void findSecretWord(String[] words, Master master) {
        List<String> list = new ArrayList<>(Arrays.asList(words));

        for (int attempt = 0; attempt <= 30; attempt++) {

            String guess = pickBestMinimax(list);


            int matches = master.guess(guess);
            if (matches == 6) return;

            List<String> next = new ArrayList<>();
            for (String w : list) {
                if (matchCount(guess, w) == matches)
                    next.add(w);
            }

            list = next;
        }
    }

    private String pickBestMinimax(List<String> words) {
        int bestScore = Integer.MAX_VALUE;
        String bestWord = words.get(0);

        for (String w1 : words) {

            int[] buckets = new int[7];

            for (String w2 : words) {
                if (!w1.equals(w2)) {
                    int m = matchCount(w1, w2);
                    buckets[m]++;
                }
            }

            int worst = 0;
            for (int b : buckets)
                worst = Math.max(worst, b);

            if (worst < bestScore) {
                bestScore = worst;
                bestWord = w1;
            }
        }

        return bestWord;
    }
}


/*
    Guess the Secret Word — Logic Explanation (Beginner Friendly)

    We are given a list of unique 6-letter words.
    One of them is the secret word. We must find it using Master.guess(),
    which tells us how many characters match the secret word in the
    exact SAME positions.

    Example:
    secret  = "a c c k z z"
    guess   = "a b c c z z"
               ↑   ↑   ↑ ↑ → 4 matching positions

    master.guess("abcczz") returns 4.

    ------------------------------------------------------------
    MAIN IDEA (Elimination Strategy)
    ------------------------------------------------------------
    1. Pick a word from the list and guess it.
    2. Master returns a number (0–6) telling how many positions match.
    3. Using this number, we eliminate all words that CANNOT be the secret.
       • If guess had 3 matches, the secret must also match this guess in 3 positions.
       • So remove all words that don't have exactly 3 matching positions
         with the guessed word.
    4. Now we have a smaller list of possible secret words.
    5. Repeat:
         - guess another word
         - filter the list again
    6. Eventually only ONE word fits all clues → that must be the secret.
       Guess it → done.

    ------------------------------------------------------------
    Why do we do: words = newList.toArray(new String[0]) ?
    ------------------------------------------------------------
    After filtering, we have a new, smaller list of possible words.
    We convert the ArrayList back to a String array so we can continue
    using it in the next loop.

*/