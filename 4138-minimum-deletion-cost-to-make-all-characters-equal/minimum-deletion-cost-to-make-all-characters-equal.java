class Solution {
    public long minCost(String s, int[] cost) {
        long ans = 0;
        long charCost[] = new long[26];

        for(int i=0; i<s.length(); i++){
            int idx = s.charAt(i) - 'a';
            charCost[idx] += cost[i];
            ans += cost[i];
        }

        long minCost = Long.MAX_VALUE;

        for(int i=0; i<26; i++){
            if(charCost[i] > 0){
                minCost = Math.min(minCost, ans - charCost[i]);
            }
        }
        return minCost;
    }
}