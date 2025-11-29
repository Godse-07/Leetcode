class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for(int a: nums){
            sum += a;
        }
        if(sum % k == 0){
            return 0;
        }
        int left = sum / k;
        return (sum - (left * k));
    }
}