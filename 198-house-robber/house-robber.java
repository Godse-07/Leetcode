class Solution {
    public int rob(int[] nums) {
        // return recursive(nums, 0, nums.length);
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return dp_sol(nums, dp, 0, n);
    }

    public static int dp_sol(int nums[], int dp[], int index, int n){
        if(index >= n){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int pick = nums[index] + dp_sol(nums, dp, index+2, n);
        int non_pick = dp_sol(nums, dp, index+1, n);
        dp[index] = Math.max(pick, non_pick);
        return dp[index];
    }

    /*
    It will give TLE cause it is recursive
    public static int recursive(int nums[], int index, int n){
        if(index >= n){
            return 0;
        }
        int pick = nums[index] + recursive(nums, index+2, n);
        int non_pick = recursive(nums, index+1, n);
        return Math.max(pick, non_pick);
    }
    */

}