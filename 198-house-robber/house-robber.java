class Solution {
    public int rob(int[] nums) {
        // return recursive(nums, 0, nums.length);

        // int n = nums.length;
        // int dp[] = new int[n];
        // Arrays.fill(dp, -1);
        // return dp_sol(nums, dp, 0, n);

        return most_optimise(nums);
    }

    public static int most_optimise(int nums[]){
        int n = nums.length;
        int dp[] = new int[n];
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }


    /*
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
    */

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