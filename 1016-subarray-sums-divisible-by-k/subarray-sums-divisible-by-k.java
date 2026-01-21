/*
Approach:
- We use the prefix sum technique.
- Let x be the current prefix sum and z be a previous prefix sum.
- If the subarray between them has sum divisible by k, then:
  (x - z) % k == 0
- This can be rewritten as:
  (x % k) - (z % k) == 0
  => x % k == z % k
- So, whenever two prefix sums have the same remainder modulo k,
  the subarray between them is divisible by k.
- While traversing the array, we maintain the running prefix sum.
- For each prefix sum, we compute its remainder modulo k.
- A HashMap stores each remainder and how many times it has appeared.
- Each time the same remainder appears again, we add its count to the answer.
- We initialize remainder 0 with count 1 to handle subarrays starting from index 0.
- Negative remainders are adjusted to positive to keep consistency.
- This approach runs in O(n) time and O(k) space.
*/

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> h1 = new HashMap<>();
        int sum = 0;
        h1.put(0, 1);
        int count = 0;
        for(int num: nums) {
            sum += num;
            int rem = sum % k;
            if(rem < 0) {
                rem = k + rem;
            }

            if(h1.containsKey(rem)) {
                count += h1.get(rem);
            }

            h1.put(rem, h1.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}