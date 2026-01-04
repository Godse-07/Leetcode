class Solution {
    public String largestEven(String s) {
        int n = s.length();
        if(s.charAt(n - 1) == '2'){
            return s;
        }
        for(int i=n-1; i>=0 ;i--){
            if(s.charAt(i) == '2'){
                return s.substring(0,i+1);
            }
        }
        return "";
    }
}