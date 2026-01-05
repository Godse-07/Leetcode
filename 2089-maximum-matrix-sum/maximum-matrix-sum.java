class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int count = 0;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        for(int nums[]: matrix){
            for(int a: nums){
                if(a < 0){
                    count++;
                    a = -a;
                }
                sum += a;
                min = Math.min(min, a);
            }
        }
        if((count & 1) == 0){
            return sum;
        }
        System.out.println(sum + " " + min);
        return sum - 2L * min;
    }
}