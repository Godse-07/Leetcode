class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> h1 = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            if(!h1.containsKey(num)) {
                h1.put(num, i);
            }else {
                int currVal = h1.get(num);
                int curr = i;
                int cal = Math.abs(currVal - curr);
                if(cal <= k) {
                    return true;
                }
                h1.put(num, i);
            }
        }
        return false;
    }
}