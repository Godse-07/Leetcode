class Solution {
    public String reorganizeString(String s) {
    int n = s.length();
    int[] freq = new int[26];

    for (char c : s.toCharArray()) {
        freq[c - 'a']++;
    }

    int max = 0, maxChar = 0;
    for (int i = 0; i < 26; i++) {
        if (freq[i] > max) {
            max = freq[i];
            maxChar = i;
        }
    }


    if (max > (n + 1) / 2) return "";

    char[] result = new char[n];
    int idx = 0;


    while (freq[maxChar]-- > 0) {
        result[idx] = (char)(maxChar + 'a');
        idx += 2;
    }

    for (int i = 0; i < 26; i++) {
        while (freq[i]-- > 0) {
            if (idx >= n) idx = 1;
                result[idx] = (char)(i + 'a');
                idx += 2;
            }
        }

        return new String(result);
    }

}
