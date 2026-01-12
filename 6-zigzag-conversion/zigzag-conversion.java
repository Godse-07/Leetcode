class Solution {
    public String convert(String s, int nums) {
        if (nums == 1) return s;

        StringBuilder[] rows = new StringBuilder[nums];

        for (int i = 0; i < nums; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;

        boolean goingDown = true;

        for(char c: s.toCharArray()) {
            rows[row].append(c);

            if(row == 0){
                goingDown = true;
            } else if(row == nums - 1) {
                goingDown = false;
            }

            row += (goingDown ? 1 : -1);
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder r : rows) {
            result.append(r);
        }

        return result.toString();

    }
}