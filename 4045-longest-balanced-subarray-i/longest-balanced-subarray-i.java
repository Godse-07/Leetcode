class Solution {
    public int longestBalanced(int[] nums) {
        int maxLen = 0;
        for(int i=0; i<nums.length; i++) {
            Set<Integer> h1 = new HashSet<>();
            Set<Integer> h2 = new HashSet<>();
            for(int j=i; j<nums.length; j++) {
                int curr = nums[j];
                if((curr & 1) == 0) {
                    h1.add(curr);
                } else {
                    h2.add(curr);
                }
                if(h1.size() == h2.size()) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}