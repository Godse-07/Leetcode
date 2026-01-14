class Solution {
    public boolean isIsomorphic(String s, String t) {
   HashMap<Character,Character> h1=new HashMap<>();
		Set<Character> set=new HashSet<>();
		int i=0;
		while(i<s.length()){
			char s1=s.charAt(i), s2=t.charAt(i);
			if(h1.containsKey(s1)){
				if(h1.get(s1)!=s2){
					return false;
				}
			}
			else{

				if(set.contains(s2)){
					return false;
				}

				h1.put(s1,s2);
				set.add(s2);
			}
			i++;
		}
		return true;
	}
}