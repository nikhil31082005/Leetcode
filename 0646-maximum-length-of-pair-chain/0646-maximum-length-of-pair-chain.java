class Solution {
    public int findLongestChain(int[][] activities) {
        Arrays.sort(activities, (a, b) -> {
            return a[0] - b[0];
        });

        int[] dp = new int[activities.length];
        Arrays.fill(dp, 1);

        for(int i=0;i<activities.length;i++){
            for(int j=i+1;j<activities.length;j++){
                if(activities[i][1] < activities[j][0]){
                    dp[j] = dp[i] + 1;
                }
            }
        }

        int max = 1;
        for(int ele: dp){
            max = Math.max(max, ele);
        }
        return max;
    }
}