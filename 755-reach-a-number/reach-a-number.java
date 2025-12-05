class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0, steps = 0;

        /*
         Why do we check (sum - target) % 2 == 0 ?

         - After k moves, the total distance if we go only right is: sum = 1 + 2 + ... + k.
         - If we flip the direction of any move i (from +i to -i),
                the position changes by 2*i (always EVEN).
         - So we can only adjust the final position by an EVEN amount.
         - Therefore, we can reach target only when:
                (sum - target) is EVEN.
         - Keep adding steps until:
                1) sum >= target, and
                2) (sum - target) is EVEN.
        */

        while (sum < target || (sum - target) % 2 != 0) {
            steps++;
            sum += steps;
        }

        return steps;
    }
}
