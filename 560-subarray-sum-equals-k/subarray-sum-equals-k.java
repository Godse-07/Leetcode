class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> h1=new HashMap<>();
        int count=0;
        h1.put(0,1);
        int prefix_sum=0;
        for(int i=0;i<nums.length;i++){
            prefix_sum+=nums[i];
            int minus=prefix_sum-k;
            count+=h1.getOrDefault(minus,0);
            h1.put(prefix_sum,h1.getOrDefault(prefix_sum,0)+1);
        }
        return count;
    }
}