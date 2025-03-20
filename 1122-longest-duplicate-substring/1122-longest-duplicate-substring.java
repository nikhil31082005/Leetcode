class Solution {
    int m;
    int BASE = 27;
    long[] hash, pow;
    public String longestDupSubstring(String s) {
        m = s.length();
        pow = new long[m + 1];
        hash = new long[m + 1];
        pow[0] = 1;
        int ans = 0;
        for(int i = 0; i < m; i++) {
            pow[i + 1] = pow[i] * BASE;
        }
        for(int i = 0; i < m; i++) {
            hash[i + 1] = hash[i] * BASE + s.charAt(i);
        }
        int left = 1, right = m, index, startIndex = -1, sizeOfSubstringWithMaxLen = 0;
        while(left <= right) {
            int m = (left + right) >> 1;
            index = hasDuplicateSubstring(s, m);
            if(index != -1) {
                startIndex = index;
                sizeOfSubstringWithMaxLen = m;
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        System.out.println(startIndex);
        System.out.println(sizeOfSubstringWithMaxLen);
        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + sizeOfSubstringWithMaxLen);
    }

    public long getHashofSubstring(String s, int left, int right) {
        return (hash[right + 1] - hash[left] * pow[right - left + 1]);
    }

    public int hasDuplicateSubstring(String s, int size) {
        Map<Long, List<Integer>> map = new HashMap<>();
        long h;
        for(int i = 0; i + size <= s.length(); i++) {
            h = getHashofSubstring(s, i, i + size - 1);
            if (map.containsKey(h)) {
                map.get(h).add(i);
                return i;
            } 
            map.putIfAbsent(h, new ArrayList<>());
            map.get(h).add(i);
        }
        return -1;
    }
}