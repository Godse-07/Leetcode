class Solution {
    public int smallestRepunitDivByK(int k) {

        /*
            n = 0

            n = (0*10 + 1) % 7 = 1
            n = (1*10 + 1) % 7 = 4
            n = (4*10 + 1) % 7 = 6
            n = (6*10 + 1) % 7 = 5
            n = (5*10 + 1) % 7 = 1
            ...

            We simulate writing more 1s by:

            n = (n * 10 + 1) % k


            and count how many digits we added.

            When n % k == 0 → DONE ✅

         */
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