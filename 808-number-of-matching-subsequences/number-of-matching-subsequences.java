/*
 IDEA:
 -----
 We want to count how many words are subsequences of string `s`.

 Instead of checking each word against `s` again and again (which causes TLE),
 we use a "bucket / waiting list" approach.

 - Create 26 buckets (for characters 'a' to 'z')
 - Each bucket stores words waiting for that character
 - Traverse string `s` only ONCE
 - When a character appears, process all words waiting for it
 - Move words to the bucket of their next required character
 - If a word finishes, increase the count
*/


class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        ArrayList<StringBuilder>[] buckets = new ArrayList[26];

        for(int i=0; i<26; i++) {
            buckets[i] = new ArrayList<>();
        }

        /*
         Put each word into the bucket of its FIRST character.
         We use StringBuilder so we can remove characters as they get matched.
        */

        for(String word: words) {
            buckets[word.charAt(0) - 'a'].add(new StringBuilder(word));
        }

        int count = 0;
        /*
         Traverse the main string `s` character by character.
         Each character helps words that are waiting for it.
        */

        for(char c: s.toCharArray()) {
            /*
             Get all words that are waiting for character `c`.
             After taking them out, reset this bucket so new words
             can be added later.
            */

            ArrayList<StringBuilder> waiting = buckets[c - 'a'];
            buckets[c - 'a'] = new ArrayList<>();
            /*
             Process each waiting word:
             - Remove the matched character
             - If the word becomes empty, it is fully matched
             - Otherwise, move it to the bucket of its next character
            */

            for(StringBuilder sb: waiting) {
                // Remove the matched character
                sb.deleteCharAt(0);
                // If all characters are matched, count this word
                if(sb.length() == 0) {
                    count++;
                } 
                // Otherwise, move the word to the next required character bucket
                else {
                    buckets[sb.charAt(0) - 'a'].add(sb);
                }
            }
        }
        return count;
    }
}