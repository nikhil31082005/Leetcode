class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = sortedString(n);

        for(int i = 0; i <= 31; i++) {
            String s = sortedString(1 << i);
            if(s.equals(target)) {
                return true;
            }
        }
        return false;
    }
    public String sortedString(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}