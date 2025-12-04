class Solution {
    public int findKthPositive(int[] nums, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int a : nums) {
            arr.add(a);
        }

        int count = 0;
        int ans = 0;

        int i = 1;
        while (true) {
            if (!arr.contains(i)) {
                count++;
                if (count == k) {
                    ans = i;
                    break;
                }
            }
            i++;
        }

        return ans;
    }
}
