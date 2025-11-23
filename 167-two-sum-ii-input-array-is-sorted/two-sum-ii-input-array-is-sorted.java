class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> h1 = new HashMap<>();
        int rem = 0;
        int one = -1;
        int two = -1;
        for(int i=0; i<numbers.length; i++){
            rem = target - numbers[i];
            System.out.println(rem);
            if(h1.containsKey(rem)){
                one = i + 1;
                two = h1.get(rem) + 1;
                break;
            }
           h1.put(numbers[i], i);
            
        }
        return new int[]{
            two, one
        };
    }
}