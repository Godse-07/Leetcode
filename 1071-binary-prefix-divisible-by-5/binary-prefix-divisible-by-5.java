class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int n = 0;
        for(int a: nums){
            n = ((n * 2) + a) % 5;
            System.out.print(n +" ");
            ans.add(n == 0);
        }
        return ans;
    }
}