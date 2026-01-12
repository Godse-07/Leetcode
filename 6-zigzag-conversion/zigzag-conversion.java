class Solution {
    public String convert(String s, int nums) {

        /*
        
    Example for 3 rows:

    P   A   H   N
    A P L S I I G
    Y   I   R

    Then read row by row → PAHNAPLSIIGYIR

    How the process works:
    - We create 'numRows' empty rows (buckets).
    - We start from row 0 and move downward (row 0 → row 1 → row 2).
    - When we reach the LAST row, we change direction and start moving UP.
    - When we reach the FIRST row, we again move DOWN.
    - This up & down movement creates the zigzag shape.
    - Each character is placed in the current row as we move.
    - In the end, we join all rows to form the final zigzag string.

    This solution uses:
    - An array of StringBuilders to store each row’s characters.
    - A 'row' pointer to track the current row.
    - A boolean 'goingDown' to switch direction when needed.

         */
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