class Solution {
    public boolean completePrime(int num) {
        if(num <= 1){
            return false;
        }
        String s = Integer.toString(num);
        int n = s.length();

        for(int i=1; i<=n; i++){
            int prefix = Integer.parseInt(s.substring(0,i));
            if(!isPrime(prefix)){
                return false;
            }
            int suffix = Integer.parseInt(s.substring(n-i));
            if(!isPrime(suffix)){
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(int x){
        if(x <= 1){
            return false;
        }
        if(x == 2){
            return true;
        }
        if(x % 2 == 0){
            return false;
        }
        for(int i=3; (long)i*i<=x; i+=2){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }
    
}