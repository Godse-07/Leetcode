class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long num = 0;
        
        String str = String.valueOf(n);

        for(int i=0; i<str.length(); i++){
            long cur = str.charAt(i) - '0';
            if(cur == 0){
                continue;
            }else{
                num = (num * 10) + cur;
                sum += cur;
            }
        }
        return sum * num;
    }
}