class Solution {
    public int twoEggDrop(int n) {
        int[][] dp = new int[n+1][3];
        for(int[] ele: dp){
            Arrays.fill(ele, -1);
        }
        return Egg_Drop2(n,2,dp);
    }
    public static int Egg_Drop2(int n, int e, int[][] dp){
        if(n == 0 || n == 1 || e == 1){
            return n;
        }
        if(dp[n][e] != -1){
            return dp[n][e];
        }
        int ans = Integer.MAX_VALUE;
        int lo = 1;
        int hi = n;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int left = Egg_Drop2(mid-1,e-1,dp);
            int right = Egg_Drop2(n-mid,e,dp);
            int t = Math.max(left, right) + 1;
            ans = Math.min(ans, t);
            if(left < right){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return dp[n][e] = ans;
    }
}