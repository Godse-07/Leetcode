class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        String ans = "";
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans = s.substring(i, i+1);
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {

                    if (len == 2 || dp[i+1][j-1]) {
                        dp[i][j] = true;

                        if (len > ans.length()) {
                            ans = s.substring(i, j + 1);
                        }
                    }
                }
            }
        }

        return ans;
    }
}
