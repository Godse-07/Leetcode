class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> h1 = new HashMap<>();
        for(int num: nums2) {
            while(!st.isEmpty() && st.peek() < num) {
                h1.put(st.pop(), num);
            }
            st.push(num);
        }

        while(!st.isEmpty()) {
            h1.put(st.pop(), -1);
        }

        for(int i=0; i<nums1.length; i++) {
            nums1[i] = h1.get(nums1[i]);
        }
        return nums1;

    }
}