class Solution {
    public void moveZeroes(int[] nums) {
        int nonZero = 0;
        int n = nums.length;
        int zero = 0;
        while(nonZero < n){
            if(nums[nonZero] != 0){
                int temp = nums[nonZero];
                nums[nonZero] = nums[zero];
                nums[zero] = temp;
                zero++;
            }
            nonZero++;
        }
    }
}