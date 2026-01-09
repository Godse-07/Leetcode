class Solution {
    public int[] countBits(int n) {
        int arr[] = new int[n + 1];
        for(int i=0; i<=n; i++){
            arr[i] = helper(i);
        }
        return arr;
    }

    public static int helper(int num){
        int count = 0;
        while(num != 0){
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }

}