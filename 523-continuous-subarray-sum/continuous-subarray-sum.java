/*
Mathematical Reasoning:
- Let x be the prefix sum at index i and z be a prefix sum at an earlier index j.
- The sum of the subarray (j+1 to i) is: x - z
- This subarray sum is a multiple of k if:
  (x - z) % k == 0
- Which can be rewritten as:
  (x % k) - (z % k) == 0
  => x % k == z % k
- Therefore, if two prefix sums have the same remainder modulo k,
  the subarray between them has a sum that is a multiple of k.

Approach:
- Traverse the array while maintaining a running prefix sum.
- At each index, compute the remainder of the prefix sum modulo k.
- Store each remainder in a HashMap with the earliest index where it appears.
- If the same remainder appears again at index i, and the distance between
  the current index and the stored index is greater than 1, then a valid
  subarray of length at least 2 exists.
- Initialize remainder 0 with index -1 to handle subarrays starting from index 0.
- Return true immediately when a valid subarray is found.
- If traversal completes without finding such a subarray, return false.

Complexity:
- Time Complexity: O(n)
- Space Complexity: O(min(n, k))
*/
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> h1 = new HashMap<>();
        int sum = 0;
        h1.put(0, -1);
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            
            if(h1.containsKey(rem)) {
                if(i - h1.get(rem) > 1) {
                    return true;
                }
            }
            else {
                h1.put(rem, i);
            }
        }
        return false;
    }
}
