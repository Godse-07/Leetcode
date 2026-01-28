class Solution {

    static final long MOD = 1000000007;

    public int countAnagrams(String s) {
        long ans = 1;

        int[] freq = new int[26];
        int len = 0;

        for (int i = 0; i <= s.length(); i++) {

            if (i == s.length() || s.charAt(i) == ' ') {

                long ways = factorial(len);

                for (int f : freq) {
                    if (f > 1) {
                        ways = (ways * modInverse(factorial(f))) % MOD;
                    }
                }

                ans = (ans * ways) % MOD;

                freq = new int[26];
                len = 0;

            } else {
                freq[s.charAt(i) - 'a']++;
                len++;
            }
        }

        return (int) ans;
    }

    private long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res = (res * i) % MOD;
        }
        return res;
    }

    private long modInverse(long a) {
        return power(a, MOD - 2);
    }

    private long power(long a, long b) {
        long res = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}
