class Solution {
    static final int MOD = 1_000_000_007;

    public int nthMagicalNumber(int n, int a, int b) {
        long lo = Math.min(a, b);
        long hi = (long) Math.min(a, b) * n;
        long ans = 0;

        long lcm = lcm((long)a, (long)b);

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            long count = mid / a + mid / b - mid / lcm;

            if (count < n) {
                lo = mid + 1;
            } else {
                ans = mid;
                hi = mid - 1;
            }
        }

        return (int)(ans % MOD);
    }

    public long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}
