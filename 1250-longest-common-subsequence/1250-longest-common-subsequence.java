class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                int ans = 0;
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    ans = dp[i-1][j-1] + 1;
                }
                else{
                    int c1 = dp[i-1][j];
                    int c2 = dp[i][j-1];
                    ans = Math.max(c1,c2);
                }
                dp[i][j] = ans;
            }
        }
        return dp[s1.length()][s2.length()];
    }
}