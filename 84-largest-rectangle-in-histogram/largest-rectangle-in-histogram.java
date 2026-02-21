class Solution {
    public int largestRectangleArea(int[] arr) {
        return helper(arr);
    }

    public static int helper(int arr[]) {
        int n = arr.length;

        int left[] = NSL(arr);
        int right[] = NSR(arr);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = arr[i] * width;
            max = Math.max(area, max);
        }

        return max;
    }

    public static int[] NSL(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int left[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = st.peek();
            }

            st.push(i);
        }

        return left;
    }

    public static int[] NSR(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int right[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                right[i] = arr.length;
            } else {
                right[i] = st.peek();
            }

            st.push(i);
        }

        return right;
    }
}