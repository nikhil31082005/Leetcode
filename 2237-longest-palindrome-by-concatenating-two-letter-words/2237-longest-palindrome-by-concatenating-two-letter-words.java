class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String st: words){
            map.put(st, map.getOrDefault(st, 0) + 1);
        }
        int count = 0;
        boolean check = false;
        for(String key: map.keySet()){
            if(key.charAt(0) == key.charAt(1)){
                if(map.get(key) < 2 && (!check)){
                    count += 2;
                    check = true;
                }
                else{
                    if(map.get(key) % 2 != 0 && !check){
                        count += 2 * map.get(key);
                        check = true;
                    }
                    else{
                        count += 4 * (map.get(key) / 2);
                    }
                }
            }
            else{
                String s = key.charAt(1) + "" + key.charAt(0);
                if(map.containsKey(s)){
                    count += 2 * Math.min(map.get(key), map.get(s));
                }
            }
        }
        return count;
    }
}