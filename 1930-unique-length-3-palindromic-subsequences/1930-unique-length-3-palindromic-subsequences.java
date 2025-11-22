class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for(int i=0;i<s.length();i++){
            int idx = s.charAt(i) - 'a';
            if(first[idx] == -1){
                first[idx] = i;
            }
            last[idx] = i;
        }

        int count = 0;
        for(int i=0;i<26;i++){
            if(first[i] == -1){
                continue;
            }
            HashSet<Character> set = new HashSet<>();
            for(int k = first[i] + 1 ; k < last[i] ; k++){
                set.add(s.charAt(k));
            }
            count += set.size();
        }
        return count;
    }
}