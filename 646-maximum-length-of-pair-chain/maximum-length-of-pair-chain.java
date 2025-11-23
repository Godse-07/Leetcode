class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int lastRight = Integer.MIN_VALUE;
        for(int a[]: pairs){
            if(a[0] > lastRight){
                count++;
                lastRight = a[1];
            }
        }
        return count;
    }
}