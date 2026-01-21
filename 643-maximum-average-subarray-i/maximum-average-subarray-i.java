class Solution {
    public double findMaxAverage(int[] nums, int k) {
        return sliding_window(nums, k);
    }

    static double sliding_window(int arr[], int window){
        double sum = 0;
        for(int i=0; i<window; i++){
            sum += arr[i];
        }
        double maxSum = sum;
        for(int i=window; i<arr.length; i++){
            sum += arr[i] - arr[i - window];
            maxSum = Math.max(maxSum, sum);
        }
        return (double)(maxSum / window);
    }
}