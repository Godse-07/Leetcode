class Solution {
    public long countDistinct(long n) {
        if (n <= 0) return 0;

        String s = Long.toString(n);
        int L = s.length();

        long[] pow9 = new long[L + 1];
        pow9[0] = 1;
        for (int i = 1; i <= L; i++) {
            pow9[i] = pow9[i - 1] * 9;
        }

        long ans = 0;

        for (int k = 1; k < L; k++) {
            ans += pow9[k];
        }

        for (int i = 0; i < L; i++) {
            int digit = s.charAt(i) - '0';

            int smaller = Math.max(0, digit - 1);

            ans += (long) smaller * pow9[L - i - 1];

            if (digit == 0) {
                return ans;
            }
        }

        ans++;

        return ans;
    }
}
