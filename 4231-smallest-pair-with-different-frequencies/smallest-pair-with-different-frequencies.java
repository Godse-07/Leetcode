class Solution {
    public int[] minDistinctFreqPair(int[] nums) {

        if(nums.length < 2) {
            return new int[]{-1, -1};
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a: nums) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j] == nums[j-1]) continue;
                int x = nums[i];
                int y = nums[j];
                if(map.get(x) != map.get(y)) {
                    return new int[]{
                        x, y
                    };
                }
            }
        }
        return new int[]{-1, -1};
    }
}