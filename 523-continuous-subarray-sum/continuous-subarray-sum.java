class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> h1 = new HashMap<>();
        int sum = 0;
        h1.put(0, -1);
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            
            if(h1.containsKey(rem)) {
                if(i - h1.get(rem) > 1) {
                    return true;
                }
            }
            else {
                h1.put(rem, i);
            }
        }
        return false;
    }
}