class Solution {
    public int maxSubArray(int[] nums) {
        int cur_max = nums[0];
        int global_max = nums[0];
        for(int i=1;i<nums.length;i++){
            int a = nums[i];
            cur_max = Math.max(a, a+cur_max);
            global_max = Math.max(global_max, cur_max);
        }
        return global_max;
    }
}