class Solution {
    private static final int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long odd = n/2;
        long even = (n+1)/2;
        long ans = (power(5, even) * power(4, odd)) % MOD;
        return (int) ans;
    }
    private long power(long base, long exponent) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent /= 2;
        }
        return result;
    }
}