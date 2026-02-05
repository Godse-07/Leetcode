class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int ans[] = new int[nums.length];
        int n = nums.length;
        for(int i=0; i<n; i++) {
            int val = nums[i];
            if(val < 0) {
                val = Math.abs(val);
                int ind = ((i - val) % n + n) % n;
                ans[i] = nums[ind];
            } else if(val == 0) {
                ans[i] = nums[i];
            } else {
                int ind = (val + i) % n;
                ans[i] = nums[ind];
            }
        }
        return ans;
    }
}