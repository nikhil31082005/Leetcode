class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), i);
        }
        int st = 0;
        int e = 0;
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            e = Math.max(e, map.get(ch));
            if(e == i){
                ls.add(e - st + 1);
                st = e + 1;
            }
        }
        return ls;
    }
}