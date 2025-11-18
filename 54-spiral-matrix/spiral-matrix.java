class Solution {
    public List<Integer> spiralOrder(int[][] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return arr;
        }
        int top = 0;
        int right = nums[0].length - 1;
        int left = 0;
        int bottom = nums.length - 1;

        while(top <= bottom && left <= right){

            for(int i=left; i<= right; i++){
                arr.add(nums[top][i]);
            }
            top++;

            for(int i=top; i<=bottom; i++){
                arr.add(nums[i][right]);
            }
            right--;

            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    arr.add(nums[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    arr.add(nums[i][left]);
                }
                left++;
            }
        }
        return arr;
    }
}