class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0){
            return word2.length();
        }

        if(word2.length() == 0){
            return word1.length();
        }
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int[] arr: dp){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for(int i=0;i<dp.length;i++){
            dp[i][0] = i;
        }

        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = j;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int ans = 0;
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    ans = dp[i-1][j-1];
                }
                else{
                    int a = dp[i-1][j-1];
                    int b = dp[i-1][j];
                    int c = dp[i][j-1];

                    ans = Math.min(a, Math.min(b, c)) + 1;
                }
                dp[i][j] = ans;
            }
        }

        return dp[dp.length-1][dp[0].length -1];
        // return minDistance(word1, 0, word2, 0, dp);
    }


    // public int minDistance(String word1, String word2) {
    //     int[][] dp = new int[word1.length()][word2.length()];
    //     for(int[] arr: dp){
    //         Arrays.fill(arr, -1);
    //     }
    //     return minDistance(word1, 0, word2, 0, dp);
    // }
    // public int minDistance(String word1, int i, String word2, int j, int[][] dp){
    //     if(word1.length() == i){
    //         return word2.length() - j;
    //     }

    //     if(word2.length() == j){
    //         return word1.length() - i;
    //     }

    //     if(dp[i][j] != -1){
    //         return dp[i][j];
    //     }

    //     int ans = 0;
    //     if(word1.charAt(i) == word2.charAt(j)){
    //         ans = minDistance(word1, i+1, word2, j+1, dp);
    //     }
    //     else{
    //         int c1 = minDistance(word1, i+1, word2, j+1, dp);
    //         int c2 = minDistance(word1, i+1, word2, j, dp);
    //         int c3 = minDistance(word1, i, word2, j+1, dp);

    //         ans = Math.min(c1, Math.min(c2, c3)) + 1;
    //     }
    //     return dp[i][j] = ans;
    // }
}