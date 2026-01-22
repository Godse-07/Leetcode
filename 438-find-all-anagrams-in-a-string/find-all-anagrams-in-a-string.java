class Solution {
    char[] sortedP;
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int k = p.length();
        List<Integer> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        sortedP = p.toCharArray();
        Arrays.sort(sortedP);
        while(j < n) {
            str.append(s.charAt(j));
            if(j - i + 1 < k) {
                j++;
            } else if(j - i + 1 == k) {
                if (isAnagram(str)) {
                    list.add(i);
                }
                str.deleteCharAt(0);
                i++;
                j++;
            }
        }
        return list;
    }

    boolean isAnagram(StringBuilder sb) {
        char[] temp = sb.toString().toCharArray();
        Arrays.sort(temp);

        return Arrays.equals(temp, sortedP);
    }

}