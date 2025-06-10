class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int odd = 0;
        int even = Integer.MAX_VALUE;

        for(char key: map.keySet()){
            if(map.get(key) %  2 != 0){
                odd = Math.max(odd,map.get(key));
            }
            else{
                even = Math.min(even, map.get(key));
            }
        }
        return odd - even;
    }
}