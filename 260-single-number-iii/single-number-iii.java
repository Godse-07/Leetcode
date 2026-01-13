/* 
    Step 1:
         XOR all numbers in the array.
         Because duplicates cancel out (x ^ x = 0),
         we will be left with: xor = a ^ b
         where 'a' and 'b' are the two unique numbers.
    
    Step 2:
         Find any bit where 'a' and 'b' are different.
         The rightmost set bit of xor tells us that.
         (xor & -xor) isolates the rightmost 1 bit.
         
         Example:
         xor = 6 (110)
         -xor = 2 (010)
         diff = 2 (010)

    Step 3:
         Use this 'diff' bit to divide all numbers
         into two groups:
         
         Group A: numbers where this bit = 1
         Group B: numbers where this bit = 0
         
         Since 'a' and 'b' differ at this bit,
         they will go into different groups.
         
         Duplicates will go into the same group
         and cancel out.

    If 'diff' bit is set in num → goes to group A
             Otherwise → goes to group B

    Step 4:
         After XOR inside each group,
         all duplicates are removed,
         and each group leaves only one unique number.
         
         So 'a' and 'b' are our answers.
*/

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int a:nums){
            xor^=a;
        }
        int mask=xor&(-xor);
        int xor1=0;
        int xor2=0;
        for(int i:nums){
            if((mask&i)==0){
                xor1^=i;
            }else{
                xor2^=i;
            }
        }
        return new int[]{xor1,xor2};
    }
}