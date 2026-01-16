class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> h1 = new HashSet<>();
        int longest = 0;
        for(int num: nums){
            h1.add(num);
        }

        for(int num: h1){
            if(!h1.contains(num - 1)) {
                int curr = num;
                int count = 1;
                while(h1.contains(curr + 1)) {
                    curr++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}