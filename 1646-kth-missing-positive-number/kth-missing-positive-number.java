class Solution {
    public int findKthPositive(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : nums) {
            set.add(a);
        }

        int count = 0;
        int i = 1;

        while (true) {
            if (!set.contains(i)) {
                count++;
                if (count == k) {
                    return i;
                }
            }
            i++;
        }
    }
}
