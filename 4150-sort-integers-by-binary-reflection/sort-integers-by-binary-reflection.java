class Solution {
    public int[] sortByReflection(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = reflect(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = arr[i][0];
        }
        return res;
    }

    private int reflect(int x) {
        String bin = Integer.toBinaryString(x);
        String rev = new StringBuilder(bin).reverse().toString();
        return Integer.parseInt(rev, 2);
    }
}
