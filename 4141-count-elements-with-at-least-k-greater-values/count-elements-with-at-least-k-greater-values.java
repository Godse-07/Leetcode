class Solution {
    public int countElements(int[] nums, int k) {
        int n = nums.length;
        if(k == 0){
            return n;
        }
        Arrays.sort(nums);
        int index = n - k;
        int val = nums[index];
        int count = 0;
        for(int a: nums){
            if(a < val){
                count++;
            }
        }
        return count;
    }
}