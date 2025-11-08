class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0);
    }
    public boolean isMatch(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) return true;

        if (j == p.length()) return false;

        if (dp[i][j] != null) return dp[i][j];

        boolean res;

        if (j < p.length() && p.charAt(j) == '*') {
            boolean matchEmpty = isMatch(s, p, i, j + 1);
            boolean matchChar = (i < s.length()) && isMatch(s, p, i + 1, j);
            res = matchEmpty || matchChar;
        } 
        else if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
            res = isMatch(s, p, i + 1, j + 1);
        } 
        else {
            res = false;
        }

        return dp[i][j] = res;
    }
}