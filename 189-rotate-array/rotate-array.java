class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        swap(nums, 0, n - 1);
        print(nums);
        swap(nums, 0, k - 1);
        print(nums);
        swap(nums, k, n - 1);
        print(nums);
    }

    public static void swap(int arr[], int l, int r){
        while(l < r){
            arr[l] = arr[l] ^ arr[r];
            arr[r] = arr[l] ^ arr[r];
            arr[l] = arr[l] ^ arr[r];
            l++;
            r--;
        }
    }

    public static void print(int nums[]){
        for(int a: nums){
            System.out.print(a + " ");
        }
        System.out.println();
    }

}