/*

Approach:
This solution uses the Prefix Sum technique with a HashMap.
As we traverse the array, we maintain a running sum.
If (currentSum - k) has appeared before, it means there exists a subarray
ending at the current index whose sum is k.

Key Idea:
subarraySum(i, j) = prefixSum[j] - prefixSum[i - 1]
If prefixSum[j] - k exists in the map, a valid subarray is found.

Why HashMap:
The map stores how many times each prefix sum has occurred,
allowing efficient counting in O(1) time per element.

*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
