class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int ans1 = -1;
        int ans2 = -1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum > target) {
                right--;
            } else if(sum == target) {
                ans1 = left + 1;
                ans2 = right + 1;
                break;
            } else {
                left++;
            }
        }
        return new int[]{
            ans1, ans2
        };
    }
}