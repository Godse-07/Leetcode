class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        int n = nums.length;
        int i = 0, j = 0;
        long sum = 0, maxSum = 0;

        boolean[] visited = new boolean[100001];

        while (j < n) {

            if (visited[nums[j]]) {
                while (visited[nums[j]]) {
                    visited[nums[i]] = false;
                    sum -= nums[i];
                    i++;
                }
            }

            visited[nums[j]] = true;
            sum += nums[j];

            if (j - i + 1 < k) {
                j++;
            }
            else if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);

                visited[nums[i]] = false;
                sum -= nums[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }
}
