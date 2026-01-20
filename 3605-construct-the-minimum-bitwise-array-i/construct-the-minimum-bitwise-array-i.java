class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int ans[] = new int[nums.size()];
        Arrays.fill(ans, -1);

        int j = 0;

        for (int a : nums) {
            for (int i = 0; i < a; i++) {
                if ((i | (i + 1)) == a) {
                    ans[j] = i;
                    break;
                }
            }
            j++;
        }

        return ans;
    }
}