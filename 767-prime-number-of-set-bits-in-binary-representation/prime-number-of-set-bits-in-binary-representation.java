class Solution {
    public int countPrimeSetBits(int left, int right) {
        int counter = 0;
        while(left <= right) {
            int n = Integer.bitCount(left);
            if(isPrime(n)) {
                counter++;
            }
            left++;
        }
        return counter;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if(n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}