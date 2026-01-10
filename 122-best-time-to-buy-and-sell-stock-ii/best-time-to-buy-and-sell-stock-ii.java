class Solution {
    public int maxProfit(int[] nums) {
        int maxProfit = 0;
        // int minPrice = Integer.MAX_VALUE;
        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[i - 1]){
                maxProfit += Math.abs(nums[i] - nums[i - 1]);
            }
        }
        return maxProfit;
    }
}