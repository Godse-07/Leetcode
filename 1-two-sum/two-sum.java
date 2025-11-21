class Solution {
    public int[] twoSum(int[] nums, int target) {
        int num1 = -1;
        int num2 = -1;
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                int a = nums[i];
                int b = nums[j];
                if(a + b == target){
                    num1 = i;
                    num2 = j;
                    return new int[]{num1, num2};
                }
            }
        }
        return new int[]{num1, num2};
    }
}