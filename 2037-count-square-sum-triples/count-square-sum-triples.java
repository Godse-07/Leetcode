class Solution {
    public int countTriples(int n) {
        int counter = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                int sum = i*i + j*j;
                int val = (int)Math.sqrt(sum);

                if(val * val == sum && val <= n){
                    counter++;
                }
            }
        }
        return counter;
    }
}
