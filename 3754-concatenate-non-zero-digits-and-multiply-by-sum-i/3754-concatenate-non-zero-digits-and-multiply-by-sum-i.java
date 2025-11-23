class Solution {
    public long sumAndMultiply(int n) {
        long mul = 0;
        long sum = 0;

        String s = String.valueOf(n);

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != '0') {
                mul = mul * 10 + (s.charAt(i) - '0');
                sum += s.charAt(i) - '0';
            }
        }
        return mul * sum;
    }
}