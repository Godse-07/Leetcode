class Solution {
    public int[] plusOne(int[] digits) {
        int rem = 1; 
        
        for(int i = digits.length - 1; i >= 0; i--){
            if(rem == 1){
                if(digits[i] == 9){
                    digits[i] = 0;
                    rem = 1;
                } else {
                    digits[i] = digits[i] + 1;
                    rem = 0;
                }
            }
        }
        
        if(rem == 1){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}