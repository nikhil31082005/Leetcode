class Solution {
    HashMap<String,Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String str: wordDict) {
            set.add(str);
        }
        return iscontain(s,set,"");
    }
    private boolean iscontain(String s, HashSet<String> wordDict, String ans) {
        if (s.length() == 0) {
            return wordDict.contains(ans);
        }

        if(map.containsKey(s)){
            return map.get(s);
        }

        boolean res = false;
        ans = "";
        for (int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0, i + 1);
            String suffix = s.substring(i + 1);

            if (wordDict.contains(prefix)) {
                res = res || iscontain(suffix, wordDict, ans + prefix);
            }
        }
        map.put(s,res);

        return res;
    }
}