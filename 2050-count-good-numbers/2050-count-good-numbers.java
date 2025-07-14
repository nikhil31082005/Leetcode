class Solution {
    public int countGoodNumbers(long n) {
        long odd = n / 2;
        long even = (n + 1) / 2;

        long ans = (power(5, even) * power(4, odd)) % 1000000007;

        return (int)ans;
    }
    public long power(long n, long p){
        long res = 1;
        while(p > 0){
            if(p % 2 != 0){
                res = (res * n) % 1000000007;
            }
            n = (n * n) % 1000000007;
            p /= 2;
        }
        return res;
    }
}