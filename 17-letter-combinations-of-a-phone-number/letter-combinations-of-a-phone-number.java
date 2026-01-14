class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String[] mapping = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz",
        };
        solve(digits, 0, result, mapping, new StringBuilder());
        return result;
    }

    public static void solve(String digits, int index, List<String> res, String[] mapping, StringBuilder str) {
        if(index == digits.length()) {
            res.add(str.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for(char l: letters.toCharArray()){
            str.append(l);
            solve(digits, index + 1, res, mapping, str);
            str.deleteCharAt(str.length() - 1);
        }
    }

}