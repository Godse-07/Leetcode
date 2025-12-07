class Solution {
    public int largestPrime(int n) {
        if (n < 2) return 0;

        int sum = 0;
        int ans = 0;

        for (int i = 2; sum <= n; i++) {
            if (isPrime(i)) {
                sum += i;
                if (sum <= n && isPrime(sum)) {
                    ans = sum;
                }
            }
        }
        return ans;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; (long)i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
