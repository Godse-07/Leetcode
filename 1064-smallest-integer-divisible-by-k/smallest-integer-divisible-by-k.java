class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k == 1){
            return 1;
        }

        if(k % 2 == 0 || k % 5 == 0){
            return -1;
        }

        int rem = 0;
        int length = 0;
        while(true){
            rem = (rem * 10 + 1) % k;
            length++;

            if(rem == 0){
                return length;
            }
        }
    }
}