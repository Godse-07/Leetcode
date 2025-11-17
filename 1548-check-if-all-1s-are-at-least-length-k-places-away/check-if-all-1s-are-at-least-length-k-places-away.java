class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int idx = -1;
        for(int i=0; i<n; i++){
            if(nums[i] == 1){
                if(idx != -1){
                    int distance = i - idx - 1;
                    if(distance < k){
                        return false;
                    }
                }
                idx = i;
            }
        }
        return true;
    }
}