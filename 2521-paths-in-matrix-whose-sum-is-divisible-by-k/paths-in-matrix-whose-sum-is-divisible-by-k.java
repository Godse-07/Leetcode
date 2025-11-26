class Solution {

    Integer[][][] memo;
    static final int MOD = 1_000_000_007;

    public int numberOfPaths(int[][] arr, int k) {
        int n = arr.length;
        int m = arr[0].length;
        memo = new Integer[n][m][k];
        return helper(arr,n-1,m-1,0,k);
    }

    public int helper(int[][] arr, int n, int m, int sum, int k){

        int mod = (sum + arr[n][m]) % k;

        if(n == 0 && m == 0){
            return (mod == 0) ? 1 : 0;
        }

        if(memo[n][m][mod] != null)
            return memo[n][m][mod];

        long count = 0;

        if(n > 0)
            count = (count + helper(arr,n-1,m,mod,k)) % MOD;

        if(m > 0)
            count = (count + helper(arr,n,m-1,mod,k)) % MOD;

        memo[n][m][mod] = (int)count;
        return memo[n][m][mod];
    }
}
