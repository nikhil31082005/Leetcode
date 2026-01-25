class Solution {

    // Euclidean Algorithm
    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    // LCM using GCD
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;   // overflow-safe
    }

    public int nthUglyNumber(int n, int a, int b, int c) {

        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ac = lcm(a, c);
        long abc = lcm(ab, c);

        long lo = 1;
        long hi = (long) Math.min(a, Math.min(b, c)) * n; // safe upper bound
        long ans = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            long count =
                    mid / a + mid / b + mid / c
                  - mid / ab - mid / bc - mid / ac
                  + mid / abc;

            if (count >= n) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return (int) ans;
    }
}
