class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int minimizeConcatenatedLength(String[] words) {
        char ps = words[0].charAt(0);
        char pe = words[0].charAt(words[0].length() - 1);
        return minLength(words, 1, ps, pe) + words[0].length();
    }
    public int minLength(String[] words, int idx, char ps, char pe){
        if(idx >= words.length){
            return 0;
        }

        String key = idx + " " + ps + " " + pe;

        if(map.containsKey(key)){
            return map.get(key);
        }

        char cs = words[idx].charAt(0);
        char ce = words[idx].charAt(words[idx].length() - 1);

        int len1 = words[idx].length();
        int len2 = words[idx].length();

        if(pe == cs) len1--;
        
        if(ps == ce) len2--;

        int ans1 = minLength(words, idx + 1, ps, ce) + len1;
        int ans2 = minLength(words, idx + 1, cs, pe) + len2;

        map.put(key, Math.min(ans1, ans2));

        return Math.min(ans1, ans2);
    }
}