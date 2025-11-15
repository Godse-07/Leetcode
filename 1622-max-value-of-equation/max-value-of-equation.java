class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int ans = Integer.MIN_VALUE;
        int left = 0;
        int right = 1;

        while (left < points.length) {
            if (right < left + 1) right = left + 1;
            for (int j = right; j <= points.length - 1; j++) {
                if (points[j][0] > (points[left][0] + k))
                    break;

                int sum = points[left][1] + points[j][1] + points[j][0] - points[left][0];
                if (sum > ans) {
                    ans = Math.max(ans, sum);
                    right = j - 1;
                }
            }
            left++;
        }
        return ans;
    }
}