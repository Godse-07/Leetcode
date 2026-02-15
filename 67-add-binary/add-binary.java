class Solution {
    public String addBinary(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;
        int carry = 0;
        StringBuilder str = new StringBuilder();
        while(m >= 0 || n >= 0 || carry > 0) {
            int sum = carry;
            if(m >= 0) {
                sum += a.charAt(m) - '0';
            }
            if(n >= 0) {
                sum += b.charAt(n) - '0';
            }
            str.append(sum % 2);
            carry = sum / 2;
            m--;
            n--;
        }
        return str.reverse().toString();
    }
}