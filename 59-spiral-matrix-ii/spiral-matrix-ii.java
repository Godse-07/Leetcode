class Solution {
    public int[][] generateMatrix(int n) {
        int arr[][] = new int[n][n];
        int nums = 1;
        int top = 0;
        int left = 0;
        int right = n - 1;
        int bottom = n - 1;
        while(top <= bottom && left <= right){

            for(int i=left; i<=right; i++){
                arr[top][i] = nums;
                nums++;
            }
            top++;

            for(int i=top; i<=bottom; i++){
                arr[i][right] = nums;
                nums++;
            }
            right--;

            if(top <= bottom){
                for(int i=right; i>=left; i--){
                    arr[bottom][i] = nums;
                    nums++;
                }
                bottom--;
            }

            if(left <= right){
                for(int i=bottom; i>=top; i--){
                    arr[i][left] = nums;
                    nums++;
                }
                left++;
            }
        }
        return arr;
    }
}