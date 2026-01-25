class Solution {
    public long nthSmallest(long n, int k) {
        long[][] c = new long[60][60];
        for (int i = 0; i < 60; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= i; j++) c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
        }
        long ans = 0;
        for (; k > 0; k--) {
            int b = k - 1;
            while (n > c[b][k - 1]) {
                n -= c[b][k - 1];
                b++;
            }
            ans |= (1L << b);
        }
        return ans;
    }
}