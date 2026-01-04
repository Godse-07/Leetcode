class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;

        for(int num: nums){
            int divisorCount = 0;
            int divisorSum = 0;
            for(int i=1; i * i <=num; i++){
                if(num % i == 0){
                    int d1 = i;
                    int d2 = num / i;
                    if(d1 == d2){
                        divisorCount += 1;
                        divisorSum += d1;
                    }else{
                        divisorCount += 2;
                        divisorSum += d1 + d2;
                    }
                    if(divisorCount > 4){
                        break;
                    }
                }
            }

            if(divisorCount == 4){
                totalSum += divisorSum;
            }

        }
        return totalSum;
    }
}