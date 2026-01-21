class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> h1 = new HashMap<>();
        int sum = 0;
        h1.put(0, 1);
        int count = 0;
        for(int num: nums) {
            sum += num;
            int rem = sum % k;
            if(rem < 0) {
                rem = k + rem;
            }

            if(h1.containsKey(rem)) {
                count += h1.get(rem);
            }

            h1.put(rem, h1.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}