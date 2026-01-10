class Solution {
    public long zeroFilledSubarray(int[] nums) {

        /*
        
            the formula is n * ( n + 1) / 2

            where n is the length of the array

            so my logic is to find the number of consecutive 0's

            then find the total combination using it and add it in the count variable

         */
        long length = 0;
        long count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                length++;
            }else{
                count += (length * (length + 1) / 2);
                System.out.println(count + " " + length);
                length = 0; 
            }
        }

        if(length != 0){
            count += (length * (length + 1) / 2);
        }
        return count;
    }

}