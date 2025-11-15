class Solution {
    public boolean isGoodArray(int[] nums) {
        int n = nums.length;
        int gcdCal = nums[0];
        for(int i=1; i<n; i++){
            gcdCal = gcd(gcdCal, nums[i]);
        }
        if(gcdCal == 1){
            return true;
        }
        return false;
    }

    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }

}