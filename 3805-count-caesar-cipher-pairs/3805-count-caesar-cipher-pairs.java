class Solution {
    public long countPairs(String[] words) {
        long ans = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for(String s: words) {
            char[] arr = s.toCharArray();
            int ch = arr[0] - 'a';

            for(int i = 0; i < s.length(); i++) {
                arr[i] = (char)((arr[i] - ch + 26) % 26);
            }

            String str = new String(arr);
            int c = map.getOrDefault(str, 0);
            ans += c;
            map.put(str, c + 1);
        }
        return ans;
    }
}