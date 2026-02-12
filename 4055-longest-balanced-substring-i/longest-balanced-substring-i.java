class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;
        for(int i=0;i<n;i++){
            int arr[] = new int[26];
            for(int j=i;j<n;j++){
                arr[s.charAt(j) - 'a']++;
                if(balanced(arr)){
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }

    public static boolean balanced(int arr[]){
        int val = 0;
        for(int a: arr){
            if(a > 0){
                if(val == 0){
                    val = a;
                }else if(val != a){
                    return false;
                }
            }
        }
        return true;
    }
    
}