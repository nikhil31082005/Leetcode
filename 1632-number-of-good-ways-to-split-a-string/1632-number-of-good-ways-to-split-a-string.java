class Solution {
    public int numSplits(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();

        int count = 0;
        for(int i=0;i<s.length();i++){
            map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0) + 1);
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            if(map.get(s.charAt(i)) == 0){
                map.remove(s.charAt(i));
            }

            if(map.size() == map2.size()){
                count++;
            }
        }
        return count;
    }
}