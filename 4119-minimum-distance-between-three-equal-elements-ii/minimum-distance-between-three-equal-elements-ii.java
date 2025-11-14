class Solution {
    public int minimumDistance(int[] nums) {
       int n = nums.length;
        
        if(n == 1){
            return -1;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = nums[i];
            if (!map.containsKey(value)) {
                map.put(value, new ArrayList<>());
            }
            map.get(value).add(i);
        }

        int minDistance = Integer.MAX_VALUE;

        for (int key : map.keySet()) {
            List<Integer> indexes = map.get(key);

            if (indexes.size() < 3) continue;

            for (int i = 0; i <= indexes.size() - 3; i++) {
                int first = indexes.get(i);
                int third = indexes.get(i + 2);
                int distance = 2 * (third - first);
                minDistance = Math.min(minDistance, distance);
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}