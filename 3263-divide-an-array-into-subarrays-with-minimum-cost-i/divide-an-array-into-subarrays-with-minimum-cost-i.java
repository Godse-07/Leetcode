class Solution {
    public int minimumCost(int[] nums) {
        int min = nums[0];
        int second_min = Integer.MAX_VALUE;
        int third_min = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < second_min) {
                third_min = second_min;
                second_min = nums[i];
            } else if (nums[i] < third_min) {
                third_min = nums[i];
            }
        }

        return min + second_min + third_min;
    }
}
