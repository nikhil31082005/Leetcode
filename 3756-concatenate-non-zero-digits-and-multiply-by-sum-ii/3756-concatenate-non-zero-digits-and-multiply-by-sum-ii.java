class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int MOD = 1000000007;

        int[] idx = new int[n + 1];
        int[] val = new int[n + 1];
        int[] sum = new int[n + 1];
        int[] pow = new int[n + 1];

        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow[i] = (int)((long)pow[i - 1] * 10 % MOD);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                cnt++;
                val[cnt] = (int)(((long)val[cnt - 1] * 10 + d) % MOD);
                sum[cnt] = (sum[cnt - 1] + d) % MOD;
            }
            idx[i + 1] = cnt;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int a = idx[l];       // index before segment
            int b = idx[r + 1];   // index after segment

            if (a == b) {
                ans[i] = 0;
                continue;
            }

            int len = b - a; 

            int mul = (val[b] - (int)((long)val[a] * pow[len] % MOD) + MOD) % MOD;
            int total = (sum[b] - sum[a] + MOD) % MOD;

            ans[i] = (int)((long)mul * total % MOD);
        }

        return ans;
    }
}
