class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0;
        int count = 0;
        for(int end = 0; end < s.length(); end++){
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while(map.size() == 3){
                count += s.length() - end;
                char c = s.charAt(start);
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0){
                    map.remove(c);
                }
                start++;
            }
        }
        return count;
    }
}