class Solution {
    public int numSplits(String s) {
        int n = s.length();
        int left[] = new int[26];
        int right[] = new int[26];
        int goodSplit = 0;
        int leftDistinct = 0;
        int rightDistinct = 0;

        for(char c: s.toCharArray()) {
            right[c - 'a']++;
        }

        for(int r: right) {
            if(r > 0) {
                rightDistinct++;
            }
        }

        for(int i=0; i<n-1; i++) {
            int idx = (s.charAt(i) - 'a');
            if(left[idx] == 0) {
                leftDistinct++;
            }
            left[idx]++;
            right[idx]--;

            if(right[idx] == 0) {
                rightDistinct--;
            }

            if(leftDistinct == rightDistinct) {
                goodSplit++;
            }
        }
        return goodSplit;
    }
}