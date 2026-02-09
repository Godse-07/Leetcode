/*
Easy approach:
     1. Traverse the array from RIGHT to LEFT.
     2. Use a stack to keep possible '3' values (nums[j]).
        - The stack is kept in decreasing order.
     3. Use a variable 'second' to store the best possible '2' value (nums[k]).
     4. If we ever find a number smaller than 'second',
        then nums[i] < nums[k] < nums[j] exists → return true.
     5. If traversal finishes without this condition, return false.

*/

class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int second = Integer.MIN_VALUE;
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i] < second) {
                return true;
            }
            while(!st.isEmpty() && st.peek() < nums[i]) {
                second = st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
}