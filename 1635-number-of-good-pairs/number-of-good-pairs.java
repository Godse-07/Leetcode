class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> h1 = new HashMap<>();

        for(int num: nums){
            h1.put(num, h1.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for(Map.Entry<Integer, Integer> entry: h1.entrySet()){
            if(entry.getValue() >= 2) {
                int n = entry.getValue();
                count += (n * (n - 1) /2);
            }
        }
        return count;
    }
}