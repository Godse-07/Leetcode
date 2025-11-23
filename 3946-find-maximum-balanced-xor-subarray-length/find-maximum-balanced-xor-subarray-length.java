class Solution {
    public int maxBalancedSubarray(int[] nums) {
        Map<String, Integer> h1 = new HashMap<>();
        int prefixXor = 0;
        int balance = 0;
        int maxLen = 0;
        h1.put("0#0", -1);
        for(int i=0; i<nums.length; i++){
            prefixXor ^= nums[i];

            if(nums[i] % 2 ==0){
                balance++;
            }else{
                balance--;
            }

            String key = prefixXor + "#" + balance;
            if(h1.containsKey(key)){
                maxLen = Math.max(maxLen, i - h1.get(key));
            }else{
                h1.put(key, i);
            }
        }
        return maxLen;
    }
}