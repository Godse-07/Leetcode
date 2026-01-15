class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> h1 = new HashMap<>();
        for(String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if(!h1.containsKey(key)) {
                h1.put(key, new ArrayList<>());
            }
            h1.get(key).add(str);
        }
        return new ArrayList<>(h1.values());
    }
}