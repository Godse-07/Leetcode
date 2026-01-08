class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n){
            int corIndex = nums[i] - 1;
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[corIndex]){
                swap(nums, i, corIndex);
            }else{
                i++;
            }
        }
        for(int j=0; j<nums.length; j++){
            if(nums[j] != j+1){
                return j+1;
            }
        }
        return nums.length + 1;
    }

    public static void swap(int arr[], int i, int j){
        if(i == j){
            return;
        }

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}