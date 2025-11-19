class Solution {
    public int findFinalValue(int[] nums, int original) {
        boolean find = isExist(nums, original);
        if(find == false){
            return original;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int a: nums){
            arr.add(a);
        }
        int ans = original;
        while(arr.contains(ans)){
            ans = ans << 1;
        }
        return ans;
    }

    public static boolean isExist(int nums[], int a){
        for(int num: nums){
            if(a == num){
                return true;
            }
        }
        return false;
    }

}