class Solution {
    public int minimumOperations(int[] nums) {
        // int ans = 0;
        // for(int num: nums){
        //     if(num % 3 != 0){
        //         int m1 = num % 3;
        //         int m2 = 3 - (num % 3);
        //         ans += Math.min(m1, m2);
        //     }
        // }
        // return ans;
        int ans = 0;
        for(int num: nums){
            if(num % 3 != 0){
                ans++;
            }
        }
        return ans;
    }
}